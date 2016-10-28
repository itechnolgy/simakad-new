package com.simakad.cms.controller;

import com.simakad.dao.constant.EmailType;
import com.simakad.dao.dto.ForgotRequest;
import com.simakad.dao.entity.Users;
import com.simakad.service.EmailService;
import com.simakad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by SRIN on 10/28/2016.
 */

@Controller
@RequestMapping ("/forgot")
public class ForgotController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @RequestMapping(method = RequestMethod.GET)
    public String forgot (Model model){
        model.addAttribute("view","auth/forgot");
        model.addAttribute("forgot",new ForgotRequest());
        return "layout/auth";
    }

    @RequestMapping (method = RequestMethod.POST)
    public String doForgot (@Valid ForgotRequest forgotRequest, Model model){
        Users users = userService.forgotPassword(forgotRequest.getEmail());
        if(Objects.isNull(users)) {
            model.addAttribute("error","Email not registered");
        }
        else{
            emailService.sendMessage(EmailType.FORGOT_PASSWORD, forgotRequest.getEmail(), users);
            forgotRequest.setEmail("");
        }
        model.addAttribute("forgot", forgotRequest);
        model.addAttribute("view","auth/forgot");
        return "layout/auth";
    }
}
