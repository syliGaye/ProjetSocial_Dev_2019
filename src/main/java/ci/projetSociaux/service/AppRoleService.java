package ci.projetSociaux.service;
import ci.projetSociaux.entity.AppRole;

import java.util.List;
import java.util.stream.Stream;

public interface AppRoleService {
	
	AppRole findRoleByRoleName(String roleName);

	List<AppRole> getAllRoles();

	Stream<AppRole> getAllRolesStream();

	void saveRole(AppRole appRole);

}