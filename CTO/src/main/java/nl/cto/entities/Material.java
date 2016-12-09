package nl.cto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by mzwart on 8-12-2016.
 */
@Entity
public class Material {

	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private int cost;
}
