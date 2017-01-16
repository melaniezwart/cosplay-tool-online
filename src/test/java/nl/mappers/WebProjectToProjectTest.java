package nl.mappers;

import nl.TestObjectHelper;
import nl.entities.Project;
import nl.entities.ProjectTodo;
import nl.web.WebProject;
import org.apache.commons.lang.RandomStringUtils;
import org.easymock.TestSubject;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mzwart on 13-1-2017.
 */
public class WebProjectToProjectTest {

	@TestSubject
	WebProjectToProject mapper = new WebProjectToProject();

	@Test
	public void webProjectToProject() throws Exception {
		WebProject webProject = TestObjectHelper.getWebProject();
		String name = RandomStringUtils.randomAlphabetic(10);
		webProject.setName(name);
		String id = RandomStringUtils.randomNumeric(3);

		Project project = mapper.webProjectToProject(webProject, id);

		assertEquals(name, project.getName());
		assertTrue(Long.valueOf(id) == project.getCtoUser());
		assertEquals(LocalDate.now().toString(), project.getDateStarted());
	}

	@Test
	public void webTodoToProjectTodo() throws Exception {
		WebProject webProject = TestObjectHelper.getWebProject();
		String id = RandomStringUtils.randomNumeric(3);

		List<ProjectTodo> projectTodos = mapper.webTodoToProjectTodo(webProject, id);

		int i = 0;
		for(ProjectTodo pt : projectTodos){
			assertTrue(pt.getProjectId() == Long.valueOf(id));
			assertEquals(webProject.getWebTodos().get(i).getMessage(), pt.getMessage());
			assertEquals(webProject.getWebTodos().get(i).getEstimatedCost(), pt.getEstimatedCost());
			assertEquals(webProject.getWebTodos().get(i).getEstimatedTime(), pt.getEstimatedTime());
			i++;
		}
	}

}
