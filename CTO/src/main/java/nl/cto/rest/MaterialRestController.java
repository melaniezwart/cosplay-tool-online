package nl.cto.rest;

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
		return new ResponseEntity<Object>(returnMaterial, HttpStatus.OK);
	}
}
