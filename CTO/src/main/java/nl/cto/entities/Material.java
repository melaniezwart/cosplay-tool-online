package nl.cto.entities;

import javax.persistence.*;

/**
 * Created by mzwart on 8-12-2016.
 */
@Entity
@Table(name= "MATERIAL")
public class Material {

	@Id
	@SequenceGenerator(name = "materialGen", sequenceName = "material_seq", allocationSize = 1)
	@GeneratedValue(generator = "materialGen")
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private int cost;
}
