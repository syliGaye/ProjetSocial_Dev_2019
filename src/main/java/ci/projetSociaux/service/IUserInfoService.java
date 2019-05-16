package ci.projetSociaux.service;

import ci.projetSociaux.entity.UserInfo;
import java.util.List;




public interface IUserInfoService {

public List <UserInfo>findAll();
	
	//public UserInfo find (String userName);
	
	public void save(UserInfo userInfo );
	
	public void delete(UserInfo  userInfo);
	public UserInfo findByUsername( String userName);
	public UserInfo findByEmail( String email);
}
