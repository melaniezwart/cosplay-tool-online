package nl.cto.rest;

import nl.cto.entities.CtoUser;
import nl.cto.service.CtoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mzwart on 23-12-2016.
 */
@Controller
@RequestMapping("cto")
public class CtoUserRestController {

	@Autowired
	private CtoUserService ctoUserService;

	//Shows user page
	@RequestMapping(value = "get/{username}", method = RequestMethod.GET)
	public final ResponseEntity<?> getUserPage(@PathVariable("username") final String username){
		CtoUser ctoUser = ctoUserService.getCtoUserByCtoUsername(username);
		if(ctoUser != null)
			return new ResponseEntity<>(ctoUser, HttpStatus.OK);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
