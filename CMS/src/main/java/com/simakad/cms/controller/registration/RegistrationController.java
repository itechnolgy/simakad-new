package com.simakad.cms.controller.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.Lecture;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.StudentRegistration;
import com.simakad.service.LectureRegistrationService;
import com.simakad.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by HighDream on 9/25/2016.
 */
@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Autowired
    LectureRegistrationService lectureRegistrationService;



    @RequestMapping(value = "/newStudent", method = RequestMethod.GET)
    public String studentRegistration(Model model) {
        model.addAttribute("view", "auth/register");
        model.addAttribute("registration", new StudentRegistrationRequest());
        return "layout/auth";
    }

    @RequestMapping(value = "/newStudent", method = RequestMethod.POST)
    public String doStudentRegistration(@Valid StudentRegistrationRequest studentRegistrationRequest, Model model) {
        NewStudent studentRegistration = studentRegistrationService.register(studentRegistrationRequest);
        if(Objects.isNull(studentRegistration)) {
            model.addAttribute("error", "This identity or email has been registered!");
            model.addAttribute("registration", studentRegistrationRequest);
            model.addAttribute("view", "auth/register");
            return "layout/auth";
        }

        model.addAttribute("student", studentRegistration);
        return "redirect:/login?success";
    }

    @RequestMapping(value = "/newStudent/{strataId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String isRegistrationOpen(@PathVariable(value = "strataId") int strataId) {
        Map<String, Object> responseObject = new HashMap<>();
        String response = "";

        responseObject.put("status", (strataId == 1));

        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            response = ow.writeValueAsString(responseObject);
        } catch (IOException e) {
            response = "{\"status\": \"error\"}";
        }

        return response;
    }

    @RequestMapping(value = "/lecture", method = RequestMethod.POST)
    public String doLectureRegistration(@Valid StudentRegistrationRequest lectureRegistrationRequest, Model model){
        Lecture lectureRegistration = lectureRegistrationService.register(lectureRegistrationRequest);
        if(Objects.isNull(lectureRegistration)){
            model.addAttribute("error", "This identity or email has been registered!");
            model.addAttribute("registration", lectureRegistrationRequest);
            model.addAttribute("view", "auth/register");
            return "layout/auth";
        }
        model.addAttribute("lecture", lectureRegistration);
        return "redirect:/login?success";
    }
}
