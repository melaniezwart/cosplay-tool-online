package nl.cto.repository;

import nl.cto.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mzwart on 22-12-2016.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO mat_location VALUES(nextval('cto.location_seq'),(?1), (?2), (?3))", nativeQuery = true)
	void addLocation(String location, long mat_id, int price);

	@Query(value = "SELECT * FROM mat_location a WHERE a.mat_id = (?1)", nativeQuery = true)
	List<Location> findLocationsByMatId(long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE mat_location\n" +
		"SET location = (?2), price = (?3)\n" +
		"WHERE id = (?1)", nativeQuery = true)
	void updateLocation(long id, String newName, int price);

	@Query(value = "SELECT * FROM mat_location a WHERE a.id = (?1)", nativeQuery = true)
	List<Location> findById(long id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM mat_location a WHERE a.mat_id = (?1)", nativeQuery = true)
	void deleteAllByMatId(long id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM mat_location a WHERE a.id = (?1)", nativeQuery = true)
	void deleteById(long id);
}

