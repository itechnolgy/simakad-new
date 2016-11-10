package com.simakad.cms.controller.registration;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.dto.RegExamScheduleResponse;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegExamResult;
import com.simakad.service.RegExamService;
import com.simakad.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by vikra on 10/25/16.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/pmb")
public class RegistrationProcessController {

    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Autowired
    RegExamService regExamService;

    @RequestMapping(value = "/exam/schedule", method = RequestMethod.GET)
    public String showExamSchedule(Model model, Authentication auth) {
        MyUserDetails userSession = getUserSession(auth);
        NewStudent newStudent = studentRegistrationService.findNewStudent(userSession.getUsername());

        List<RegExamScheduleResponse> regExamScheduleList = regExamService.findExamSchedule(newStudent.getDegreeId());
        model.addAttribute("title", "Exam Schedule");
        model.addAttribute("schedules", regExamScheduleList);
        model.addAttribute("view", "newStudent/schedule");
        return "layout/default";
    }


    @RequestMapping(value = "/exam/result", method = RequestMethod.GET)
    public String showExamResult(Model model, Authentication auth) {
        MyUserDetails userSession = getUserSession(auth);
        NewStudent newStudent = studentRegistrationService.findNewStudent(userSession.getUsername());

        RegExamResult regExamResult = regExamService.findExamResult(newStudent.getId());
        model.addAttribute("title", "Exam Result");
        model.addAttribute("result", regExamResult);
        model.addAttribute("view", "newStudent/result");
        return "layout/default";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }

}
