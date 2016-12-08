package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by mzwart on 8-12-2016.
 */
@Entity
@Table(name= "CTO_USER")
@NamedQueries({
	@NamedQuery(name = "User.getByUsername", query = "SELECT u FROM CTO_USER WHERE u.username = :username")
})
public class User {

	@Id
	@SequenceGenerator(name = "userGen", sequenceName = "user_seq", allocationSize = 1)
	@GeneratedValue(generator = "userGen")
	@Column(name = "id")
	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "datejoined")
	private LocalDateTime datejoined;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDatejoined() {
		return datejoined;
	}

	public void setDatejoined(LocalDateTime datejoined) {
		this.datejoined = datejoined;
	}
}
