package com.simakad.service.impl;

import com.simakad.dao.constant.*;
import com.simakad.dao.dto.response.StudentScheduleResponse;
import com.simakad.dao.dto.response.StudentSemesterResultResponse;
import com.simakad.dao.entity.*;
import com.simakad.dao.repo.CourseDao;
import com.simakad.dao.repo.CourseResultSheetDao;
import com.simakad.dao.repo.CourseSelectionSheetDao;
import com.simakad.dao.repo.StudentDao;
import com.simakad.service.EmailService;
import com.simakad.service.PeriodService;
import com.simakad.service.StudentService;
import com.simakad.service.UserService;
import com.simakad.service.registration.RegExamService;
import com.simakad.service.registration.RegPaymentService;
import com.simakad.service.registration.RegistrationStaticFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by SRIN on 11/28/2016.
 */
@Component
public class StudentServiceImpl implements StudentService {
    private final int STUDENTID_INITIAL_NUMBER = 1000;

    private HashMap<String, Course> courseHashMap = new HashMap<>();
    private HashMap<Long, CourseSelectionClass> courseSelectionClassHashMap = new HashMap<>();

    private ApplicationContext context;
    private CourseSelectionSheetDao courseSelectionSheetDao;
    private CourseResultSheetDao courseResultSheetDao;
    private CourseDao courseDao;
    private StudentDao studentDao;

    private PeriodService periodService;
    private RegExamService regExamService;
    private UserService userService;
    private EmailService emailService;
    private RegistrationStaticFileService registrationStaticFileService;
    private RegPaymentService regPaymentService;


    @Autowired
    public StudentServiceImpl(ApplicationContext context, CourseSelectionSheetDao courseSelectionSheetDao, CourseResultSheetDao courseResultSheetDao, StudentDao studentDao,
                              PeriodService periodService, RegExamService regExamService, UserService userService, EmailService emailService, RegistrationStaticFileService registrationStaticFileService,
                              RegPaymentService regPaymentService) {
        this.context = context;
        this.courseSelectionSheetDao = courseSelectionSheetDao;
        this.courseResultSheetDao = courseResultSheetDao;
        this.studentDao = studentDao;

        this.periodService = periodService;
        this.regExamService = regExamService;
        this.userService = userService;
        this.emailService = emailService;
        this.registrationStaticFileService = registrationStaticFileService;
        this.regPaymentService = regPaymentService;
    }

    @Override
    public void register() {
        String period = periodService.getAllPeriod().get(0).getAcademicYear();
        List<AcceptedStudentModel> acceptedStudents = getAcceptedStudent();

        createStudentData(acceptedStudents, period);
    }

    private void createStudentData(List<AcceptedStudentModel> acceptedStudentModelList, String period) {
        acceptedStudentModelList.forEach( e -> {
            Student student = createStudent(STUDENTID_INITIAL_NUMBER, period);
            Users login = userService.createUserLogin(student.getId(), UserType.STUDENT, e.userProfile.getId(), e.userProfile.getEmail());
            emailService.sendMessage(EmailType.ACCEPTED_STUDENT, UserType.STUDENT, e.userProfile.getEmail(), login);
        });
    }

    private Student createStudent(int num, String period) {
        String studentId = period + String.format("%04d", num);
        Student student = new Student();
        student.setId(studentId);
        student.setCreationTime(new Date());
        student.setLastUpdateTime(new Date());

        return studentDao.save(student);
    }

    private List<AcceptedStudentModel> getAcceptedStudent() {
        List<RegExamResult> regExamResultList = regExamService.getAllExamResult();

        List<AcceptedStudentModel> acceptedStudentModelList = new ArrayList<>();
        for(RegExamResult r : regExamResultList) {
            if(r.getStatus() == RegExamResultType.LULUS && isPaymentFirstSemesterDone(r.getStudentId())) {
                UserProfile userProfile = userService.getUserProfile(r.getStudentId());
                acceptedStudentModelList.add(new AcceptedStudentModel(userProfile.getName(), userProfile, r.getNewStudent(context).getDegreeId(), r.getStudentId()));

            }
        }
        return sortStudent(acceptedStudentModelList);
    }

