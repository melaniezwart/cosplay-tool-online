package nl.restcontrollers;

import nl.frontdata.CtoUser;
import nl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.validation.Valid;
import java.util.List;

import static nl.util.Util.md5;


/**
 * Created by mzwart on 6-1-2017.
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter{

	@Autowired
	private UserService userService;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(CtoUser ctoUser) {
		return "form";
	}

	@PostMapping("/")
	public String login(@Valid CtoUser ctoUser, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) return "form";
		//MD5 hashes the password
		ctoUser.setPassword(md5(ctoUser.getPassword()));
		CtoUser user = userService.login(ctoUser);
		if (user == null) return "form";
		else return "redirect:/" + user.getUsername();
	}

	@PostMapping("/register")
	public String registerNewUser(@Valid CtoUser ctoUser, BindingResult bindingResult){
		ctoUser.setPassword(md5(ctoUser.getPassword()));
		userService.registerUser(ctoUser);
		return "redirect:/";
	}

	@GetMapping("/register")
	public String showRegisterForm(CtoUser ctoUser) {
		return "register";
	}

	@GetMapping("/{username}")
	public ModelAndView viewProfile(@PathVariable String username){
		ModelAndView mv = new ModelAndView("profile");
		CtoUser user = userService.findUserByUsername(username);
		mv.addObject(user);
		return mv;
	}

	@GetMapping("/users")
	public ModelAndView viewAllUsers(){
		ModelAndView mv = new ModelAndView("users");
		List<CtoUser> users = userService.findAll();
		mv.addObject("users", users);
		return mv;
	}

}
