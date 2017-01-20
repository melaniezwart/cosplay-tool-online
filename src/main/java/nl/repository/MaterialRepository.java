package nl.repository;

import nl.entities.MaterialMatConnections;
import nl.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by mzwart on 9-1-2017.
 */
public interface MaterialRepository extends JpaRepository<Material, Long> {

	Material findOneByName(String name);

	//@Query("SELECT x FROM MaterialMatConnections x WHERE x.material_id = ?1 OR x.mat_connections_id = ?1")
	//List<MaterialMatConnections> getConnections(long material_id);

}
