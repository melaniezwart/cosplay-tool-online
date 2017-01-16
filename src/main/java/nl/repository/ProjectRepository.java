package nl.repository;

import nl.entities.Project;
import nl.entities.ProjectMessages;
import nl.entities.ProjectTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by mzwart on 10-1-2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query("SELECT x.MaterialId FROM ProjectMaterials x WHERE x.ProjectId = ?1")
	List<Long> getMaterialIds(long id);

	@Query("SELECT x.id FROM ProjectMessages x WHERE x.projectId = ?1")
	List<Long> getMessageIds(long id);

	@Query("SELECT x FROM ProjectMessages x WHERE x.id = ?1")
	ProjectMessages getOneMessage(long id);

	@Query("SELECT x.id FROM ProjectTodo x WHERE x.projectId = ?1")
	List<Long> getTodoIds(long id);

	@Query("SELECT x FROM ProjectTodo x WHERE x.id = ?1")
	ProjectTodo getOneTodo(long id);

}
