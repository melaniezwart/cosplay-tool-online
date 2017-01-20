package nl.restcontrollers;

import nl.entities.*;
import nl.service.MaterialService;
import nl.service.ProjectService;
import nl.service.UserService;
import nl.web.WebProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mzwart on 10-1-2017.
 */
@Controller
public class ProjectController {

	private Logger LOG = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private HttpSession session;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private MaterialService materialService;

	@GetMapping("/project/{projectid}")
	public ModelAndView getProject(@PathVariable("projectid") String projectid){
		ModelAndView mv = new ModelAndView("project");
		Project project = projectService.getProjectById(projectid);
		CtoUser ctoUser = userService.findUserById(project.getCtoUser());
		List<Material> materials = projectService.getMaterialsUsed(projectid);
		List<ProjectMessages> messages = projectService.getProjectMessages(projectid);
		List<ProjectTodo> todos = projectService.getProjectTodos(projectid);

		mv.addObject(project);
		mv.addObject(ctoUser);
		mv.addObject("materials", materials);
		mv.addObject("messages", messages);
		mv.addObject("todos", todos);
		return mv;
	}

	@PostMapping("/project/new")
	public String createNewProject(WebProject webProject){
		if(session.isNew() || session.getAttribute("x-userid") == null) return "redirect:/login";
		String userid = session.getAttribute("x-userid").toString();
		Project project = projectService.createNewProject(webProject, userid);
		return "redirect:/project/" + project.getId();
		//TODO not tested
	}

	@GetMapping("/project/new")
	public String createNewProjectPage(WebProject webProject){
		if(session.isNew() || session.getAttribute("x-userid") == null) return "redirect:/login";
		else return "newproject";
	}

	@GetMapping("/project/all/{userid}")
	public ModelAndView getAllProjectsByUserid(@PathVariable("userid") String userid){
		ModelAndView mv = new ModelAndView("projects");
		List<Project> projects = projectService.getProjectsByUser(userid);
		if(projects.isEmpty() || projects == null){
			return mv;
		}
		mv.addObject("projects", projects);
		return mv;
		//get all projects by userid
		//transform some data
		//add to mv
	}

	@GetMapping("/project/current/{userid}")
	public ModelAndView getCurrentProjectsByUserid(@PathVariable("userid") String userid){
		ModelAndView mv = new ModelAndView("projects");
		List<Project> projects = projectService.getCurrentProjectsByUser(userid);
		if(projects.isEmpty() || projects == null){
			return mv;
		}
		mv.addObject("projects", projects);
		return mv;
	}

	/**
	 * Add a new cost and time estimate to the total cost
	 */
	public void addMoneySpent(Project project, int amountSpent){
		int moneySpent = project.getTotalMoneySpent();
		moneySpent += amountSpent;
		project.setTotalMoneySpent(moneySpent);
	}

	public void calculateEstimatedTimeAndCost(Project project, List<ProjectTodo> todos){
		int totalTime = 0;
		int totalCost = 0;
		for(ProjectTodo p : todos){
			totalTime += p.getEstimatedTime();
			totalCost += p.getEstimatedCost();
		}
		project.setEstimatedTime(totalTime);
		project.setEstimatedCost(totalCost);
	}

}