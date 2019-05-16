package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.AppRole;
import ci.projetSociaux.entity.AppUsers;
import ci.projetSociaux.service.AppRoleService;
import ci.projetSociaux.service.AppUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;



@Controller
@RequestMapping(value = "user")
public class AppUsersController {

	@Autowired
	private AppUsersService userInfoService;

	@Autowired
	private AppRoleService appRoleService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public String getAll(ModelMap modelMap) {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String voir = user.getAuthorities().;
		modelMap.put("user", user);
		modelMap.put("lesRoles", appRoleService.getAllRoles().stream().filter(r -> !(r.getRoleName().equals("ROLE_SUPERADMIN"))).collect(Collectors.toList()));
		modelMap.put("appUsers", new AppUsers());

		return "user/saveAppUsers";

	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String saveUser(AppUsers appUsers, @RequestParam("roleName") String roleName, ModelMap modelMap) {

		AppRole appRole = appRoleService.findRoleByRoleName(roleName);
		appUsers.setAppRole(appRole);

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String voir = user.getAuthorities().;
		modelMap.put("user", user);

		userInfoService.save(appUsers);
		return "redirect:/user/users";
	}

	/**
	 * methode d'affichage de tout les utilisateurs
	 * 
	 * @param modelMap
	 *            :modele a afficher est les utilisateurs
	 */
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String voir = user.getAuthorities().;
		//modelMap.put("users", userInfoService.findAll().stream().filter(u -> !(u.getUsername().equals("admin") || u.getUsername().equals(user.getUsername()))).collect(Collectors.toList()));
		modelMap.put("users", userInfoService.findAll().stream().filter(u -> !(u.getAppRole().getRoleName().equals("ROLE_SUPERADMIN") || u.getUsername().equals(user.getUsername()))).collect(Collectors.toList()));
	    modelMap.put("user", user);
	    
		//return "users/appUsers";

		return "user/appUsers";
		
	}

	/**
	 * methode de liason des champs de saisis de l utilisateur a la table
	 * utilisateur
	 * 
	 * @param modelMap
	 * @return
	 */
        /*
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    modelMap.put("connectedUser", user);
		modelMap.put("user", new AppUsers());
		return "user/saveUser";
	}
        */
	/**
	 * 
	 * @param user
	 * @param modelMap
	 * @return
	 */
        
        /*
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user") AppUsers user, BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			
			User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    modelMap.put("connectedUser", userConnected);
			return "user/saveUser";
		}
		else {
			if ( (userInfoService.findByUsername(user.getUsername())==null) && (userInfoService.findByEmail(user.getEmail())==null) ) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

				user.setPassword(encoder.encode(user.getPassword()));
				userInfoService.save(user);
				return "redirect:../user";
			}
			else {
				User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			    modelMap.put("connectedUser", userConnected);
			    modelMap.put("message", "Ce nom utilisateur / email est dejà utilisé");
				return "user/saveUser";
			}
		}

	}
        */
        

	/**
	 * Methode
	 * 
	 * @param username
	 * @return
	 */
       
	@RequestMapping(value = "users/delete/{username}", method = RequestMethod.GET)
	public String delete(@PathVariable("username") String username) {
		
		userInfoService.delete(userInfoService.findByUsername(username));
		return "redirect:/user/users";

	}


	@RequestMapping(value = "users/edit/{username}", method = RequestMethod.GET)
	public String edit(@PathVariable("username") String username, ModelMap modelMap) {
		User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelMap.put("user", userConnected);
		modelMap.put("lesRoles", appRoleService.getAllRoles().stream().filter(r -> !(r.getRoleName().equals("ROLE_SUPERADMIN"))).collect(Collectors.toList()));
		modelMap.put("appUsers", userInfoService.findByUsername(username));
		return "user/editAppUser";

	}


	@RequestMapping(value = "users/edit/{username}", method = RequestMethod.POST)
	public String editUser(@PathVariable("username") String username, AppUsers appUser, ModelMap modelMap) {

		AppUsers userCurrent = userInfoService.findByUsername(username);
		AppRole appRole = appRoleService.findRoleByRoleName(appUser.getAppRole().getRoleName());
		
		userCurrent.setAppRole(appRole);
		userCurrent.setEmail(appUser.getEmail());
		userCurrent.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
		
		userInfoService.mergeUser(userCurrent);

		return "redirect:/user/users";
	}

	@RequestMapping(path = "/profil", method = RequestMethod.GET)
    public String getAllAppRole(Model model) {
        
        List<AppRole> allAppRole = (List<AppRole>) appRoleService.getAllRoles();
        model.addAttribute("allAppRole", allAppRole);
        model.addAttribute("appRole", new AppRole());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user/profil.html";
    }
	
	@RequestMapping(path = "profil/edit/{username}", method = RequestMethod.GET)
    public String editAppRole(@PathVariable("username") String username,Model model) {
        model.addAttribute("appRole", appRoleService.findRoleByRoleName(username));       
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user/editProfil.html";
    }
	
	@RequestMapping(path = "profil/edit/{username}", method = RequestMethod.POST)
    public String PeditAppRole(@PathVariable("username") String username,Model model,AppRole appRole) {
        
		AppRole roleCurrent = appRoleService.findRoleByRoleName(username);
		
		roleCurrent.setRoleDescription(appRole.getRoleDescription());
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        appRoleService.saveRole(roleCurrent);
        return "redirect:/user/profil";
    }


}
