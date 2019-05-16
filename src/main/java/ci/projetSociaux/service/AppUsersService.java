package ci.projetSociaux.service;

import ci.projetSociaux.entity.AppUsers;
import ci.projetSociaux.repository.AppUsersAuthDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "iAppUsersService")
public class AppUsersService implements IAppUsersService{

	@Autowired
	private AppUsersAuthDao userAuthDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<AppUsers> findAll() {
		// TODO Auto-generated method stub
		return (List<AppUsers>) userAuthDao.findAll();
	}

	@Override
	public void save(AppUsers userInfo) {
		// TODO Auto-generated method stub
		userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
		userInfo.setEnabled(1);
		userAuthDao.save(userInfo);
	}

	@Override
	public void mergeUser(AppUsers userInfo) {
		userAuthDao.save(userInfo);
	}

	@Override
	public void delete(AppUsers userInfo) {
		// TODO Auto-generated method stub
		userAuthDao.delete(userInfo);
	}



	@Override
	public AppUsers findByUsername(String username) {
		// TODO Auto-generated method stub
		return userAuthDao.findByUsername(username);
	}
	
	@Override
	public AppUsers findByEmail(String email) {
		// TODO Auto-generated method stub
		return userAuthDao.findByEmail(email);
	}

}