    private List<AcceptedStudentModel> sortStudent(List<AcceptedStudentModel> acceptedStudentModelList) {
        Collections.sort(acceptedStudentModelList, new Comparator<AcceptedStudentModel>() {
            @Override
            public int compare(AcceptedStudentModel profile2, AcceptedStudentModel profile1) {

                return profile1.getName().compareTo(profile2.getName());
            }
        });
        return acceptedStudentModelList;
    }

    private boolean isPaymentFirstSemesterDone(String registrationStudentId) {
        RegPayment regPayment = regPaymentService.getPaymentByStudentIdAndType(registrationStudentId, RegStaticFileType.BIAYA_UANG_MASUK);
        if(regPayment.getStatus() == VerificationType.ACCEPTED) return true;
        else return false;
    }

    @Override
    public StudentScheduleResponse showSchedule(String studentId) {
        List<CourseSelectionSheet> courseSelectionSheetList = courseSelectionSheetDao.getByStudentId(studentId);

        StudentScheduleResponse response = new StudentScheduleResponse();
        for(CourseSelectionSheet c : courseSelectionSheetList) {
            CourseSelectionClass selectionClass = courseSelectionClassHashMap.get(c.getCourseSelectionClassId());
            if(Objects.isNull(selectionClass)) {
                selectionClass = c.getCourseSelectionClass(context);
                courseSelectionClassHashMap.put(selectionClass.getId(), selectionClass);
            }

            Course course = getCourse(selectionClass.getCourseId());
            response.addCourseDetail(course.getCourseName(), selectionClass.getSchedule().toString());
        }

        return response;
    }


    @Override
    public StudentSemesterResultResponse showSemesterResult(String studentId, int semester) {
        List<CourseResultSheet> courseResultSheetList = courseResultSheetDao.findByStudentIdAndAppliedSemester(studentId, semester);
        return generateSemesterResultResponse(courseResultSheetList);
    }

    private StudentSemesterResultResponse generateSemesterResultResponse(List<CourseResultSheet> courseResultSheetList) {
        List<String> letterScoreList = new ArrayList<>();
        int totalSks = 0;
        int letterPoints = 0;
        double ips = 0;

        StudentSemesterResultResponse response = new StudentSemesterResultResponse();
        for(CourseResultSheet c : courseResultSheetList) {
            Course course = getCourse(c.getCourseId());
            response.addResult(course.getCourseName(), c.getAssignmentScore(), c.getMidExamScore(), c.getFinalExamScore(), c.getFinalScore(), c.getFinalGrade());
            letterScoreList.add(c.getFinalGrade());
            totalSks += course.getSemesterCreditNumber();
            letterPoints += getLetterPoint(c.getFinalGrade());
        }

        ips = letterPoints/totalSks;
        response.setTotalSks(totalSks);
        response.setIps(ips);

        return response;
    }

    private Course getCourse(String courseId) {
        Course course = courseHashMap.get(courseId);
        if(Objects.isNull(course)) {
            course = courseDao.findOne(courseId);
            courseHashMap.put(course.getId(), course);
        }
        return course;
    }

    private int getLetterPoint(String letterGrade) {
        switch (letterGrade) {
            case "A" :
                return 4;
            case "B" :
                return 3;
            case "C" :
                return 2;
            case "D" :
                return 1;
            default:
                return 0;
        }
    }

    private class AcceptedStudentModel {
        private String name;
        private UserProfile userProfile;
        private Long degreeId;
        private String studentRegistrationId;

        public AcceptedStudentModel(String name, UserProfile userProfile, Long degreeId, String studentRegistrationId) {
            this.name = name;
            this.userProfile = userProfile;
            this.degreeId = degreeId;
            this.studentRegistrationId = studentRegistrationId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
