package nl.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mzwart on 6-1-2017.
 */
@Entity
public class CtoUser{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min=2, max=30)
	private String username;

	@NotNull
	@Size(min=2, max=30)
	private String password;

	private String role;

	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Person(Name: " + this.username + ", Password: " + this.password + ")";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*	public CtoUser(String username, String password, List<? extends GrantedAuthority> auths){
		super(username, password, auths);
		this.username = username;
		this.password = password;
	}*/

}
