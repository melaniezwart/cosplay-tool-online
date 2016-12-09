package nl.cto.service;

import nl.cto.entities.CtoUser;
import nl.cto.hello.CtoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mzwart on 9-12-2016.
 */
@Transactional
@Service
public class CtoUserService {

	@Autowired
	private CtoUserRepository ctoUserRepository;

	public CtoUser getCtoUserByUsername(String username){
		List<CtoUser> ctoUsers = ctoUserRepository.findByUsername(username);
		if(ctoUsers == null || ctoUsers.isEmpty()){
			return null;
		}
		return ctoUsers.get(0);
	}
}
