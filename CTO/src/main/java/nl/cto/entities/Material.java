package nl.cto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	@JsonBackReference
	@JoinTable(name = "cto_mat_to_mat", joinColumns = {
		@JoinColumn(name = "mat_id1", referencedColumnName = "id")}, inverseJoinColumns = {
		@JoinColumn(name = "mat_id2", referencedColumnName = "id")})
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Material> alt_materials;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "mat_id", cascade = CascadeType.ALL)
	private List<Location> mat_location;

	@Column(name = "avg_price")
	private int avg_price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Location> getMat_location() {
		return mat_location;
	}

	public void setMat_location(List<Location> mat_location) {
		this.mat_location = mat_location;
	}

	public List<Material> getAlt_materials() {
		return alt_materials;
	}

	public void setAlt_materials(List<Material> alt_materials) {
		this.alt_materials = alt_materials;
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
