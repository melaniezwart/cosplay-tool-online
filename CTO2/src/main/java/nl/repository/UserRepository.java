package nl.repository;

import nl.frontdata.CtoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mzwart on 6-1-2017.
 */
public interface UserRepository extends JpaRepository<CtoUser, Long>{

	List<CtoUser> findByUsername(String username);

	CtoUser findOneByUsername(String username);

	CtoUser findOneByUsernameAndPassword(String username, String password);

}
