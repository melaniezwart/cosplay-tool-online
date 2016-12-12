package nl.cto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import org.joda.time.LocalDateTime;

import java.sql.Timestamp;

/**
 * Created by mzwart on 8-12-2016.
 */
@Entity
@Table(name= "CTO_USER")
@NamedQueries({
	@NamedQuery(name = "CtoUser.getByUsername", query = "SELECT u FROM CtoUser u WHERE u.username = :username")
})
public class CtoUser {

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

	@Column(name = "datejoined", columnDefinition = "DATE")
	private Timestamp datejoined;

	public CtoUser(String username, String password){
		this.username = username;
		this.password = password;
	}

	public CtoUser(){

	}

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

	@JsonIgnore
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

	public Timestamp getDatejoined() {
		return datejoined;
	}

	public void setDatejoined(Timestamp datejoined) {
		this.datejoined = datejoined;
	}
}
