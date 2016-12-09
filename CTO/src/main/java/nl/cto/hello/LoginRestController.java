package nl.cto.hello;

import nl.cto.dao.UserDao;
import nl.cto.entities.CtoUser;
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

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "get/{username}", method = RequestMethod.GET)
	public final ResponseEntity<?> getUserPage(@PathVariable("username") final String username){
		CtoUser ctoUser = userDao.getUserByUsername(username);
		if(ctoUser != null)
			return new ResponseEntity<>(ctoUser, HttpStatus.OK);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath(){
		return "Get some Foos";
	}
}
