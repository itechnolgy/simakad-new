package com.simakad.cms.controller.academic;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegExamResult;
import com.simakad.service.registration.RegDocumentService;
import com.simakad.service.registration.RegExamService;
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
 * Created by SRIN on 11/10/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "/academic")
public class VerifyExamResultController {
    @Autowired
    RegExamService regExamService;

    @Autowired
    RegDocumentService regDocumentService;

    @RequestMapping(value = "/pmb/examresult/verification", method = RequestMethod.GET)
    public String pmbExamResult(Model model, Authentication auth) {
        List<RegExamResult> regExamResultList = regExamService.getAllExamResult();
        model.addAttribute("title", "New Student Exam Result Verification");
        model.addAttribute("view", "/academic/registrationResult/list");
        model.addAttribute("examResults", regExamResultList);
        model.addAttribute("userSession", getUserSession(auth));
        return "layout/default";
    }

    @RequestMapping(value = "/pmb/examresult/doverification", method = RequestMethod.GET)
    public String pmbExamResultVerification(Model model, @RequestParam("studentId") String studentId, @RequestParam("status") String status) {
        RegExamResult regExamResult = regExamService.updateExamResult(studentId, status);
        return "layout/default";
    }

    @RequestMapping(value = "/pmb/document/verification", method = RequestMethod.GET)
    public String pmbDocument(Model model, Authentication auth) {
        List<RegDocument> regDocuments = regDocumentService.getAllDocument();
        model.addAttribute("title", "New Student Document Verification");
        model.addAttribute("view", "/academic/document/list");
        model.addAttribute("documents", regDocuments);
        model.addAttribute("userSession", getUserSession(auth));
        return "layout/default";
    }

    @RequestMapping(value = "/pmb/document/doverification", method = RequestMethod.GET)
    public String pmbDocumentVerification(Model model, @RequestParam("docId") long documentId, @RequestParam("status") String status) {
        RegDocument regDocument = regDocumentService.verifyDocument(documentId, status);
        return "layout/default";
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }

}
