package nl.cto.repository;

import nl.cto.entities.CtoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by mzwart on 9-12-2016.
 */
public interface CtoUserRepository extends JpaRepository<CtoUser, Long> {

	List<CtoUser> findByCtoUsername(String ctoUsername);

	List<CtoUser> findById(long id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO cto_user VALUES(nextval('cto.user_seq')(?1),(?2),(?3))", nativeQuery = true)
	void createNewCtoUser(String ctoUsername, String email, Timestamp dateJoined);
}
