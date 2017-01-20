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

	//TODO make possible to add an earlier date
	public Project webProjectToProject(WebProject webProject, String id){
		Project project = new Project();
		project.setName(webProject.getName());
		project.setDateStarted(LocalDate.now().toString());
		project.setCtoUser(Long.valueOf(id));
		project.setFinished(false);
		project.setPrivateProfile(webProject.isPrivateProfile());
		project.setProjectTodo(webProject.getWebTodos());
		return project;
	}
}
