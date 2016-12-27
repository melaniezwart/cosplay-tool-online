package nl.cto.service;

import nl.cto.entities.Location;
import nl.cto.entities.Material;
import nl.cto.repository.LocationRepository;
import nl.cto.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 13-12-2016.
 */
@Service
public class MaterialService {

	private static final Logger log = LoggerFactory.getLogger(MaterialService.class);

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private LocationRepository locationRepository;

	public Material getMaterialByName(String name){
		List<Material> materials = materialRepository.findByName(name);
		if(materials == null || materials.isEmpty()){
			System.out.println("Material not found");
			return null;
		} else if(materials.size() > 1){
			System.out.println("More than one, investigate");
			return null;
		}
		return materials.get(0);
	}

	public Material getMaterialById(long id){
		List<Material> materials = materialRepository.findById(id);
		if(materials == null || materials.isEmpty()){
			System.out.println("Material not found");
			return null;
		} else if (materials.size() > 1){
			System.out.println("More than one, investigate");
			return null;
		}
		return materials.get(0);
	}

	public Material addMaterial(Material material){
		materialRepository.addMaterial(material.getName(), calculateAveragePrice(material));
		Material persistedMaterial = getMaterialByName(material.getName());
		//Checks if material has an entry in Locations
		if(material.getMat_location() != null) {
			List<Location> locations = material.getMat_location();
			for (Location l : locations) {
				locationRepository.addLocation(l.getLocation(), Long.valueOf(persistedMaterial.getId()), l.getPrice());
			}
		}
		if(material.getAlt_materials() != null) {
			List<Material> altMaterials = material.getAlt_materials();
			for (Material m : altMaterials) {
				if(getMaterialById(m.getId()) != null){
					addMatToMat(m.getId(), persistedMaterial.getId());
				}
			}
		}
		return material;
	}

	private int calculateAveragePrice(Material material){
		List<Location> loc = material.getMat_location();
		if(loc.isEmpty() || loc == null) return 0;
		else {
			int total = 0;
			for(int i = 0 ; i < loc.size() ; i++){
				total += loc.get(i).getPrice();
			}
			total = total / loc.size();
			return total;
		}
	}

	public Material editMaterial(long id, Material material){
		checkLocationChange(id, material.getMat_location());
		checkMatToMatChange(id, material.getAlt_materials());
		materialRepository.editMaterial(id, material.getName(), calculateAveragePrice(material));
		return getMaterialById(id);
	}

	private void checkLocationChange(long matId, List<Location> newLocations){
		List<Location> locationsInDB = locationRepository.findLocationsByMatId(matId);
		for(int i = 0 ; i < newLocations.size() ; i++){
			if(!locationsInDB.contains(newLocations.get(i))){
				locationRepository.addLocation(newLocations.get(i).getLocation(), matId, newLocations.get(i).getPrice());
			}
		}
	}

	private void checkMatToMatChange(long matId, List<Material> altMaterials){
		long relId = 0;
		for(int i = 0 ; i < altMaterials.size() ; i++){
			relId += altMaterials.get(i).getId();
		}
		List<BigInteger> relations = materialRepository.findAllMatToMatById(matId);
		if(!relations.contains(BigInteger.valueOf(relId))){
			addMatToMat(matId, relId);
		}
	}

	/**
	 * Service methods to get and edit the Locations
     */

	public List<Location> getLocationsByMatId(long id){
		return locationRepository.findLocationsByMatId(id);
	}

	public Location getLocationById(long id){
		List<Location> locations = locationRepository.findById(id);
		if(locations.isEmpty() || locations == null){
			log.error("Not found");
		} else if (locations.size() > 1){
			log.error("More than one, investigate");
		}
		return locations.get(0);
	}

	public Location editLocation(long id, Location location){
		locationRepository.updateLocation(id, location.getLocation(), location.getPrice());
		Location loc = getLocationById(id);
		return loc;
	}

	public String deleteAllByMatId(long matId){
		locationRepository.deleteAllByMatId(matId);
		return "Successfully deleted all locations under material " + matId;
	}

	public String deleteById(long id){
		locationRepository.deleteById(id);
		return "Successfully deleted location " + id;
	}

	/**
	 * Service method for mat-to-mat relations
	 */
	public String addMatToMat(long id1, long id2){
		materialRepository.addMatToMat(id1, id2);
		materialRepository.addMatToMat(id2, id1);
		return "Successfully added relation";
	}

	public List<Material> getAllMatRelationsById(long id){
		List<Material> materialList = new ArrayList<>();
		List<BigInteger> idList = materialRepository.findAllMatToMatById(id);
		if(idList.isEmpty() || idList == null){
			log.warn("No relation found");
			return null;
		}
		else {
			for (BigInteger i : idList) {
				materialList.add(getMaterialById(i.longValue()));
			}
			return materialList;
		}
	}
}
