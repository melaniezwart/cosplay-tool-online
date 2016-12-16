package util;

import nl.cto.entities.AltNames;
import nl.cto.entities.Location;
import nl.cto.entities.Material;
import nl.cto.entities.Price;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 14-12-2016.
 */
public class TestObjectHelper {

	public static Material getMaterial(){
		Material material = new Material();
		material.setName("Name");
		material.setAvg_price(10);
		material.setMat_alt_names(getAltNames(2));
		material.setMat_location(getLocations(2));
		material.setMat_price(getPrices(2));
		return material;
	}

	public static List<AltNames> getAltNames(int amount){
		List<AltNames> names = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			AltNames altNames = new AltNames();
			altNames.setName("Name"+i);
			names.add(altNames);
		}
		return names;
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

	public static List<Price> getPrices(int amount){
		List<Price> prices = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			Price price = new Price();
			price.setPrice("10");
			prices.add(price);
		}
		return prices;
	}
}
