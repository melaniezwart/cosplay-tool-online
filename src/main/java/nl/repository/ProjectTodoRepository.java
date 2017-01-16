package nl.repository;

import nl.entities.ProjectTodo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mzwart on 12-1-2017.
 */
public interface ProjectTodoRepository extends JpaRepository<ProjectTodo, Long>{


}
