package nl.cto.service;

import nl.cto.converter.LocalDateTimeConverter;
import nl.cto.entities.CtoUser;
import nl.cto.entities.LoginValues;
import nl.cto.hello.CtoUserRepository;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

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

	private LocalDateTimeConverter converter;

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
}
