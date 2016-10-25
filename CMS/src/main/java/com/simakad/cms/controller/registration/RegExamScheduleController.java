package com.simakad.cms.controller.registration;

import com.simakad.service.RegExamScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vikra on 10/25/16.
 */
@Controller
@RequestMapping("/register/examschedule")
public class RegExamScheduleController {

    @Autowired(required = true)
    RegExamScheduleService regExamScheduleService;

    @RequestMapping(method = RequestMethod.GET)
    public String showExamSchedule(Model model) {
        return "layout/auth";
    }



}
