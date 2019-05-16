package ci.projetSociaux.repository;

import ci.projetSociaux.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    @Query("select role from AppRole role where role.roleName = :roleName")
    AppRole findByRoleName(@Param("roleName") String roleName);

    @Query("select role from AppRole role")
    Stream<AppRole> getAllRolesStream();// Java8 Stream
}


