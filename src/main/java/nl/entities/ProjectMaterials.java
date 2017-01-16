package nl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mzwart on 11-1-2017.
 */
@Entity
public class ProjectMaterials implements Serializable{

	@Id
	private Long ProjectId;
	@Id
	private Long MaterialId;

	public long getProjectId() {
		return ProjectId;
	}

	public void setProjectId(long projectId) {
		ProjectId = projectId;
	}

	public long getMaterialId() {
		return MaterialId;
	}

	public void setMaterialId(long materialId) {
		MaterialId = materialId;
	}
}
