package nl.cto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * Created by mzwart on 8-12-2016.
 */
@Entity
@Table(name= "CTO_USER")
//@NamedQueries({
//	@NamedQuery(name = "CtoUser.getByUsername", query = "SELECT u FROM CtoUser u WHERE u.username = :username")
//})
public class CtoUser {

	@Id
	@SequenceGenerator(name = "userGen", sequenceName = "user_seq", allocationSize = 1)
	@GeneratedValue(generator = "userGen")
	@Column(name = "id")
	private long id;

	@Column(name = "cto_username")
	private String ctoUsername;

	@Column(name = "email")
	private String email;

	@Column(name = "datejoined", columnDefinition = "DATE")
	private Timestamp datejoined;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCtoUsername() {
		return ctoUsername;
	}

	public void setCtoUsername(String ctoUsername) {
		this.ctoUsername = ctoUsername;
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
