package nl.cto.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mzwart on 21-12-2016.
 */
public class CosplayProject {

	@Id
	@SequenceGenerator(name = "projectGen", sequenceName = "project_seq", allocationSize = 1)
	@GeneratedValue(generator = "projectGen")
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;


	@OneToMany(mappedBy = "mat_id", cascade = CascadeType.PERSIST)
	private List<Material> materials;

	@Column(name = "avg_price")
	private int avg_price;
}
