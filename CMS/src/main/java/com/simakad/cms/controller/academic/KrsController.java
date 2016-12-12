package com.simakad.cms.controller.academic;

import com.simakad.dao.dto.KrsFillingRequest;
import com.simakad.dao.dto.KrsScheduleRequest;
import com.simakad.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/courses/{degree}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getCourses(@PathVariable("degree") Integer degreeId) {
        String response;

        switch (degreeId) {
            case 1:
                response = "{\"data\":[{\"id\":1,\"course_name\":\"LSS\"},{\"id\":2,\"course_name\":\"Equipment Repair\"}," +
                        "{\"id\":3,\"course_name\":\"MySpace\"},{\"id\":4,\"course_name\":\"Kaspersky\"}," +
                        "{\"id\":5,\"course_name\":\"Nitrous Oxide\"},{\"id\":6,\"course_name\":\"IntelliJ IDEA\"}," +
                        "{\"id\":7,\"course_name\":\"International HR\"},{\"id\":8,\"course_name\":\"LLDPE\"}," +
                        "{\"id\":9,\"course_name\":\"Reality TV\"},{\"id\":10,\"course_name\":\"JTest\"}," +
                        "{\"id\":11,\"course_name\":\"IED\"},{\"id\":12,\"course_name\":\"JBoss Application Server\"}," +
                        "{\"id\":13,\"course_name\":\"Unix\"},{\"id\":14,\"course_name\":\"USDA\"}," +
                        "{\"id\":15,\"course_name\":\"Rig\"},{\"id\":16,\"course_name\":\"Klout\"}," +
                        "{\"id\":17,\"course_name\":\"LPIC\"},{\"id\":18,\"course_name\":\"RTLS\"}," +
                        "{\"id\":19,\"course_name\":\"Norton Utilities\"},{\"id\":20,\"course_name\":\"Guest Lecturing\"}]}";

            break;
            case 2:
                response = "{\"data\":[{\"id\":1,\"course_name\":\"Single Family Homes\"},{\"id\":2,\"course_name\":\"Educational Outreach\"}," +
                        "{\"id\":3,\"course_name\":\"UCP\"},{\"id\":4,\"course_name\":\"Integrated Circuit Design\"}," +
                        "{\"id\":5,\"course_name\":\"LPT\"},{\"id\":6,\"course_name\":\"Sun One LDAP\"}," +
                        "{\"id\":7,\"course_name\":\"Aerial Lifts\"},{\"id\":8,\"course_name\":\"GTS\"}," +
                        "{\"id\":9,\"course_name\":\"RHIA\"},{\"id\":10,\"course_name\":\"Flight Safety\"}," +
                        "{\"id\":11,\"course_name\":\"Bylined Articles\"},{\"id\":12,\"course_name\":\"NREMT\"}," +
                        "{\"id\":13,\"course_name\":\"MyChart\"},{\"id\":14,\"course_name\":\"Eclipse RCP\"}," +
                        "{\"id\":15,\"course_name\":\"Substance Use Disorders\"},{\"id\":16,\"course_name\":\"CSV\"}," +
                        "{\"id\":17,\"course_name\":\"Ffmpeg\"},{\"id\":18,\"course_name\":\"BMI\"}," +
                        "{\"id\":19,\"course_name\":\"International Relations\"},{\"id\":20,\"course_name\":\"FMS\"}]}";
                break;
            case 3:
                response = "{\"data\":[{\"id\":1,\"course_name\":\"MSA\"},{\"id\":2,\"course_name\":\"LCD Projectors\"}," +
                        "{\"id\":3,\"course_name\":\"European History\"},{\"id\":4,\"course_name\":\"Infor XA\"}," +
                        "{\"id\":5,\"course_name\":\"RFC\"},{\"id\":6,\"course_name\":\"iOS\"}," +
                        "{\"id\":7,\"course_name\":\"Corporate Tax\"},{\"id\":8,\"course_name\":\"Business Planning\"}," +
                        "{\"id\":9,\"course_name\":\"SFP\"},{\"id\":10,\"course_name\":\"Kickboxing\"}," +
                        "{\"id\":11,\"course_name\":\"UAT Coordination\"},{\"id\":12,\"course_name\":\"DBUnit\"}," +
                        "{\"id\":13,\"course_name\":\"English\"},{\"id\":14,\"course_name\":\"Classical Guitar\"}," +
                        "{\"id\":15,\"course_name\":\"Organizational Effectiveness\"},{\"id\":16,\"course_name\":\"Cisco VPN\"}," +
                        "{\"id\":17,\"course_name\":\"DCP\"},{\"id\":18,\"course_name\":\"ICAO\"}," +
                        "{\"id\":19,\"course_name\":\"JSON\"},{\"id\":20,\"course_name\":\"Fleet Management\"}]}";
                break;
            case 4:
                response = "{\"data\":[{\"id\":1,\"course_name\":\"Blackberry Enterprise Server\"},{\"id\":2,\"course_name\":\"MVC Architecture\"}," +
                        "{\"id\":3,\"course_name\":\"SMED\"},{\"id\":4,\"course_name\":\"AASHTO\"}," +
                        "{\"id\":5,\"course_name\":\"BD+C\"},{\"id\":6,\"course_name\":\"OA Framework\"}," +
                        "{\"id\":7,\"course_name\":\"SNL\"},{\"id\":8,\"course_name\":\"TMMi\"}," +
                        "{\"id\":9,\"course_name\":\"IP CCTV\"},{\"id\":10,\"course_name\":\"ENOVIA LCA\"}," +
                        "{\"id\":11,\"course_name\":\"Rent to Own\"},{\"id\":12,\"course_name\":\"TCAP\"}," +
                        "{\"id\":13,\"course_name\":\"TTCN\"},{\"id\":14,\"course_name\":\"Broadcast Journalism\"}," +
                        "{\"id\":15,\"course_name\":\"Change Orders\"},{\"id\":16,\"course_name\":\"NYMEX\"}," +
                        "{\"id\":17,\"course_name\":\"UV\"},{\"id\":18,\"course_name\":\"Universal Life\"}," +
                        "{\"id\":19,\"course_name\":\"Lung\"},{\"id\":20,\"course_name\":\"Offset Printing\"}]}";
                break;
            default:
                response = "{\"data\":[]}";
                break;
        }

        return response;
    }

    @RequestMapping(value = "/lectures", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getLectures() {
        return "{\"data\":[{\"id\":1,\"lecture_name\":\"Sarah Watson\"},{\"id\":2,\"lecture_name\":\"Chris Webb\"}," +
                "{\"id\":3,\"lecture_name\":\"Jeffrey Young\"},{\"id\":4,\"lecture_name\":\"Rachel Brooks\"}," +
                "{\"id\":5,\"lecture_name\":\"Cynthia Fox\"},{\"id\":6,\"lecture_name\":\"Brian Hudson\"}," +
                "{\"id\":7,\"lecture_name\":\"Jerry Moore\"},{\"id\":8,\"lecture_name\":\"Jennifer Armstrong\"}," +
                "{\"id\":9,\"lecture_name\":\"David Grant\"},{\"id\":10,\"lecture_name\":\"Martha Weaver\"}," +
                "{\"id\":11,\"lecture_name\":\"Harold Sanchez\"},{\"id\":12,\"lecture_name\":\"Charles Porter\"}," +
                "{\"id\":13,\"lecture_name\":\"Andrew Ramirez\"},{\"id\":14,\"lecture_name\":\"Louis Gilbert\"}," +
                "{\"id\":15,\"lecture_name\":\"Denise Hughes\"},{\"id\":16,\"lecture_name\":\"Diana Willis\"}," +
                "{\"id\":17,\"lecture_name\":\"Fred Ramos\"},{\"id\":18,\"lecture_name\":\"Tammy Cole\"}," +
                "{\"id\":19,\"lecture_name\":\"Angela Robinson\"},{\"id\":20,\"lecture_name\":\"Shirley Ruiz\"}]}";
    }
}
