package com.simakad.cms.controller.academic;

import com.simakad.dao.constant.RegExamResultType;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegExamResult;
import com.simakad.dao.entity.UserProfile;
import com.simakad.service.PeriodService;
import com.simakad.service.StudentService;
import com.simakad.service.UserProfileService;
import com.simakad.service.UserService;
import com.simakad.service.registration.RegExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by SRIN on 12/15/2016.
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/pmb")
public class RegistrationPanelController {
    @Autowired
    StudentService studentService;

    // TODO : prepare UI to close the registration, then  this process will generate new NIM and send them pass to login
    @RequestMapping(value = "/close/registration", method = RequestMethod.POST)
    public String closeRegistration() {
        studentService.register();
        return "layout/default";
    }

}
