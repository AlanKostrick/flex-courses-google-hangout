package org.wecancodeit.courses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class CourseRepositoryTest {

	CourseRepository underTest;

	Long courseOneId = 1L;
	Course courseOne = new Course(courseOneId, "course one name", "course one description");

	Long courseTwoId = 2L;
	Course courseTwo = new Course(courseTwoId, "course two name", "course two description");

	@Test
	public void shouldFindCourseOne() {
		underTest = new CourseRepository(courseOne);
		Course foundCourse = underTest.findOne(courseOneId);
		assertThat(foundCourse, is(courseOne));
	}

	@Test
	public void shouldFindCourseTwo() {
		underTest = new CourseRepository(courseTwo);
		Course foundCourse = underTest.findOne(courseTwoId);
		assertThat(foundCourse, is(courseTwo));
	}

	@Test
	public void shouldFindAllCourses() {
		underTest = new CourseRepository(courseOne, courseTwo);
		Collection<Course> foundCourses = underTest.findAll();
		assertThat(foundCourses, containsInAnyOrder(courseOne, courseTwo));
	}

	@Test
	public void shouldRenderCourseProperties() {
		String name = courseOne.getName();
		String description = courseOne.getDescription();
		assertThat(name, is("course one name"));
		assertThat(description, is("course one description"));

	}

}
