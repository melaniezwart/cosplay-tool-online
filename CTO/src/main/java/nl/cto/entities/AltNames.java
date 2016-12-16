package nl.cto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mzwart on 14-12-2016.
 */
@Entity
@Table(name= "MAT_ALT_NAMES")
public class AltNames{

	@Id
	@SequenceGenerator(name = "altGen", sequenceName = "alt_seq", allocationSize = 1)
	@GeneratedValue(generator = "altGen")
	@Column(name = "id")
	private long id;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mat_id", nullable = false)
	private Material mat_id;
	@Column(name = "name")
	private String name;

	public Material getMat_id() {
		return mat_id;
	}
	public void setMat_id(Material mat_id) {
		this.mat_id = mat_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
