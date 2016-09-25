package com.simakad.cms.controller;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.entity.NewStudent;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
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
@Secured({"ROLE_USER"})
public class TestController {
    @RequestMapping(value = "/test")
    public String cetak(Model model, Authentication authentication) {
        MyUserDetails user =(MyUserDetails) authentication.getPrincipal();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.print("Kovan data =" + user.getUsername() + "/" + user.getRole() + "/" + user.getPassword());
        return "layout/default/master";
    }

    @RequestMapping(value = "forgot")
    public String forgot(Model model) {
        model.addAttribute("view", "auth/forgot");
        return "layout/auth/master";
    }

//    @RequestMapping(value = "register")
//    public String register(Model model) {
//        model.addAttribute("view", "auth/register");
//        return "layout/auth/master";
//    }
}
