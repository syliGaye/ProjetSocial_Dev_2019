package ci.projetSociaux.controllerWeb;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String login(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    /* Cas où l'utilisateur est connecté */
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			modelMap.put("user", user);
		    return "home";
		}else {
			/* Cas de non connexion */
			return "login";
		}
		
	}
	
	//@RequestMapping(value = "/app-logout", method = RequestMethod.GET)
	@RequestMapping(value={"/logoutsuccessful"})
	public String logout(ModelMap modelMap) {
		
			return "login.html";
	}

}
