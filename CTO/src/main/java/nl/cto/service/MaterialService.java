package nl.cto.service;

import nl.cto.entities.AltNames;
import nl.cto.entities.Location;
import nl.cto.entities.Material;
import nl.cto.entities.Price;
import nl.cto.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mzwart on 13-12-2016.
 */
@Service
@Transactional
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private EntityManager em;

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

		List<AltNames> altNames = material.getMat_alt_names();
		for(AltNames a : altNames){
			a.setMat_id(material);
		}
		List<Location> locations = material.getMat_location();
		for(Location l : locations){
			l.setMat_id(material);
		}
		List<Price> prices = material.getMat_price();
		for(Price p : prices){
			p.setMat_id(material);
		}

		em.persist(material);

		return material;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Material editMaterial(long id, Material material){
		Material oldMaterial = em.find(Material.class, id);
		//This method doesn't find the foreign keys location, price and alt names. The repository method does.

		oldMaterial.setName(material.getName());
		oldMaterial.setAvg_price(material.getAvg_price());
		oldMaterial.setMat_location(material.getMat_location());
		oldMaterial.setMat_alt_names(material.getMat_alt_names());
		oldMaterial.setMat_price(material.getMat_price());
		em.flush();

		return getMaterialById(material.getId());
	}

}
