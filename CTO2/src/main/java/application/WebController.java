package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

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
	public String showForm(Account account) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid Account account, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) return "form";

		Account user = userService.login(account);
		if (user == null) return "form";
		else return "redirect:/" + user.getUsername();
	}

	@PostMapping("/register")
	public String register(@Valid Account account, BindingResult bindingResult){
		userService.registerUser(account);
		return "redirect:/";
	}

	@GetMapping("/register")
	public String showRegisterForm(Account account) {
		return "register";
	}

	@GetMapping("/{username}")
	public String viewProfile(@PathVariable String username){
		return "profile";
	}
}
