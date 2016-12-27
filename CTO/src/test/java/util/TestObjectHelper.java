package util;

import nl.cto.entities.Location;
import nl.cto.entities.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 14-12-2016.
 */
public class TestObjectHelper {

	public static Material getMaterial() {
		Material material = new Material();
		material.setName("Name");
		material.setAvg_price(10);
		material.setMat_location(getLocations(2));
		return material;
	}

	public static List<Location> getLocations(int amount){
		List<Location> locations = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			Location location = new Location();
			location.setLocation("Here"+i);
			locations.add(location);
		}
		return locations;
	}
}
