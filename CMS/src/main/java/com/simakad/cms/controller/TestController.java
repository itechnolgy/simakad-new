package com.simakad.cms.controller;

import com.simakad.dao.entity.NewStudent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HighDream on 9/11/2016.
 */

/*
Note : comment rest controller annotation
and uncomment controller annotate after implement thymeleaf !!
This is just for example !
 */
//@RestController
@Controller
public class TestController {
    @RequestMapping(value = "/test")
    public String cetak(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
//        NewStudent.Student student = new NewStudent.Student();
//        student.setName("kovan");
//        student.setAddress("cengkareng");
//        model.addAttribute(student);
        return "layout/auth/master";
    }
//
    @RequestMapping(value = "")
    public String index(Model model) {
        return "layout/default/master";
    }
//
////    @RequestMapping(value = "login")
////    public String login(Model model) {
////        model.addAttribute("view", "auth/login");
////        return "layout/auth/master";
////    }
//
    @RequestMapping(value = "forgot")
    public String forgot(Model model) {
        model.addAttribute("view", "auth/forgot");
        return "layout/auth/master";
    }

    @RequestMapping(value = "register")
    public String register(Model model) {
        model.addAttribute("view", "auth/register");
        return "layout/auth/master";
    }
}
