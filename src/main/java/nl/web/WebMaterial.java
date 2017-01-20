package nl.web;

import nl.entities.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 20-1-2017.
 */
public class WebMaterial {

	private long id;

	private String name;
	private int price;
	private String location;

	private List<Long> matConnections = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Long> getMatConnections() {
		return matConnections;
	}

	public void setMatConnections(List<Long> matConnections) {
		this.matConnections = matConnections;
	}
}
