package nl.service;

import nl.exceptions.MaterialNotFoundException;
import nl.entities.Material;
import nl.mappers.WebMaterialToMaterial;
import nl.repository.MaterialRepository;
import nl.web.WebMaterial;
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
	private WebMaterialToMaterial mapper = new WebMaterialToMaterial();

	public void registerMaterial(WebMaterial webMaterial){
		if(materialRepository.findOneByName(webMaterial.getName()) != null) return;
		else {
			Material material = mapper.toMaterial(webMaterial);
			material.setMatConnections(extractMatConnections(webMaterial));
			material = materialRepository.saveAndFlush(material);
			//Also sets the return connection, if any connections are set
			if(!material.getMatConnections().isEmpty() || material.getMatConnections() != null){
				for (Material m : material.getMatConnections()){
					addReturnConnection(m.getId(), material.getId());
				}
			}
		}
	}

	private List<Material> extractMatConnections(WebMaterial webMaterial){
		List<Material> materials = new ArrayList<>();
		for(Long id : webMaterial.getMatConnections()){
			materials.add(materialRepository.getOne(id));
		}
		return materials;
	}

	public Material findMaterialByName(String name) {
		Material material = materialRepository.findOneByName(name);
		if(material == null) throw new MaterialNotFoundException("Material with name " + name + " not found.");
		return material;
	}

	/*public List<Material> findConnectionsById(long materialId){
		List<MaterialMatConnections> matToMat = materialRepository.getConnections(materialId);
		List<Material> materials = new ArrayList<>();
		for(MaterialMatConnections u : matToMat){
			materials.add(materialRepository.findOne(u.getMatConnectionsId()));
		}
		return materials;
	}*/

	public Material findById(long id){
		return materialRepository.findOne(id);
	}

	public Material editMaterial(long id, Material material){
		Material persistentMaterial = materialRepository.findOne(id);
		persistentMaterial.setPrice(material.getPrice());
		persistentMaterial.setLocation(material.getLocation());
		persistentMaterial.setName(material.getName());
		materialRepository.flush();
		return materialRepository.findOne(id);
	}

	public void addReturnConnection(long material, long connectionId){
		Material existingMaterial = materialRepository.findOne(material);
		Material connectingMaterial = materialRepository.findOne(connectionId);
		existingMaterial.getMatConnections().add(connectingMaterial);
		materialRepository.flush();
	}

	public List<Material> findAll(){
		return materialRepository.findAll();
	}
}
