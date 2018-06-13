package org.wecancodeit.courses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

	Map<Long, Course> listOfCourses = new HashMap<>();

	// real data
	public CourseRepository() {
		Course reading = new Course(1L, "Reading", "I love J.R.R. Tolkien");
		Course music = new Course(2L, "Music", "School of Rock!");
		Course java = new Course(3L, "Java", "So easy yeahhhh");

		listOfCourses.put(reading.getId(), reading);
		listOfCourses.put(music.getId(), music);
		listOfCourses.put(java.getId(), java);

	}

	// uses java's varargs ...
	// for testing purposes only
	public CourseRepository(Course... anyAmountOfCourses) {
		for (Course anyCourse : anyAmountOfCourses) {
			listOfCourses.put(anyCourse.getId(), anyCourse);
		}
	}

	public Course findOne(Long id) {
		return listOfCourses.get(id);
	}

	public Collection<Course> findAll() {
		return listOfCourses.values();
	}

}
