package nl.cto.service;

import nl.cto.entities.CtoUser;
import nl.cto.login.LoginRestController;
import nl.cto.repository.CtoUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mzwart on 9-12-2016.
 */
@Transactional
@Service
public class CtoUserService {

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private CtoUserRepository ctoUserRepository;

	@Autowired
	private EntityManager em;

	public CtoUser getCtoUserById(long id){
		List<CtoUser> ctoUsers = ctoUserRepository.findById(id);
		if(ctoUsers == null || ctoUsers.isEmpty()){
			logger.error("User not found. Id linked to login is wrong");
			return null;
		} else if (ctoUsers.size() > 1){
			logger.error("More than one user with same id");
			return null;
		} else return ctoUsers.get(0);
	}

	public long createNewCtoUser(CtoUser ctoUser){
		ctoUserRepository.createNewCtoUser(ctoUser.getCtoUsername(), ctoUser.getEmail(), Timestamp.valueOf(LocalDateTime.now()));
		return getCtoUserByCtoUsername(ctoUser.getCtoUsername()).getId();
	}

	public CtoUser getCtoUserByCtoUsername(String username){
		List<CtoUser> ctoUsers = ctoUserRepository.findByCtoUsername(username);
		if(ctoUsers == null || ctoUsers.isEmpty()){
			return null;
		}
		return ctoUsers.get(0);
	}
}
