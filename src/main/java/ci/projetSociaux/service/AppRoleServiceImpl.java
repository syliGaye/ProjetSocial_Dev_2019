package ci.projetSociaux.service;
import ci.projetSociaux.entity.AppRole;
import ci.projetSociaux.repository.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Transactional
@Service(value = "appRoleService")
public class AppRoleServiceImpl implements AppRoleService {
	
	@Autowired
	private AppRoleRepository appRoleRepository;

	@Override
	public List<AppRole> getAllRoles() {
		return appRoleRepository.findAll();
	}
	
	@Override
	public Stream<AppRole> getAllRolesStream() {
		return appRoleRepository.getAllRolesStream();
	}

	@Override
	public void saveRole(AppRole role) {
		appRoleRepository.save(role);
	}

	@Override
	public AppRole findRoleByRoleName(String roleName) {
		return appRoleRepository.findByRoleName(roleName);
	}
}

