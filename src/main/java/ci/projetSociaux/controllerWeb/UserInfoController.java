package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogSol;
import ci.projetSociaux.entity.PmtLogToilette;
import ci.projetSociaux.entity.UserInfo;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ci.projetSociaux.service.IUserInfoService;





@Controller

@RequestMapping(value = "user")
public class UserInfoController {
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * methode d'affichage de tout les utilisateurs
	 * 
	 * @param modelMap
	 *            :modele a afficher est les utilisateurs
	 */
	@RequestMapping(method = RequestMethod.GET)

	public String index(ModelMap modelMap) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		modelMap.put("users", userInfoService.findAll().stream().filter(u -> !(u.getUserName().equals("admin") || u.getUserName().equals(user.getUsername()))).collect(Collectors.toList()));
	    modelMap.put("user", user);
	    
		return "user/users";
		
	}

	/**
	 * methode de liason des champs de saisis de l utilisateur a la table
	 * utilisateur
	 * 
	 * @param modelMap
	 * @return
	 */
	
	@RequestMapping(path = "/liste", method = RequestMethod.GET)
    public String getApp_users(Model model) {
        
        List<UserInfo> allUserInfo = (List<UserInfo>) userInfoService.findAll();
        model.addAttribute("allUserInfo", allUserInfo);
        model.addAttribute("userInfo", new UserInfo());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       model.addAttribute("user", user);
        return "admin/listeUsers.html";
    }
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		  
        List<UserInfo> allUserInfo = (List<UserInfo>) userInfoService.findAll();
        modelMap.addAttribute("allUserInfo", allUserInfo);
        modelMap.addAttribute("userInfo", new UserInfo());        
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelMap.addAttribute("user", user);
		//modelMap.addAttribute("user", new UserInfo());
		
		return "admin/saveUser";
	}

	/**
	 * 
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user") UserInfo user, BindingResult bindingResult, ModelMap modelMap) {
		List<UserInfo> allUserInfo = (List<UserInfo>) userInfoService.findAll();
        modelMap.addAttribute("allUserInfo", allUserInfo);
        modelMap.addAttribute("userInfo", new UserInfo());
		if (bindingResult.hasErrors()) {
			
			User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    modelMap.put("connectedUser", userConnected);
			return "user/saveUser";
		}
		else {
			if ( (userInfoService.findByUsername(user.getUserName())==null) && (userInfoService.findByEmail(user.getEmail())==null) ) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

				user.setPassword(encoder.encode(user.getPassword()));
				userInfoService.save(user);
				return "redirect:user/listeUsers";
			}
			else {
				User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			    modelMap.put("connectedUser", userConnected);
			    modelMap.put("message", "Ce nom utilisateur / email est dejà utilisé");
				return "user/saveUser";
			}
		}

	}

	/**
	 * Methode
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{username}", method = RequestMethod.GET)
	public String delete(@PathVariable("username") String username) {
		
		userInfoService.delete(userInfoService.findByUsername(username));
		return "redirect:/user";

	}

	/**
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "edit/{username}", method = RequestMethod.GET)
	public String edit(@PathVariable("username") String username, ModelMap modelMap) {
		User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    modelMap.put("connectedUser", userConnected);
		modelMap.put("user", userInfoService.findByUsername(username));
		return "user/editUser";

	}

	@RequestMapping(value = "edit/{username}", method = RequestMethod.POST)
	public String editUser(@PathVariable("username") String username, UserInfo user, ModelMap modelMap) {

		UserInfo userCurrent = userInfoService.findByUsername(username);
		
		//userCurrent.setRole(user.getRole());
		userCurrent.setEmail(user.getEmail());
		userCurrent.setEnabled(user.getEnabled());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (user.getPassword()!="") {
			userCurrent.setPassword(encoder.encode(user.getPassword()));
		}

		userInfoService.save(userCurrent);
		
		User userConnected = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    modelMap.put("connectedUser", userConnected);
		
		return "redirect:/user";
	}

}
