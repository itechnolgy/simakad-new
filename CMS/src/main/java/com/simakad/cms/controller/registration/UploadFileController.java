package com.simakad.cms.controller.registration;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.service.PmbUploadFileService;
import com.simakad.service.constant.PmbUploadFileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.security.Principal;

/**
 * Created by HighDream on 10/16/2016.
 */
@Controller
@RequestMapping("/pmb/upload")
public class UploadFileController {
    @Autowired
    PmbUploadFileService pmbUploadFileService;

    @RequestMapping(method = RequestMethod.GET)
    public String upload(Model model) {
        model.addAttribute("view", "newStudent/upload");
        return "layout/default";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doUpload(@RequestParam File file, Model model, Authentication auth) {
        MyUserDetails user =(MyUserDetails) auth.getPrincipal();
        pmbUploadFileService.save(file, PmbUploadFileType.PAYMENT, user.getUsername());
        model.addAttribute("view", "newStudent/upload");
        return "layout/default";
    }

}
