package nl.cto.rest;

import nl.cto.entities.Location;
import nl.cto.entities.Material;
import nl.cto.service.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by mzwart on 13-12-2016.
 */
@Controller
@RequestMapping("material")
public class MaterialRestController {

	@Autowired
	private MaterialService materialService;

	private static final Logger logger = LoggerFactory.getLogger(MaterialRestController.class);

	@RequestMapping(value = "get/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getMaterial(@PathVariable("name") String name){
		Material material = materialService.getMaterialByName(name);
		if(material == null){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(material, HttpStatus.OK);
	}

	@RequestMapping(value = "addmaterial", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addmaterial(@RequestBody Material material){
		if(materialService.getMaterialByName(material.getName()) != null){
			return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
		} else if (material == null){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Material returnMaterial = materialService.addMaterial(material);
		return new ResponseEntity<>(returnMaterial, HttpStatus.OK);
	}

	@RequestMapping(value = "editmaterial/{mat_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getEditMaterial(@PathVariable("mat_id") long id){
		Material material = materialService.getMaterialById(id);
		if(material == null){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(material, HttpStatus.OK);
	}

	@RequestMapping(value = "editmaterial/{mat_id}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> postEditMaterial(@PathVariable("mat_id") String id, @RequestBody Material material){
		Material returnMaterial = materialService.editMaterial(Long.valueOf(id), material);
		return new ResponseEntity<>(returnMaterial, HttpStatus.OK);
	}

	/*
	Testing if you can edit locations based on id or material id. Delete later
	 */
	@RequestMapping(value = "getlocations/{mat_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getLocationsByMatId(@PathVariable("mat_id") long id){
		List<Location> locations = materialService.getLocationsByMatId(id);
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}

	@RequestMapping(value = "editlocation/{loc_id}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> postEditLocation(@PathVariable("loc_id") String id, @RequestBody Location location){
		Location returnLocation = materialService.editLocation(Long.valueOf(id), location);
		return new ResponseEntity<>(returnLocation, HttpStatus.OK);
	}

	/*
	Testing if you can successfully delete locations. Delete later
	 */
	@RequestMapping(value = "deletelocations/{mat_id}", method = RequestMethod.POST)
	public ResponseEntity<?> deleteLocationsByMatId(@PathVariable("mat_id") String id){
		String response = materialService.deleteAllByMatId(Long.valueOf(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "deletelocation/{loc_id}", method = RequestMethod.POST)
	public ResponseEntity<?> deleteLocationById(@PathVariable("loc_id") String id){
		String response = materialService.deleteById(Long.valueOf(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*
	Testing to see if Mat-to-mat relation works
	 */
	@RequestMapping(value = "addmattomat/{id1}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addMatToMat(@PathVariable("id1") String id1, @RequestBody String id2){
		String response = materialService.addMatToMat(Long.valueOf(id1), Long.valueOf(id2));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "getrelated/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRelated(@PathVariable("id") String id){
		List<Material> materials = materialService.getAllMatRelationsById(Long.valueOf(id));
		return new ResponseEntity<>(materials, HttpStatus.OK);
	}

}
