package com.simakad.cms.controller.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.simakad.cms.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

/**
 * Created by HighDream on 10/16/2016.
 */
@Controller
@RequestMapping("/pmb/upload")
public class UploadFileController {
//    @Autowired
//    PmbUploadFileService pmbUploadFileService;

    @RequestMapping(method = RequestMethod.GET)
    public String upload(Model model) {
        model.addAttribute("title", "Upload File");
        model.addAttribute("view", "newStudent/upload");
        return "layout/default";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doUpload(@RequestParam File file, Model model, Authentication auth) {
        MyUserDetails user =(MyUserDetails) auth.getPrincipal();
//        pmbUploadFileService.save(file, PmbUploadFileType.PAYMENT, user.getUsername());
        model.addAttribute("title", "Upload File");
        model.addAttribute("view", "newStudent/upload");
        return "layout/default";
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getDocumentFromType(@PathVariable(value = "type") String type) {
        Map<String, Object> responseObject = new HashMap<>();
        String response = "";

        if(type.equals("pym")) {
            Map<String, Object> paymentObj = new HashMap<>();
            List<Map<String, Object>> paymentList = new LinkedList<>();

            paymentObj.put("type", "registration");
            paymentObj.put("file", "/img.png");
            paymentObj.put("uploadAt", new Date());
            paymentObj.put("status", 2);
            paymentObj.put("reason", null);

            paymentList.add(paymentObj);

            paymentObj = new HashMap<>();

            paymentObj.put("type", "bp3");
            paymentObj.put("file", null);
            paymentObj.put("uploadAt", null);
            paymentObj.put("status", null);
            paymentObj.put("reason", null);

            paymentList.add(paymentObj);

            paymentObj = new HashMap<>();

            paymentObj.put("type", "smt1");
            paymentObj.put("file", null);
            paymentObj.put("uploadAt", null);
            paymentObj.put("status", null);
            paymentObj.put("reason", null);

            paymentList.add(paymentObj);

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
}
