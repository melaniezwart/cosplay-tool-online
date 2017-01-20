package nl.mappers;

import nl.entities.MaterialMatConnections;
import nl.entities.Material;
import nl.web.WebMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 20-1-2017.
 */
public class WebMaterialToMaterial {

	public Material toMaterial(WebMaterial webMaterial){
		Material material = new Material();
		material.setName(webMaterial.getName());
		material.setLocation(webMaterial.getLocation());
		material.setPrice(webMaterial.getPrice());
		return material;
	}

	public List<MaterialMatConnections> toMatConnections(List<Material> materialList, Material material){
		List<MaterialMatConnections> materialMatConnections = new ArrayList<>();
		for (Material m : materialList){
			materialMatConnections.add(new MaterialMatConnections(material.getId(), m.getId()));
			materialMatConnections.add(new MaterialMatConnections(m.getId(), material.getId()));
		}
		return materialMatConnections;
	}
}
