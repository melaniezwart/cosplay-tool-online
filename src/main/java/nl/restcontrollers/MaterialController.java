package nl.restcontrollers;

import nl.entities.CtoUser;
import nl.entities.Material;
import nl.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mzwart on 9-1-2017.
 * Rest controller for all rest calls related to materials
 */
@Controller
public class MaterialController extends WebMvcConfigurerAdapter {
	@Autowired
	private MaterialService materialService;

	/**
	 * Rest call to get a specific material by name
     */
	@GetMapping("/material/{material}")
	public ModelAndView viewMaterial(@PathVariable String material){
		ModelAndView mv = new ModelAndView("material");
		Material materialProfile = materialService.findMaterialByName(material);
		mv.addObject("material", materialProfile);
		return mv;
	}

	/**
	 * Rest calls related to creating a new material in the database
     */
	@GetMapping("/material/newmaterial")
	public String newMaterialPage(Material material){
		return "newmaterial";
	}

	@PostMapping("/material/newmaterial")
	public String registerNewMaterial(@Valid Material material, BindingResult bindingResult){
		materialService.registerMaterial(material);
		return "redirect:/material/newmaterial";
	}

	/**
	 * Rest call for material connections
     */
	@GetMapping("/material/{materialid}/connections")
	public ModelAndView viewConnections(@PathVariable("materialid")String materialid){
		ModelAndView mv = new ModelAndView("connections");
		List<Material> materials = materialService.findConnectionsById(Long.parseLong(materialid));
		mv.addObject("materials", materials);
		return mv;
	}
}
