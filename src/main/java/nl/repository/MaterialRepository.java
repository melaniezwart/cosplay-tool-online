package nl.repository;

import nl.entities.MatConnections;
import nl.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by mzwart on 9-1-2017.
 */
public interface MaterialRepository extends JpaRepository<Material, Long> {

	Material findOneByName(String name);

	@Query("SELECT x FROM MatConnections x WHERE x.matId1 = ?1")
	List<MatConnections> getConnections(long id1);

}
