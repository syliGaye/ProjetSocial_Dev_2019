package ci.projetSociaux.repository;

import ci.projetSociaux.entity.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface AppUsersAuthDao  extends JpaRepository<AppUsers, String>{

	@Transactional
	@Query(value="SELECT * FROM app_users where username=:username ",nativeQuery=true)
	public AppUsers findByUsername(@Param("username") String username);
	
	@Transactional
	@Query(value="SELECT * FROM app_users where email=:email ",nativeQuery=true)
	public AppUsers findByEmail(@Param("email") String email);
	
}
