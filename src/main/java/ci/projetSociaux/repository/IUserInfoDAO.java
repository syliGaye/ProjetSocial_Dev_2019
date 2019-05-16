package ci.projetSociaux.repository;

import ci.projetSociaux.entity.UserInfo;



public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);

}