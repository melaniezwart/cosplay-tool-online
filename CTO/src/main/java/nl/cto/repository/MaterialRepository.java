package nl.cto.repository;

import nl.cto.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mzwart on 13-12-2016.
 */
public interface MaterialRepository extends JpaRepository<Material, Long>{

	List<Material> findByName(String name);

	List<Material> findById(long id);
}
