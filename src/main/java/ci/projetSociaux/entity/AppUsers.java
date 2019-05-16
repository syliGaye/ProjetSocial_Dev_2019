/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "app_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUsers.findAll", query = "SELECT a FROM AppUsers a")
    , @NamedQuery(name = "AppUsers.findByUsername", query = "SELECT a FROM AppUsers a WHERE a.username = :username")
    , @NamedQuery(name = "AppUsers.findByEmail", query = "SELECT a FROM AppUsers a WHERE a.email = :email")
    , @NamedQuery(name = "AppUsers.findByEnabled", query = "SELECT a FROM AppUsers a WHERE a.enabled = :enabled")
    , @NamedQuery(name = "AppUsers.findByPassword", query = "SELECT a FROM AppUsers a WHERE a.password = :password")})
public class AppUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private Integer enabled;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @JsonManagedReference
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false)
    private AppRole appRole;

    public AppUsers() {
    }

    public AppUsers(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUsers)) {
            return false;
        }
        AppUsers other = (AppUsers) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User[ username=" + username + "," +
                " email=" + email + ", role=" + appRole.getRoleName() + "]";
    }
    
}
