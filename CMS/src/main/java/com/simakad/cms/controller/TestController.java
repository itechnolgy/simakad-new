package com.simakad.cms.controller;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.entity.NewStudent;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
//import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HighDream on 9/11/2016.
 */

/*
Note : comment rest controller annotation
and uncomment controller annotate after implement thymeleaf !!
This is just for example !
 */
//@RestController
@Controller
public class TestController {
    @RequestMapping(value = "/")
    public String cetak(Model model, Authentication authentication) {
        MyUserDetails user =(MyUserDetails) authentication.getPrincipal();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.print("Kovan data =" + user.getUsername() + "/" + user.getRole() + "/" + user.getPassword());
        return "layout/default";
    }

    @RequestMapping(value = "/student/transcript/{semester}", method = RequestMethod.GET)
    public @ResponseBody String getTranscript(@PathVariable("semester") String semester) {
        switch (semester) {
            case "1" :
                return "{\"transcript\":[" +
                        "{\"courseName\":\"Twitterwire\",\"sks\":8,\"assignment\":77,\"midExam\":59,\"finalExam\":1,\"grade\":\"F\"}," +
                        "{\"courseName\":\"InnoZ\",\"sks\":4,\"assignment\":7,\"midExam\":91,\"finalExam\":68,\"grade\":\"A\"}," +
                        "{\"courseName\":\"Buzzdog\",\"sks\":8,\"assignment\":80,\"midExam\":47,\"finalExam\":18,\"grade\":\"D\"}," +
                        "{\"courseName\":\"Podcat\",\"sks\":2,\"assignment\":30,\"midExam\":21,\"finalExam\":14,\"grade\":\"D\"}," +
                        "{\"courseName\":\"Linkbuzz\",\"sks\":8,\"assignment\":60,\"midExam\":72,\"finalExam\":34,\"grade\":\"F\"}," +
                        "{\"courseName\":\"Thoughtstorm\",\"sks\":4,\"assignment\":82,\"midExam\":9,\"finalExam\":93,\"grade\":\"C\"}]}";
            case "2":
                return "{\"transcript\":[" +
                        "{\"courseName\":\"Quamba\",\"sks\":2,\"assignment\":54,\"midExam\":100,\"finalExam\":95,\"grade\":\"B\"}," +
                        "{\"courseName\":\"Blogtags\",\"sks\":2,\"assignment\":10,\"midExam\":61,\"finalExam\":24,\"grade\":\"B\"}," +
                        "{\"courseName\":\"Skilith\",\"sks\":6,\"assignment\":90,\"midExam\":65,\"finalExam\":37,\"grade\":\"E\"}," +
                        "{\"courseName\":\"Fanoodle\",\"sks\":6,\"assignment\":70,\"midExam\":44,\"finalExam\":66,\"grade\":\"F\"}," +
                        "{\"courseName\":\"Gabcube\",\"sks\":8,\"assignment\":70,\"midExam\":89,\"finalExam\":25,\"grade\":\"A\"}," +
                        "{\"courseName\":\"Shufflebeat\",\"sks\":6,\"assignment\":46,\"midExam\":78,\"finalExam\":77,\"grade\":\"A\"}," +
                        "{\"courseName\":\"Camido\",\"sks\":2,\"assignment\":26,\"midExam\":54,\"finalExam\":55,\"grade\":\"A\"}]}";
            default:
                return "{\"transcript\":[" +
                        "{\"courseName\":\"Eazzy\",\"sks\":8,\"assignment\":86,\"midExam\":79,\"finalExam\":15,\"grade\":\"B\"}," +
                        "{\"courseName\":\"Zoonoodle\",\"sks\":8,\"assignment\":24,\"midExam\":52,\"finalExam\":79,\"grade\":\"F\"}," +
                        "{\"courseName\":\"Jaxbean\",\"sks\":4,\"assignment\":7,\"midExam\":27,\"finalExam\":1,\"grade\":\"D\"}," +
                        "{\"courseName\":\"Blogtag\",\"sks\":2,\"assignment\":7,\"midExam\":30,\"finalExam\":45,\"grade\":\"E\"}," +
                        "{\"courseName\":\"Oozz\",\"sks\":8,\"assignment\":86,\"midExam\":56,\"finalExam\":94,\"grade\":\"D\"}," +
                        "{\"courseName\":\"Realcube\",\"sks\":2,\"assignment\":48,\"midExam\":95,\"finalExam\":35,\"grade\":\"C\"}," +
                        "{\"courseName\":\"Gigabox\",\"sks\":4,\"assignment\":48,\"midExam\":46,\"finalExam\":1,\"grade\":\"B\"}," +
                        "{\"courseName\":\"Bubbletube\",\"sks\":4,\"assignment\":67,\"midExam\":10,\"finalExam\":45,\"grade\":\"F\"}]}";
        }
    }
}
