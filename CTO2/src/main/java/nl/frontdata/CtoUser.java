package nl.frontdata;

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
public class CtoUser {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min=2, max=30)
	private String username;

	@NotNull
	@Size(min=2, max=30)
	private String password;

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

}
