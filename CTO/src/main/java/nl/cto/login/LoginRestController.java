package nl.cto.login;

import nl.cto.entities.CtoUser;
import nl.cto.entities.Login;
import nl.cto.service.CtoUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static nl.cto.login.EncryptionUtil.md5;

/**
 * Created by mzwart on 8-12-2016.
 */
@Controller
@RequestMapping("users")
public class LoginRestController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private CtoUserService ctoUserService;

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	//Rest call to login and returns a user
	//TODO if cto user doesn't exist yet, redirect to the form to make one
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Login login) {
		if(login == null){
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		} else {
			//Check login and load user
			CtoUser ctoUser = loginService.checkLogin(login.getUsername(), md5(login.getPassword()));
			if(ctoUser == null) return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			else return new ResponseEntity<>(ctoUser, HttpStatus.OK);
			//TODO add authentication to header
		}
	}

	//Rest call to register a new user
	@RequestMapping(value = "register", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> registerUser(@RequestBody Login login){
		if(login == null){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			String response = loginService.registerUser(login.getUsername(), md5(login.getPassword()));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	//Rest call to create new CTO user and link it to login
	@RequestMapping(value = "cto/newuser/{username}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> newCtoUser(@PathVariable("username") String username, @RequestBody CtoUser ctoUser){
		long id = ctoUserService.createNewCtoUser(ctoUser);
		loginService.linkNewCtoUser(id, username);
		String response = "Successfully created CTO user " + ctoUser.getCtoUsername() + " for account " + username;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
