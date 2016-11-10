package com.simakad.cms.controller.academic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by SRIN on 11/10/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic")
public class AcdemicRegistrationController {

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
        return "";
    }

    @RequestMapping(value = "/course/add" , method = RequestMethod.POST)
    public String addCourse(Model model) {
        return "";
    }
}
