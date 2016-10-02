package com.simakad.cms.controller;

//import com.simakad.service.com.simakad.service.LoginService;
import com.simakad.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SRIN on 9/20/2016.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model) {
//        model.addAttribute("view", "auth/login");
//        return "layout/auth/master";
        model.addAttribute("view", "auth/changePassword");
        model.addAttribute("title", "Change Password");
        return "layout/default/master";
    }
}
