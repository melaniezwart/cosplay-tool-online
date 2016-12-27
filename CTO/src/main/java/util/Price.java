package util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.cto.entities.Material;

import javax.persistence.*;

/**
 * Created by mzwart on 14-12-2016.
 */
@Entity
@Table(name= "MAT_PRICE")
public class Price{

	@Id
	@SequenceGenerator(name = "priceGen", sequenceName = "price_seq", allocationSize = 1)
	@GeneratedValue(generator = "priceGen")
	@Column(name = "id")
	private long id;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mat_id", nullable = false)
	private Material mat_id;

	@Column(name = "price")
	private String price;

	public Material getMat_id() {
		return mat_id;
	}
	public void setMat_id(Material mat_id) {
		this.mat_id = mat_id;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
