package nl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mzwart on 10-1-2017.
 */
@Entity
public class UserConnections implements Serializable{

	@Id
	private long userId1;
	@Id
	private long userId2;

	public long getCtoUser() {
		return userId1;
	}

	public void setCtoUser(long ctoUser) {
		this.userId1 = ctoUser;
	}

	public long getUserConnection() {
		return userId2;
	}

	public void setUserConnection(long userConnection) {
		this.userId2 = userConnection;
	}
}
