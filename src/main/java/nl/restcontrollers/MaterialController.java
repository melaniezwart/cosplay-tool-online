package nl.restcontrollers;

import nl.entities.Material;
import nl.service.MaterialService;
import nl.web.WebMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by mzwart on 9-1-2017.
 * Rest controller for all rest calls related to materials
 */
@Controller
public class MaterialController extends WebMvcConfigurerAdapter {
	@Autowired
	private HttpSession session;
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
	public ModelAndView newMaterialPage(WebMaterial webMaterial){
		//if(session.isNew() || session.getAttribute("x-userrole") == null) return new ModelAndView("redirect:/login");
		//if(!session.getAttribute("x-userrole").equals("ADMIN")) return new ModelAndView("redirect:/");
		ModelAndView mv = new ModelAndView("newmaterial");
		List<Material> allMaterials = materialService.findAll();
		mv.addObject("allMaterials", allMaterials);
		return mv;
	}

	@PostMapping("/material/newmaterial")
	public String registerNewMaterial(WebMaterial webMaterial, BindingResult bindingResult){
		//if(session.isNew() || session.getAttribute("x-userrole") == null) return "redirect:/login";
		//if(!session.getAttribute("x-userrole").equals("ADMIN")) return "redirect:/";
		materialService.registerMaterial(webMaterial);
		return "redirect:/material/newmaterial";
	}

	/**
	 * Rest call for material connections
     */
/*	@GetMapping("/material/{materialid}/connections")
	public ModelAndView viewConnections(@PathVariable("materialid")String materialid){
		ModelAndView mv = new ModelAndView("connections");
		List<Material> materials = materialService.fin(Long.parseLong(materialid));
		mv.addObject("materials", materials);
		return mv;
	}*/

	@GetMapping(value = "/postmat/{materialid}", produces = "application/json")
	public ModelAndView getMat(@PathVariable("materialid") String materialid){
		ModelAndView mv = new ModelAndView("editmaterial");
		Material material = materialService.findById(Long.valueOf(materialid));
		mv.addObject(material);
		return mv;
		//return materialService.findById(Long.valueOf(materialid));
	}

	@PostMapping(value = "/postmat/", produces = "application/json", consumes = "application/x-www-form-urlencoded")
	public ModelAndView editMat(Material material){
		ModelAndView mv = new ModelAndView("editmaterial");
		Material mat = materialService.editMaterial(Long.valueOf(material.getId()), material);
		//ID isn't set when returning the new material. Try that first.
		mv.addObject(mat);
		return mv;
		//return materialService.editMaterial(Long.valueOf(materialid), material);
	}
}
