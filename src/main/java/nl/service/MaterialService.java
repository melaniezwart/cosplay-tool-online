package nl.service;

import nl.entities.MatConnections;
import nl.exceptions.MaterialNotFoundException;
import nl.entities.Material;
import nl.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 9-1-2017.
 * Service class for all rest calls related to getting and creating materials and its values
 */
@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	public void registerMaterial(Material material){
		if(materialRepository.findOneByName(material.getName()) != null) return;
		else materialRepository.saveAndFlush(material);
	}

	public Material findMaterialByName(String name) {
		Material material = materialRepository.findOneByName(name);
		if(material == null) throw new MaterialNotFoundException("Material with name " + name + " not found.");
		return material;
	}

	public List<Material> findConnectionsById(long materialId){
		List<MatConnections> matToMat = materialRepository.getConnections(materialId);
		List<Material> materials = new ArrayList<>();
		for(MatConnections u : matToMat){
			materials.add(materialRepository.findOne(u.getMatId2()));
		}
		return materials;
	}

	public Material findById(long id){
		return materialRepository.findOne(id);
	}
}
