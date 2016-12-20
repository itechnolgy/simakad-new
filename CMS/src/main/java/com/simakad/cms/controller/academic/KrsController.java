package com.simakad.cms.controller.academic;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.dto.KrsFillingRequest;
import com.simakad.dao.dto.KrsScheduleRequest;
import com.simakad.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HighDream on 11/19/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic")
public class KrsController {
    @Autowired
    KrsService krsService;

    @RequestMapping(value = "/krs/list" , method = RequestMethod.GET)
    public String getAllTeacher(Model model, Authentication auth) {
        model.addAttribute("title", "KRS Lecture");
        model.addAttribute("view", "academic/krs/list");
        model.addAttribute("userSession", getUserSession(auth));
        return "layout/default";
    }

    @RequestMapping(value = "/add/krs_schedule/{id}", method = RequestMethod.GET)
    public String addKrsSchedule(Model model, @PathVariable(value = "id") Long id) {
        if(id == null) {
            model.addAttribute("view", "academic/krs/new");
        }
        else {
            model.addAttribute("view", "academic/krs/edit");
            model.addAttribute("krsClass", krsService.getKrsSchedule(id));
        }
        model.addAttribute("title", "KRS Lecture");

        return "layout/default";
    }

    @RequestMapping(value = "/add/krs_schedule/{id}", method = RequestMethod.POST)
    public String doAddKrsSchedule(Model model, KrsScheduleRequest krsScheduleRequest, @PathVariable(value = "id") Long id) {
        boolean isUpdate = ((id == null) ? false : true);
        krsService.addKrsSchedule(krsScheduleRequest, id);
        return "layout/default";
    }


    @RequestMapping(value = "/fill/krs", method = RequestMethod.POST)
    public String addKrsSchedule(Model model, KrsFillingRequest krsFillingRequest) {
        krsService.fillKrs(krsFillingRequest);
        return "layout/default";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }
}
