package nl.service;

import nl.entities.UserConnections;
import nl.exceptions.UserAlreadyExistsException;
import nl.exceptions.UserNotFoundException;
import nl.entities.CtoUser;
import nl.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by mzwart on 6-1-2017.
 * Service class for all rest calls related to users
 */
@Service
public class UserService {

	private Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private HttpSession session;
	@Autowired
	private UserRepository userRepository;

	public void registerUser(CtoUser ctoUser){
		if(userRepository.findOneByUsername(ctoUser.getUsername()) != null) throw new UserAlreadyExistsException("User with the name " + ctoUser.getUsername() + "already exists");
		else {
			ctoUser.setRole("USER");
			userRepository.saveAndFlush(ctoUser);
		}
	}

	public CtoUser login(CtoUser ctoUser){
		CtoUser user = userRepository.findOneByUsernameAndPassword(ctoUser.getUsername(), ctoUser.getPassword());
		if(user == null) throw new UserNotFoundException("User with name " + ctoUser.getUsername() + " not found.");
		//Login successful
		LOG.info("User " + user.getUsername() + " successfully logged in.");
		session.setAttribute("x-userid", user.getId());
		session.setAttribute("x-username", user.getUsername());
		session.setAttribute("x-userrole", user.getRole());
		showSessionAttributes();
		return user;
	}

	public CtoUser findUserById(long id){
		return userRepository.findOne(id);
	}

	public CtoUser findUserByUsername(String username){
		return userRepository.findOneByUsername(username);
	}

	public List<CtoUser> findAll(){
		return userRepository.findAll();
	}

	public List<CtoUser> findFriendsById(long userid){
		List<UserConnections> userToUser = userRepository.getConnections(userid);
		List<CtoUser> ctoUsers = new ArrayList<>();
		for(UserConnections u : userToUser){
			ctoUsers.add(userRepository.findOne(u.getUserConnection()));
		}
		return ctoUsers;
	}

	public void showSessionAttributes(){
		Enumeration<String> list = session.getAttributeNames();
		while(list.hasMoreElements()){
			String element = list.nextElement().toString();
			System.out.println(element + ": " + session.getAttribute(element).toString());
		}
		System.out.println("Max interval time: " + session.getMaxInactiveInterval());
		System.out.println("Time last accessed: " + session.getLastAccessedTime());
		System.out.println("Time created: " + session.getCreationTime());
	}
}
