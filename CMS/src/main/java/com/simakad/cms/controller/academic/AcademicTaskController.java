package com.simakad.cms.controller.academic;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.dto.CourseRequest;
import com.simakad.dao.dto.LectureRequest;
import com.simakad.dao.dto.response.LectureResponse;
import com.simakad.dao.entity.Course;
import com.simakad.dao.entity.Lecture;
import com.simakad.service.CourseService;
import com.simakad.service.LectureRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by SRIN on 11/10/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic")
public class AcademicTaskController {

    @Autowired(required = true)
    CourseService courseService;

    @Autowired
    LectureRegistrationService lectureService;

    @RequestMapping(value = "/lecture/list" , method = RequestMethod.GET)
    public String getAllTeacher(Model model, Authentication auth) {
        LectureResponse lectureList = lectureService.getLectureList();
        model.addAttribute("title", "List Lecture");
        model.addAttribute("view", "academic/lecture/list");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("lectureList", lectureList);
        return "layout/default";
    }

    @RequestMapping(value = "/lecture/add" , method = RequestMethod.GET)
    public String showAddTeacher(Model model, Authentication auth) {
        LectureRequest lectureRequest = new LectureRequest();
        model.addAttribute("title", "Add New Lecture");
        model.addAttribute("view", "academic/lecture/new");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("lecture", lectureRequest);
        return "layout/default";
    }

    @RequestMapping(value = "/lecture/add" , method = RequestMethod.POST)
    public String addTeacher(@Valid LectureRequest lectureRequest) {
        lectureService.register(lectureRequest);
        return "redirect:/academic/lecture/list";
    }

    @RequestMapping(value = "/lecture/edit/{lectureUsername}" , method = RequestMethod.GET)
    public String showEditLecture(@PathVariable("lectureUsername") String lectureUsername, Model model, Authentication auth) {
        Course course = courseService.getCourseByCourseId(lectureUsername);
        model.addAttribute("title", "Edit Course");
        model.addAttribute("view", "academic/lecture/edit");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("course", course);
        return "layout/default";
    }

    @RequestMapping(value = "/course/list" , method = RequestMethod.GET)
    public String getAllCourse(Model model, Authentication auth) {
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("title", "List Courses");
        model.addAttribute("view", "academic/course/list");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("courseList", courseList);
        return "layout/default";
    }

    @RequestMapping(value = "/course/degree/{degree}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getCourseByDegreeId(@PathVariable("degree") Integer degreeId, Model model, Authentication auth) {
        List<Course> courseList = courseService.getCourseListByDegree(degreeId);
        model.addAttribute("title", "Course List");
        model.addAttribute("view", "academic/course/edit");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("courseList", courseList);
        return "layout/default";
    }

    @RequestMapping(value = "/course/semester/{semester}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getCourseBySemester(@PathVariable("semester") Integer semester, Model model, Authentication auth) {
        List<Course> courseList = courseService.getCourseListBySemester(semester);
        model.addAttribute("title", "Course List");
        model.addAttribute("view", "academic/course/list");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("courseList", courseList);
        return "layout/default";
    }

    @RequestMapping(value = "/course/add" , method = RequestMethod.GET)
    public String showAddCourse(Model model, Authentication auth) {
        CourseRequest courseRequest = new CourseRequest();
        model.addAttribute("title", "Add New Course");
        model.addAttribute("view", "academic/course/new");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("course", courseRequest);
        return "layout/default";
    }


    @RequestMapping(value = "/course/add" , method = RequestMethod.POST)
    public String addCourse(@Valid CourseRequest courseRequest, Model model, Authentication auth) {
        courseService.addCourse(courseRequest);
        model.addAttribute("title", "Add New Course");
        model.addAttribute("view", "academic/course/new");
        model.addAttribute("userSession", getUserSession(auth));
        CourseRequest newCourseRequest = new CourseRequest();
        model.addAttribute("course", newCourseRequest);
        return "layout/default";
    }

    @RequestMapping(value = "/course/edit/{courseId}" , method = RequestMethod.GET)
    public String showEditCourse(@PathVariable("courseId") String courseId, Model model, Authentication auth) {
        Course course = courseService.getCourseByCourseId(courseId);
        model.addAttribute("title", "Edit Course");
        model.addAttribute("view", "academic/course/edit");
        model.addAttribute("userSession", getUserSession(auth));
        model.addAttribute("course", course);
        return "layout/default";
    }

    @RequestMapping(value = "/course/edit/{courseId}" , method = RequestMethod.POST)
    public String EditCourse(@Valid CourseRequest courseRequest, Authentication auth, @PathVariable("courseId") String courseId) {
        courseService.editCourse(courseRequest);
        return "redirect:/academic/course/list";
    }

    @RequestMapping(value = "/course/delete/{courseId}" , method = RequestMethod.POST)
    public String DeleteCourse(@PathVariable("courseId") String courseId, Authentication auth) {
        courseService.deleteCourse(courseId);
        return "redirect:/academic/course/list";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }


}
