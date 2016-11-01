package com.simakad.cms.controller.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.simakad.cms.config.GlobalVariable;
import com.simakad.cms.controller.ForgotController;
import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.dto.RegUploadFileRequest;
import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.service.RegDocumentService;
import com.simakad.service.RegPaymentService;
import com.simakad.service.RegistrationStaticFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

/**
 * Created by HighDream on 10/16/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/pmb/upload")
public class UploadFileController {
//    @Autowired
//    PmbUploadFileService pmbUploadFileService;
    @Autowired
    RegistrationStaticFileService registrationStaticFileService;

    @Autowired
    RegDocumentService regDocumentService;

    @Autowired
    RegPaymentService regPaymentService;

    @Autowired
    GlobalVariable globalVariable;

    @RequestMapping(method = RequestMethod.GET)
    public String upload(Model model,  Authentication auth) {
        model.addAttribute("title", "Upload File");
        model.addAttribute("view", "newStudent/upload");
        model.addAttribute("userSession", getUserSession(auth));
        return "layout/default";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file, Model model,@Valid RegUploadFileRequest regUploadFileRequest, Authentication auth) {
        MyUserDetails user = getUserSession(auth);
        try {
            RegStaticFile regStaticFile = registrationStaticFileService.save(globalVariable.getUploadBaseUrlNewStudent(), file.getInputStream(), fileTypeConverter(regUploadFileRequest.getDocument()), user.getUsername(), file.getContentType());
            if(regUploadFileRequest.getType().equals("pym")) {
                regPaymentService.updateRegistrationPaymentData(regStaticFile);
            } else {
                regDocumentService.updateDocumentData(regStaticFile);
            }
        } catch (Exception e) {
            System.out.print("Error when upload user registration file. Err = " + e.getMessage());
        }

        model.addAttribute("title", "Upload File");
        model.addAttribute("view", "newStudent/upload");
        model.addAttribute("userSession", user);
        return "layout/default";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(Model model) {
        model.addAttribute("title", "Result");
        model.addAttribute("view", "newStudent/result");
        return "layout/default";
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getDocumentFromType(@PathVariable(value = "type") String type, Authentication auth) {
        MyUserDetails user =(MyUserDetails) auth.getPrincipal();
        Map<String, Object> responseObject = new HashMap<>();
        String response = "";

        if(type.equals("pym")) {
            List<RegPayment> regPaymentList = regPaymentService.getPaymentByStudentId(user.getUsername());
            List<Map<String, Object>> paymentList = new LinkedList<>();
            Map<String, Object> paymentObj;

            for(RegPayment regPayment : regPaymentList) {
                paymentObj = new HashMap<>();
                paymentObj.put("type", regPayment.getType().toString());
                if(Objects.isNull(regPayment.getStaticFile())) paymentObj.put("file", null);
                else paymentObj.put("file", globalVariable.getUploadBaseUrlNewStudent() + regPayment.getStaticFile().getName());
                paymentObj.put("uploadAt", new Date());
                paymentObj.put("status", 2);
                paymentObj.put("reason", null);

                paymentList.add(paymentObj);
            }



//            paymentObj.put("type", "registration");
//            paymentObj.put("file", "/img.png");
//            paymentObj.put("uploadAt", new Date());
//            paymentObj.put("status", 2);
//            paymentObj.put("reason", null);
//
//            paymentList.add(paymentObj);
//
//            paymentObj = new HashMap<>();
//
//            paymentObj.put("type", "bp3");
//            paymentObj.put("file", null);
//            paymentObj.put("uploadAt", null);
//            paymentObj.put("status", null);
//            paymentObj.put("reason", null);
//
//            paymentList.add(paymentObj);
//
//            paymentObj = new HashMap<>();
//
//            paymentObj.put("type", "smt1");
//            paymentObj.put("file", null);
//            paymentObj.put("uploadAt", null);
//            paymentObj.put("status", null);
//            paymentObj.put("reason", null);
//
//            paymentList.add(paymentObj);
//
//            paymentObj = new HashMap<>();
//
//            paymentObj.put("type", "pendaftaran");
//            paymentObj.put("file", null);
//            paymentObj.put("uploadAt", null);
//            paymentObj.put("status", null);
//            paymentObj.put("reason", null);
//
//            paymentList.add(paymentObj);

            responseObject.put("data", paymentList);
        } else if(type.equals("doc")) {
            responseObject.put("data", new LinkedList<>());
        } else {
            responseObject.put("status", "error");
        }

        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            response = ow.writeValueAsString(responseObject);
        } catch (IOException e) {
            response = "{\"status\": \"error\"}";
        }

        return response;
    }

    private RegStaticFileType fileTypeConverter(String val) {
        switch (val) {
            case "registration" :
                return RegStaticFileType.BIAYA_PENDAFTARAN;
            case "bp3" :
                return RegStaticFileType.BIAYA_UANG_MASUK;
            case "toefl" :
                return RegStaticFileType.TOEFL;
            case "ijazah" :
                return RegStaticFileType.IJAZAH;
        }
        return null;
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }
}
