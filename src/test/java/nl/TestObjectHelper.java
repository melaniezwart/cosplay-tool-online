package nl;

import nl.entities.*;
import nl.web.WebProject;
import nl.web.WebTodo;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 13-1-2017.
 */
public class TestObjectHelper {

	public static CtoUser getCtoUser(){
		CtoUser ctoUser = new CtoUser();
		ctoUser.setId(RandomUtils.nextLong());
		ctoUser.setPassword(RandomStringUtils.randomAlphanumeric(10));
		ctoUser.setUsername(RandomStringUtils.randomAlphabetic(10));
		return ctoUser;
	}

	public static Material getMaterial(){
		Material material = new Material();
		material.setId(RandomUtils.nextLong());
		material.setName(RandomStringUtils.randomAlphabetic(10));
		material.setLocation(RandomStringUtils.randomAlphabetic(10));
		material.setPrice(RandomUtils.nextInt());
		return material;
	}

	public static Project getProject(){
		Project project = new Project();
		project.setId(RandomUtils.nextLong());
		project.setName(RandomStringUtils.randomAlphabetic(10));
		project.setFinished(false);
		project.setDateStarted(LocalDate.now().toString());
		project.setEstimatedCost(RandomUtils.nextInt());
		project.setEstimatedTimeInHours(RandomUtils.nextInt());
		project.setTotalMoneySpent(RandomUtils.nextInt());
		project.setCtoUser(RandomUtils.nextLong());
		return project;
	}

/*	public static MaterialMatConnections getMatConnections(){
		MaterialMatConnections connection = new MaterialMatConnections();
		connection.setMaterialId(RandomUtils.nextLong());
		connection.setMatConnectionsId(RandomUtils.nextLong());
		return connection;
	}*/

	public static UserConnections getUserConnections(){
		UserConnections connection = new UserConnections();
		connection.setCtoUser(RandomUtils.nextLong());
		connection.setUserConnection(RandomUtils.nextLong());
		return connection;
	}

	public static List<ProjectMaterials> getMultipleProjectMaterials(int amount){
		List<ProjectMaterials> materials = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			materials.add(getProjectMaterial());
		}
		return materials;
	}

	public static ProjectMaterials getProjectMaterial(){
		ProjectMaterials material = new ProjectMaterials();
		material.setMaterialId(RandomUtils.nextLong());
		material.setProjectId(RandomUtils.nextLong());
		return material;
	}

	public static List<ProjectMessages> getMultipleProjectMessages(int amount){
		List<ProjectMessages> messages = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			messages.add(getProjectMessage());
		}
		return messages;
	}

	public static ProjectMessages getProjectMessage(){
		ProjectMessages message = new ProjectMessages();
		message.setProjectId(RandomUtils.nextLong());
		message.setDatePosted(LocalDate.now().toString());
		message.setId(RandomUtils.nextLong());
		message.setMessage(RandomStringUtils.randomAlphabetic(50));
		return message;
	}

	public static List<ProjectTodo> getMultipleProjectTodos(int amount){
		List<ProjectTodo> todos = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			todos.add(getProjectTodo());
		}
		return todos;
	}

	public static ProjectTodo getProjectTodo(){
		ProjectTodo todo = new ProjectTodo();
		todo.setId(RandomUtils.nextLong());
		todo.setProjectId(RandomUtils.nextLong());
		todo.setEstimatedCost(RandomUtils.nextInt());
		todo.setEstimatedTime(RandomUtils.nextInt());
		todo.setMessage(RandomStringUtils.randomAlphabetic(20));
		return todo;
	}

	public static WebProject getWebProject(){
		WebProject webProject = new WebProject();
		webProject.setName(RandomStringUtils.randomAlphabetic(10));
		webProject.setWebTodos(getMultipleWebTodos(5));
		return webProject;
	}

	public static List<WebTodo> getMultipleWebTodos(int amount){
		List<WebTodo> todos = new ArrayList<>();
		for(int i = 0 ; i < amount ; i++){
			todos.add(getWebTodo());
		}
		return todos;
	}

	public static WebTodo getWebTodo(){
		WebTodo webTodo = new WebTodo();
		webTodo.setMessage(RandomStringUtils.randomAlphabetic(20));
		webTodo.setEstimatedTime(RandomUtils.nextInt());
		webTodo.setEstimatedCost(RandomUtils.nextInt());
		return webTodo;
	}
}
