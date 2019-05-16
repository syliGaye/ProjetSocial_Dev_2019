package ci.projetSociaux.service;

import ci.projetSociaux.entity.AppUsers;
import java.util.List;




public interface IAppUsersService {


	List <AppUsers>findAll();

	void save(AppUsers userInfo);

	void mergeUser(AppUsers userInfo);
	
	void delete(AppUsers userInfo);

	AppUsers findByUsername(String userName);

	AppUsers findByEmail(String email);
}
