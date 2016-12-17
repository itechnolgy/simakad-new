package com.simakad.cms.controller.academic;

import com.simakad.dao.dto.PeriodRequest;
import com.simakad.dao.entity.Period;
import com.simakad.dao.repo.PeriodDao;
import com.simakad.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * Created by HighDream on 10/16/2016.
 */
@Controller
@RequestMapping("/academic/calendar")
public class AcademicPanelController {

    @Autowired
    PeriodService periodService;

    @RequestMapping(value = "/period/all", method = RequestMethod.GET)
    public String getPeriod(Model model) {
        List<Period> periodList = periodService.getAllPeriod();
        model.addAttribute("periods", periodList);
        model.addAttribute("view", "academic/period/list");
        return "layout/default";
    }

    @RequestMapping(value = "/period", method = RequestMethod.GET)
    public String period(Model model) {
        model.addAttribute("view", "academic/period/form");
        return "layout/default";
    }

    @RequestMapping(value = "/period", method = RequestMethod.POST)
    public String postPeriod(@Valid PeriodRequest periodRequest, Model model) {
        if(!isPeriodExist(periodRequest.getYear())) {
            periodService.savePeriod(periodRequest.getYear(), periodRequest.getStartDate(), periodRequest.getEndDate());
            model.addAttribute("view", "academic/period/list");
        }
        else {
            model.addAttribute("view", "academic/period/new");
            model.addAttribute("error", "Period year exist !");
        }
        return "layout/default";
    }

    private boolean isPeriodExist(String year) {
        Period p = periodService.findPeriod(year);
        if(Objects.isNull(p)) return false;
        else return true;
    }
}
