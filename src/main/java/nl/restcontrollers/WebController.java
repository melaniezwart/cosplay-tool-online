package nl.restcontrollers;

import nl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;

/**
 * Created by mzwart on 6-1-2017.
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter{

	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String homepage() {
		if(session.getAttribute("x-userrole").equals("ADMIN")) return "adminhome";
		else if(session.getAttribute("x-userrole").equals("USER")) return "useroptions";
		else return "login";
	}

}
