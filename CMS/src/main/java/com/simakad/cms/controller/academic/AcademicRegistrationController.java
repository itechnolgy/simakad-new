package com.simakad.cms.controller.academic;

import com.simakad.dao.dto.CourseRequest;
import com.simakad.dao.entity.Course;
import com.simakad.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by SRIN on 11/10/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic")
public class AcademicRegistrationController {

    @Autowired(required = true)
    CourseService courseService;

    @RequestMapping(value = "/teacher/list" , method = RequestMethod.GET)
    public String showTeacher(Model model) {
        return "";
    }

    @RequestMapping(value = "/teacher/add" , method = RequestMethod.POST)
    public String addTeacher(Model model) {
        return "";
    }

    @RequestMapping(value = "/course/list" , method = RequestMethod.GET)
    public String showCourse(Model model) {
        List<Course> courses = courseService.getCourseList();
        return "/academic/course/list";
    }


    @RequestMapping(value = "/course/add" , method = RequestMethod.POST)
    public String addCourse(@Valid CourseRequest courseRequest, Model model) {
        Course course = courseService.addCourse(courseRequest);
        model.addAttribute("course", course);
        return "/academic/course/list";
    }
}
