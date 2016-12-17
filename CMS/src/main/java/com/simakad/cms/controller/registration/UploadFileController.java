package com.simakad.cms.controller.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.simakad.cms.config.GlobalVariable;
import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.dto.RegUploadFileRequest;
import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.service.registration.RegDocumentService;
import com.simakad.service.registration.RegPaymentService;
import com.simakad.service.registration.RegistrationStaticFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

/**
 * Created by HighDream on 10/16/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/pmb/upload")
public class UploadFileController {
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
        List<Map<String, Object>> objList = new LinkedList<>();
        Map<String, Object> mapObj;
        
        if(type.equals("pym")) {
            List<RegPayment> regPaymentList = regPaymentService.getPaymentByStudentId(user.getUsername());
            for(RegPayment regPayment : regPaymentList) {
                mapObj = new HashMap<>();
                mapObj.put("type", regPayment.getType().toString());
                if(Objects.isNull(regPayment.getStaticFile())) {
                    mapObj.put("file", null);
                    mapObj.put("uploadAt", null);
                }
                else {
                    mapObj.put("file", globalVariable.getUploadBaseUrlNewStudent() + regPayment.getStaticFile().getName());
                    mapObj.put("uploadAt", regPayment.getStaticFile().getCreationTime());
                }
                mapObj.put("status", regPayment.getStatus().toString());
                mapObj.put("reason", regPayment.getReason());
                objList.add(mapObj);
            }
        } else if(type.equals("doc")) {
            List<RegDocument> regDocumentList = regDocumentService.getDocumentByStudentId(user.getUsername());
            for(RegDocument regDocument : regDocumentList) {
                mapObj = new HashMap<>();
                mapObj.put("type", regDocument.getType().toString());
                if(Objects.isNull(regDocument.getStaticFile())) {
                    mapObj.put("file", null);
                    mapObj.put("uploadAt", null);
                }
                else {
                    mapObj.put("file", globalVariable.getUploadBaseUrlNewStudent() + regDocument.getStaticFile().getName());
                    mapObj.put("uploadAt", regDocument.getStaticFile().getCreationTime());
                }
                mapObj.put("status", regDocument.getStatus().toString());
                mapObj.put("reason", regDocument.getReason());
                objList.add(mapObj);
            }
        } else {
            responseObject.put("status", "error");
        }

        responseObject.put("data", objList);
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
            case "BIAYA_PENDAFTARAN" :
                return RegStaticFileType.BIAYA_PENDAFTARAN;
            case "BIAYA_UANG_MASUK" :
                return RegStaticFileType.BIAYA_UANG_MASUK;
            case "TOEFL" :
                return RegStaticFileType.TOEFL;
            case "IJAZAH" :
                return RegStaticFileType.IJAZAH;
            case "RAPOR" :
                return RegStaticFileType.RAPOR;
        }
        return null;
    }

    private MyUserDetails getUserSession(Authentication auth) {
        return (MyUserDetails) auth.getPrincipal();
    }
}
