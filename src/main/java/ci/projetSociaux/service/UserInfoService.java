package ci.projetSociaux.service;

import ci.projetSociaux.entity.UserInfo;
import ci.projetSociaux.repository.UserAuthDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoService implements IUserInfoService{

	@Autowired
	private UserAuthDao userAuthDao;
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return (List<UserInfo>) userAuthDao.findAll();
	}

	@Override
	public void save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userAuthDao.save(userInfo);
	}

	@Override
	public void delete(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userAuthDao.delete(userInfo);
	}

	@Override
	public UserInfo findByUsername(String username) {
		// TODO Auto-generated method stub
		return userAuthDao.findByUsername(username);
	}
	
	@Override
	public UserInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		return userAuthDao.findByEmail(email);
	}

}
