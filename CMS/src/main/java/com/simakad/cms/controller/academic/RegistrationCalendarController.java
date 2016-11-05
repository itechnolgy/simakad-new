package com.simakad.cms.controller.academic;

import com.simakad.cms.model.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by HighDream on 11/5/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic/registration/calender")
public class RegistrationCalendarController {

    public String showRegCalendar(Model model) {
        model.addAttribute("view", "newStudent/upload");
        return "layout/default";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }
}
