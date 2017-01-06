package nl.service;

import nl.frontdata.CtoUser;
import nl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mzwart on 6-1-2017.
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void registerUser(CtoUser ctoUser){
		if(userRepository.findOneByUsername(ctoUser.getUsername()) == null) return;
		else userRepository.saveAndFlush(ctoUser);
	}

	public CtoUser login(CtoUser ctoUser){
		CtoUser user = userRepository.findOneByUsernameAndPassword(ctoUser.getUsername(), ctoUser.getPassword());
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
}
