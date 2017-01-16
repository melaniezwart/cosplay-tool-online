package nl.mappers;

import nl.entities.Project;
import nl.entities.ProjectTodo;
import nl.web.WebProject;
import nl.web.WebTodo;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 11-1-2017.
 */
public class WebProjectToProject {

	//TODO get user from header
	//TODO make possible to add an earlier date
	public Project webProjectToProject(WebProject webProject, String id){
		Project project = new Project();
		project.setName(webProject.getName());
		project.setDateStarted(LocalDate.now().toString());
		project.setCtoUser(Long.valueOf(id));
		project.setFinished(false);
		return project;
	}

	public List<ProjectTodo> webTodoToProjectTodo(WebProject webProject, String id){
		List<WebTodo> todos = webProject.getWebTodos();
		List<ProjectTodo> projectTodos = new ArrayList<>();
		for(WebTodo w : todos) {
			ProjectTodo todo = new ProjectTodo();
			todo.setEstimatedCost(w.getEstimatedCost());
			todo.setEstimatedTime(w.getEstimatedTime());
			todo.setMessage(w.getMessage());
			todo.setProjectId(Long.valueOf(id));
		}
		return projectTodos;
	}
}
