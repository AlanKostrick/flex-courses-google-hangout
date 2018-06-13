package org.wecancodeit.courses;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private CourseRepository courseRepo;

	@Mock
	private Course courseOne;

	@Mock
	private Course courseTwo;

	@Test
	public void shouldBeOkForAllCourses() throws Exception {
		mvc.perform(get("/show-courses")).andExpect(status().isOk());
	}

	@Test
	public void shouldGenerateViewForAllCourses() throws Exception {
		mvc.perform(get("/show-courses")).andExpect(view().name("coursesTemplate"));
	}

	@Test
	public void shouldShowAllCoursesInModel() throws Exception {
		Collection<Course> allCoursesInModel = Arrays.asList(courseOne, courseTwo);
		when(courseRepo.findAll()).thenReturn(allCoursesInModel);
		mvc.perform(get("/show-courses")).andExpect(model().attribute("coursesModel", allCoursesInModel));
	}
	
	@Test
	public void shouldBeOkForACourse() throws Exception {
		mvc.perform(get("/show-single-course?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldGenerateViewForACourse() throws Exception {
		mvc.perform(get("/show-single-course?id=1")).andExpect(view().name("courseTemplate"));
	}
	
	@Test
	public void shouldShowACourseInModel() throws Exception {
		Long courseOneId = 1L;
		when(courseRepo.findOne(courseOneId)).thenReturn(courseOne);
		mvc.perform(get("/show-single-course?id=1")).andExpect(model().attribute("coursesModel", courseOne));
	}

}
