package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mzwart on 6-1-2017.
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void registerUser(Account account){
		if(userRepository.findOneByUsername(account.getUsername()) == null) return;
		else userRepository.saveAndFlush(account);
	}

	public Account login(Account account){
		Account user = userRepository.findOneByUsernameAndPassword(account.getUsername(), account.getPassword());
		return user;
	}
}
