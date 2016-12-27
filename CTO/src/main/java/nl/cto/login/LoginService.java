package nl.cto.login;

import nl.cto.entities.CtoUser;
import nl.cto.entities.Login;
import nl.cto.repository.LoginRepository;
import nl.cto.service.CtoUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mzwart on 23-12-2016.
 */
@Service
public class LoginService{

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private CtoUserService ctoUserService;

	public CtoUser checkLogin(String username, String password){
		List<Login> loggedUser = loginRepository.findLoginByUsername(username, password);
		if(loggedUser.isEmpty() || loggedUser == null){
			logger.warn("User not found or password doesn't match");
			return null;
		}
		else if (loggedUser.size() > 1){
			logger.error("More than one user found");
			return null;
		}
		else {
			long ctoUserId = loggedUser.get(0).getCtoUserId();
			return ctoUserService.getCtoUserById(ctoUserId);
		}
	}

	public String registerUser(String username, String password){
		if(loginRepository.findLoginByUsername(username) != null || !loginRepository.findLoginByUsername(username).isEmpty()) {
			return "User already exists";
		} else {
			loginRepository.registerUser(username, password);
			return "User successfully registered";
		}
	}

	public void linkNewCtoUser(long id, String username){
		loginRepository.addCtoUserToLogin(id, username);
	}
}
