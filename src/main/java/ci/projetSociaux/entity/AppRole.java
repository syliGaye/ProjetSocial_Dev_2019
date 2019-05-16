/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ORA PLUS
 */
@Entity
@Table(name = "app_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppRole.findAll", query = "SELECT a FROM AppRole a")
    , @NamedQuery(name = "AppRole.findByRoleId", query = "SELECT a FROM AppRole a WHERE a.roleId = :roleId")
    , @NamedQuery(name = "AppRole.findByRoleName", query = "SELECT a FROM AppRole a WHERE a.roleName = :roleName")
    , @NamedQuery(name = "AppRole.findByRoleDescription", query = "SELECT a FROM AppRole a WHERE a.roleDescription = :roleDescription")})
public class AppRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "role_name")
    private String roleName;
    @Size(max = 255)
    @Column(name = "role_description")
    private String roleDescription;

    public AppRole() {
    }

    public AppRole(Integer roleId) {
        this.roleId = roleId;
    }

    public AppRole(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppRole)) {
            return false;
        }
        AppRole other = (AppRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.AppRole[ roleId=" + roleId + " ]";
    }
    
}
