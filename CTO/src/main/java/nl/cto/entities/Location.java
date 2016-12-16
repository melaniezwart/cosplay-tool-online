package nl.cto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mzwart on 14-12-2016.
 */
@Entity
@Table(name= "MAT_LOCATION")
public class Location{
	@Id
	@SequenceGenerator(name = "locationGen", sequenceName = "location_seq", allocationSize = 1)
	@GeneratedValue(generator = "locationGen")
	@Column(name = "id")
	private long id;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mat_id", nullable = false)
	private Material mat_id;
	@Column(name = "location")
	private String location;

	public Material getMat_id() {
		return mat_id;
	}

	public void setMat_id(Material mat_id) {
		this.mat_id = mat_id;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
