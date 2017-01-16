package nl.service;

import nl.entities.*;
import nl.mappers.WebProjectToProject;
import nl.repository.ProjectRepository;
import nl.repository.ProjectTodoRepository;
import nl.web.WebProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 10-1-2017.
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectTodoRepository projectTodoRepository;
	@Autowired
	private MaterialService materialService;

	public Project getProjectById(String id){
		return projectRepository.findOne(Long.valueOf(id));
	}

	public List<Material> getMaterialsUsed(String id){
		List<Long> materialIds = projectRepository.getMaterialIds(Long.valueOf(id));
		List<Material> materials = new ArrayList<>();
		for(Long x : materialIds){
			materials.add(materialService.findById(x));
		}
		return materials;
	}

	public List<ProjectMessages> getProjectMessages(String id){
		List<Long> messageIds = projectRepository.getMessageIds(Long.valueOf(id));
		List<ProjectMessages> messages = new ArrayList<>();
		for(Long x : messageIds){
			messages.add(getMessageById(x));
		}
		return messages;
	}

	public ProjectMessages getMessageById(long id){
		return projectRepository.getOneMessage(id);
	}

	public List<ProjectTodo> getProjectTodos(String id){
		List<Long> todoIds = projectRepository.getTodoIds(Long.valueOf(id));
		List<ProjectTodo> todos = new ArrayList<>();
		for(Long x : todoIds){
			todos.add(getTodoById(x));
		}
		return todos;
	}

	public ProjectTodo getTodoById(long id){
		return projectRepository.getOneTodo(id);
	}

	public Project createNewProject(WebProject webProject, String id){
		WebProjectToProject mapper = new WebProjectToProject();
		Project project = mapper.webProjectToProject(webProject, id);
		Project savedEntity = projectRepository.saveAndFlush(project);
		List<ProjectTodo> todos = mapper.webTodoToProjectTodo(webProject, id);
			for(ProjectTodo p : todos){
				projectTodoRepository.saveAndFlush(p);
			}
		return savedEntity;
	}
}
