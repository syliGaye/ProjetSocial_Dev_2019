package ci.projetSociaux.repository;

import ci.projetSociaux.entity.AppUsers;



public interface IAppUsersDAO {
	AppUsers getActiveUser(String userName);

}