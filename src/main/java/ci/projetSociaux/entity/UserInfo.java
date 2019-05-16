package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
@Table(name="app_users")
public class UserInfo implements Serializable {
	
		@Id
		@Column(name="username", unique=true)
		@Size(min=6, message="le nom d''utilisateur doit contenir au moins 6 caractères")
		private String userName;
		@Column(name="password")
		@Size(min=6, message="le mot de passe doit contenir au moins 6 caractères")
		private String password;
		@Email(message="adresse email invalide")
		@Column(name="email")	
		private String email;
		
		@Column(name="enabled")
		private short enabled;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public short getEnabled() {
			return enabled;
		}
		public void setEnabled(short enabled) {
			this.enabled = enabled;
		}
		public UserInfo() {
			super();
		}
		public UserInfo(String userName, String password, String email, short enabled) {
			super();
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.enabled = enabled;
		}

}
