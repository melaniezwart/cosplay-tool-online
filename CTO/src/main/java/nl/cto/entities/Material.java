package nl.cto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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


	@OneToMany(mappedBy = "mat_id", cascade = CascadeType.PERSIST)
	private List<AltNames> mat_alt_names;

	@OneToMany(mappedBy = "mat_id", cascade = CascadeType.PERSIST)
	private List<Price> mat_price;

	@OneToMany(mappedBy = "mat_id", cascade = CascadeType.PERSIST)
	private List<Location> mat_location;

	@Column(name = "avg_price")
	private int avg_price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<AltNames> getMat_alt_names() {
		return mat_alt_names;
	}

	public void setMat_alt_names(List<AltNames> mat_alt_names) {
		this.mat_alt_names = mat_alt_names;
	}

	public List<Price> getMat_price() {
		return mat_price;
	}

	public void setMat_price(List<Price> mat_price) {
		this.mat_price = mat_price;
	}

	public List<Location> getMat_location() {
		return mat_location;
	}

	public void setMat_location(List<Location> mat_location) {
		this.mat_location = mat_location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvg_price() {
		return avg_price;
	}

	public void setAvg_price(int avg_price) {
		this.avg_price = avg_price;
	}
}
