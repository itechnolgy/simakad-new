package com.simakad.cms.controller.academic;

import com.simakad.dao.dto.KrsFillingRequest;
import com.simakad.dao.dto.KrsScheduleRequest;
import com.simakad.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by HighDream on 11/19/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic")
public class KrsController {
    @Autowired
    KrsService krsService;


    @RequestMapping(value = "/add/krs_schedule", method = RequestMethod.POST)
    public String addKrsSchedule(Model model, KrsScheduleRequest krsScheduleRequest) {
        krsService.addKrsSchedule(krsScheduleRequest);
        return "layout/default";
    }


    @RequestMapping(value = "/fill/krs", method = RequestMethod.POST)
    public String addKrsSchedule(Model model, KrsFillingRequest krsFillingRequest) {
        krsService.fillKrs(krsFillingRequest);
        return "layout/default";
    }
}
