package nl.cto.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mzwart on 9-12-2016.
 */
@Entity
public class Login {

	private String username;

	private String password;

	@Id
	private long ctoUserId;

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

	public long getCtoUserId() {
		return ctoUserId;
	}

	public void setCtoUserId(long ctoUserId) {
		this.ctoUserId = ctoUserId;
	}
}
