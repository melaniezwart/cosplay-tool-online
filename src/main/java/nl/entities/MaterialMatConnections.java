package nl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mzwart on 10-1-2017.
 */
@Entity
public class MaterialMatConnections implements Serializable {

	@Id
	private Long material_id;
	@Id
	private Long mat_connections_id;

	public Long getMaterialId() {
		return material_id;
	}

	public void setMaterialId(Long material_id) {
		this.material_id = material_id;
	}

	public Long getMatConnectionsId() {
		return mat_connections_id;
	}

	public void setMatConnectionsId(Long mat_connections_id) {
		this.mat_connections_id = mat_connections_id;
	}

	public MaterialMatConnections (long materialId, long matConnectionsId){
		setMaterialId(materialId);
		setMatConnectionsId(matConnectionsId);
	}

	public MaterialMatConnections(){

	}
}
