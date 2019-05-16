package ci.projetSociaux.repository;
import ci.projetSociaux.entity.AppUsers;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




@Repository
@Transactional
public class AppUsersDAO implements IAppUsersDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public AppUsers getActiveUser(String userName) {
		AppUsers activeUserInfo = new AppUsers();
		int enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM AppUsers u WHERE userName=:username and enabled=:enabled")
				.setParameter("username", userName)
				.setParameter("enabled", enabled)
				.getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (AppUsers)list.get(0);
		}
		return activeUserInfo;
	}
	
}