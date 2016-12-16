package nl.cto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mzwart on 9-12-2016.
 */
@Entity
@Table(name = "LOGIN")
public class LoginValues {

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public String getUsername() {
		return username;
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
}
