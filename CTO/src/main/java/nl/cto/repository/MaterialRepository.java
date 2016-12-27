package nl.cto.repository;

import nl.cto.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by mzwart on 13-12-2016.
 */
public interface MaterialRepository extends JpaRepository<Material, Long>{

	List<Material> findByName(String name);

	List<Material> findById(long id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO material VALUES(nextval('cto.material_seq'),(?1),(?2))", nativeQuery = true)
	void addMaterial(String name, int avgPrice);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO cto_mat_to_mat VALUES((?1),(?2))", nativeQuery = true)
	void addMatToMat(long mat_id1, long mat_id2);

	@Query(value = "SELECT mat_id1 FROM cto_mat_to_mat WHERE mat_id2 = (?1)", nativeQuery = true)
	List<BigInteger> findAllMatToMatById(long mat_id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE material\n" +
		"SET name = (?2), avg_price = (?3)\n" +
		"WHERE id = (?1)", nativeQuery = true)
	void editMaterial(long id, String name, int avgPrice);

}
