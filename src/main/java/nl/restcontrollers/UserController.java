package nl.restcontrollers;

import nl.entities.CtoUser;
import nl.exceptions.FunctionalException;
import nl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static nl.util.Util.md5;

/**
 * Created by mzwart on 9-1-2017.
 * Rest controller for all rest calls regarding users
 */
@Controller
public class UserController extends WebMvcConfigurerAdapter{

	private Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String homepage() {
		if(session.getAttribute("x-userrole") != null){
			if(session.getAttribute("x-userrole").equals("ADMIN")) return "adminhome";
			else if(session.getAttribute("x-userrole").equals("USER")) return "useroptions";
			else throw new FunctionalException("Userrole exists but is empty or wrong: " + session.getAttribute("x-userrole").toString());
		} else return "redirect:/login";
	}

	/**
	 * Login rest calls
     */
	@GetMapping("/login")
	public String showForm(CtoUser ctoUser) {
		return "login";
	}

	@PostMapping("/login")
	public String login(@Valid CtoUser ctoUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "redirect:/login";
		//MD5 hashes the password
		ctoUser.setPassword(md5(ctoUser.getPassword()));
		CtoUser user = userService.login(ctoUser);
		if (user == null) return "redirect:/login";
		else {

			return "redirect:/useroptions";
		}
	}

	/**
	 * Temporary page to show what a user can do. Some require you to be logged in and use the user's id
	 */
	@GetMapping("/useroptions")
	public String showUserOptions(){
		//TODO
		if(session.getAttribute("x-userrole").equals("ADMIN")) return "adminpage";
		else return "useroptions";
	}

	/**
	 * Register new user rest calls
     */
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

	/**
	 * Rest call to view a user's profile
     */
	@GetMapping("/user/{username}")
	public ModelAndView viewProfile(@PathVariable String username){
		ModelAndView mv = new ModelAndView("profile");
		CtoUser user = userService.findUserByUsername(username);
		mv.addObject(user);
		return mv;
	}

	/**
	 * Rest call to view all users
     */
	@GetMapping("/users")
	public ModelAndView viewAllUsers(){
		if(session.isNew() || session.getAttribute("x-userid") == null) return new ModelAndView("redirect:/login");
		ModelAndView mv = new ModelAndView("users");
		List<CtoUser> users = userService.findAll();
		mv.addObject("users", users);
		return mv;
	}

	/**
	 * Friends rest call
	 */
	@GetMapping("/friends")
	public ModelAndView viewYourFriends(){
		if(session.isNew() || session.getAttribute("x-userid") == null) return new ModelAndView("redirect:/login");
		String id = session.getAttribute("x-userid").toString();
		ModelAndView mv = new ModelAndView("friends");
		List<CtoUser> users = userService.findFriendsById(Long.parseLong(id));
		mv.addObject("users", users);
		return mv;
	}

	/**
	 * Lost password TODO
	 */
	@GetMapping("/lostpass/email")
	public String lostPassEmail(){
		return "lostpassemail";
	}
	@PostMapping("/lostpass/email")
	public String lostPassEmailSubmit(String email){
		//find email in database
		//Call out exception if not found
		//If found, retrieve user
		//Change password for this user
		//Send out email to same user with temp password
		//OR send out email to user with link to change password. If so, new rest call needed
		return "redirect:/home";
	}

	/**
	 * Rest call to log the user out and invalidate the session
	 */
	@GetMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/getsession")
	public String getSession(){
		userService.showSessionAttributes();
		return "redirect:/login";
	}
}
