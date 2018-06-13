package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

	@Resource
	CourseRepository courseRepo;

	@RequestMapping("/show-courses")
	public String findAllCourses(Model model) {
		model.addAttribute("coursesModel", courseRepo.findAll());
		return "coursesTemplate";
	}

	@RequestMapping("/show-single-course")
	public String findOneCourse(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("coursesModel", courseRepo.findOne(id));
		return "courseTemplate";
	}

}
