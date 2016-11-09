package com.simakad.cms.controller;

//import com.simakad.service.com.simakad.service.LoginService;
import com.simakad.cms.model.MyUserDetails;
import com.simakad.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by SRIN on 9/20/2016.
 */

@Controller
@SessionAttributes("userSession")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("view", "auth/login");
        return "layout/auth";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, Authentication authentication) {
        MyUserDetails userSession = getUserSession(authentication);
        model.addAttribute("userSession", userSession);
        return "layout/default";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }

}
