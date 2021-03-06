package nl.cto.repository;

import nl.cto.entities.CtoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mzwart on 9-12-2016.
 */
public interface CtoUserRepository extends JpaRepository<CtoUser, Long> {

	List<CtoUser> findByUsername(String username);
}
