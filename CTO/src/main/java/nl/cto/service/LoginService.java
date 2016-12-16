package nl.cto.service;

import nl.cto.entities.CtoUser;
import nl.cto.entities.LoginValues;
import nl.cto.hello.CtoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static nl.cto.login.EncryptionUtil.md5;

import java.util.List;

/**
 * Created by mzwart on 9-12-2016.
 */
@Service
public class LoginService {

	@Autowired
	private CtoUserRepository ctoUserRepository;

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
