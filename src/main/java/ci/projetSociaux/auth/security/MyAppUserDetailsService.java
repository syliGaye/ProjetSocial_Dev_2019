package ci.projetSociaux.auth.security;

import ci.projetSociaux.entity.AppUsers;
import ci.projetSociaux.repository.IAppUsersDAO;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private IAppUsersDAO userInfoDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		AppUsers activeUserInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getAppRole().getRoleName());
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getUsername(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}

