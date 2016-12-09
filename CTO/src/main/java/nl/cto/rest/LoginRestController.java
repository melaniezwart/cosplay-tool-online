package nl.cto.rest;

import nl.cto.entities.CtoUser;
import nl.cto.entities.LoginValues;
import nl.cto.service.CtoUserService;
import nl.cto.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mzwart on 8-12-2016.
 */
@Controller
@RequestMapping("users")
public class LoginRestController {

	@Autowired
	private CtoUserService ctoUserService;
	@Autowired
	private LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@RequestMapping(value = "get/{username}", method = RequestMethod.GET)
	public final ResponseEntity<?> getUserPage(@PathVariable("username") final String username){
		CtoUser ctoUser = ctoUserService.getCtoUserByUsername(username);
		if(ctoUser != null)
			return new ResponseEntity<>(ctoUser, HttpStatus.OK);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginValues login) {
		if(login == null){
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		} else {
			CtoUser ctoUser = loginService.getCtoUserByLogin(login);
			if(ctoUser == null) return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			else return new ResponseEntity<>(ctoUser, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath(){
		return "Get some Foos";
	}
}
