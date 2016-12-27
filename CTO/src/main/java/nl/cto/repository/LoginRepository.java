package nl.cto.repository;

import nl.cto.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mzwart on 23-12-2016.
 */
public interface LoginRepository extends JpaRepository<Login, Long>{

	@Query(value = "SELECT * FROM login a WHERE a.username = (?1) AND a.password = (?2)", nativeQuery = true)
	List<Login> findLoginByUsername(String username, String password);

	@Query(value = "SELECT * FROM login a WHERE a.username = (?1)", nativeQuery = true)
	List<Login> findLoginByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO login VALUES((?1),(?2))", nativeQuery = true)
	void registerUser(String username, String password);

	@Modifying
	@Transactional
	@Query(value = "UPDATE login SET cto_user_id = (?1) WHERE username = (?2)", nativeQuery = true)
	void addCtoUserToLogin(long id, String username);

}
