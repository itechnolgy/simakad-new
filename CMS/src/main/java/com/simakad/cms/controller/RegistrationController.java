package com.simakad.cms.controller;

import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.StudentRegistration;
import com.simakad.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by HighDream on 9/25/2016.
 */
@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
    @Autowired
    StudentRegistrationService studentRegistrationService;

    @RequestMapping(method = RequestMethod.GET)
    public String studentRegistration(Model model) {
        model.addAttribute("view", "auth/register");
        model.addAttribute("registration", new StudentRegistration());
        return "layout/auth/master";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doStudentRegistration(@Valid StudentRegistrationRequest studentRegistrationRequest, Model model) {
        StudentRegistration studentRegistration = studentRegistrationService.register(studentRegistrationRequest);
        if(Objects.isNull(studentRegistration)) {
            model.addAttribute("error", "This identity or email has been registered!");
            return "layout/auth/master";
        }

        model.addAttribute("student", studentRegistration);
        return "layout/auth/master";
    }
}
