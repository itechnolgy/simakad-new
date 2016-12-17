package com.simakad.cms.controller.finance;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.repo.NewStudentDao;
import com.simakad.service.registration.RegPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by SRIN on 11/8/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/finance/")
public class VerifyPaymentController {
    @Autowired
    RegPaymentService regPaymentService;

    NewStudentDao newStudentDao;

    @RequestMapping(value = "/pmb/payment/verification", method = RequestMethod.GET)
    public String verifyPmbPayment(Model model) {
        List<RegPayment> regPaymentList = regPaymentService.getAllPayment();
        model.addAttribute("payments", regPaymentList);
        return "layout/default";
    }

    @RequestMapping(value = "/pmb/payment/doverification", method = RequestMethod.GET)
    public String doVerifyPmbPayment(Model model, @RequestParam("id") long pmbPaymentId, @RequestParam("status") String status) {
        RegPayment regPayment = regPaymentService.updatePaymentStatus(pmbPaymentId, status);
        return "layout/default";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }
}
