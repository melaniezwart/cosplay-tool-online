package nl.web;

import nl.entities.ProjectTodo;

import java.util.List;

/**
 * Created by mzwart on 11-1-2017.
 */
public class WebProject {

	private String name;
	private boolean privateProfile = false;
	private List<ProjectTodo> projectTodos;
	//TODO multiple forms on one page. One form for project name and other possible info
	//TODO Second form for todo messages, each with their estimated cost and time
	//TODO Add a button to add another todo

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrivateProfile() {
		return privateProfile;
	}

	public void setPrivateProfile(boolean privateProfile) {
		this.privateProfile = privateProfile;
	}

	public List<ProjectTodo> getWebTodos() {
		return projectTodos;
	}

	public void setWebTodos(List<ProjectTodo> projectTodos) {
		this.projectTodos = projectTodos;
	}
}
