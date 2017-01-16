package nl.web;

import java.util.List;

/**
 * Created by mzwart on 11-1-2017.
 */
public class WebProject {

	private String name;
	private List<WebTodo> webTodos;
	//TODO multiple forms on one page. One form for project name and other possible info
	//TODO Second form for todo messages, each with their estimated cost and time
	//TODO Add a button to add another todo


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WebTodo> getWebTodos() {
		return webTodos;
	}

	public void setWebTodos(List<WebTodo> webTodos) {
		this.webTodos = webTodos;
	}
}
