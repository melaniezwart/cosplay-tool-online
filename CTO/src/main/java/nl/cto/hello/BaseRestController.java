package nl.cto.hello;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mzwart on 8-12-2016.
 */
@Controller
public class BaseRestController{

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/results";
	}

	@RequestMapping(value = "ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath(){
		return "Get some Foos";
	}
}
