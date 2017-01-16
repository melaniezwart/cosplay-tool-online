package nl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mzwart on 10-1-2017.
 */
@Entity
public class MatConnections implements Serializable {

	@Id
	private long matId1;
	@Id
	private long matId2;

	public long getMatId1() {
		return matId1;
	}

	public void setMatId1(long matId1) {
		this.matId1 = matId1;
	}

	public long getMatId2() {
		return matId2;
	}

	public void setMatId2(long matId2) {
		this.matId2 = matId2;
	}
}
