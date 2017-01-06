package application;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mzwart on 6-1-2017.
 */
public interface UserRepository extends JpaRepository<Account, Long>{

	List<Account> findByUsername(String username);

	Account findOneByUsername(String username);

	Account findOneByUsernameAndPassword(String username, String password);

}
