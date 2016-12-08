package rest;

import dao.UserDao;
import entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mzwart on 8-12-2016.
 */
@Controller
@RequestMapping("/users/")
public class LoginRestController {

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
	public final ResponseEntity<?> getUserPage(@PathVariable("username") final String username){
		User user = userDao.getUserByUsername(username);
		if(user != null)
			return new ResponseEntity<>(user, HttpStatus.OK);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}


}
