package ci.projetSociaux.repository;

import ci.projetSociaux.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface UserAuthDao  extends CrudRepository<UserInfo, String>{

	@	Transactional
	@Query(value="SELECT * FROM app_users where username=:username ",nativeQuery=true)
	public UserInfo findByUsername(@Param("username") String userName);
	
	@	Transactional
	@Query(value="SELECT * FROM app_users where email=:email ",nativeQuery=true)
	public UserInfo findByEmail(@Param("email") String email);
	
}
