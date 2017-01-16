package nl.repository;

import nl.entities.CtoUser;
import nl.entities.UserConnections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by mzwart on 6-1-2017.
 */
public interface UserRepository extends JpaRepository<CtoUser, Long>{

	List<CtoUser> findByUsername(String username);

	CtoUser findOneByUsername(String username);

	CtoUser findOneByUsernameAndPassword(String username, String password);

	@Query("SELECT x FROM UserConnections x WHERE x.userId1 =?1")
	List<UserConnections> getConnections(long id1);

}
