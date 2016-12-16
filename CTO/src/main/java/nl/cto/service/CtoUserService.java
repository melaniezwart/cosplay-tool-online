package nl.cto.service;


import nl.cto.login.LoginValues;
import nl.cto.entities.CtoUser;
import nl.cto.repository.CtoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;


import static nl.cto.login.EncryptionUtil.md5;

/**
 * Created by mzwart on 9-12-2016.
 */
@Transactional
@Service
public class CtoUserService {

	@Autowired
	private CtoUserRepository ctoUserRepository;

	@Autowired
	private EntityManager em;


	public CtoUser getCtoUserByUsername(String username){
		List<CtoUser> ctoUsers = ctoUserRepository.findByUsername(username);
		if(ctoUsers == null || ctoUsers.isEmpty()){
			return null;
		}
		return ctoUsers.get(0);
	}

	public CtoUser registerUser(String username, String password){
		CtoUser ctoUser = new CtoUser(username, password);
		ctoUser.setDatejoined(new Timestamp(System.currentTimeMillis()));
		em.persist(ctoUser);
		return ctoUser;
	}


	//TODO hash by bcrypt and get https
	public CtoUser getCtoUserByLogin(LoginValues login){
		List<CtoUser> ctoUserList = ctoUserRepository.findByUsername(login.getUsername());
		if(ctoUserList == null || ctoUserList.isEmpty()){
			System.out.println("User not found");
			return null;
		} else if(ctoUserList.size() > 1){
			System.out.println("More than one, investigate");
			return null;
		}
		CtoUser user = ctoUserList.get(0);
		if(user.getPassword().equals(md5(login.getPassword()))){
			return user;
		} else return null;
	}

}
