package com.simakad.service;

import com.simakad.dao.constant.EmailType;
import com.simakad.dao.constant.UserType;
import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.dto.response.TeachingScheduleResponse;
import com.simakad.dao.entity.CourseSelectionClass;
import com.simakad.dao.entity.Lecture;
import com.simakad.dao.entity.UserProfile;
import com.simakad.dao.entity.Users;
import com.simakad.dao.repo.LectureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * Created by wendy on 11/21/16.
 */
@Component
@Transactional
public class LectureRegistrationServiceImpl implements LectureRegistrationService {

    private final String registrationIdSeq = "seq_lecture_registration";
    private final String prefixRegistration = "D";

    @Autowired
    ApplicationContext context;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    LectureDao lectureDao;

    @Autowired
    KrsService krsService;

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @Override
    @Transactional
    public Lecture register(StudentRegistrationRequest lectureRegistrationRequest){
        if(!isRegistered(lectureRegistrationRequest)){
            UserProfile lectureRegistrationProfile = userProfileService.createUserProfile(convertToUserProfile(lectureRegistrationRequest));
            Lecture lecture = createNewLecture();
            Users login = userService.createUserLogin(lecture.getId(), UserType.LECTURE, lectureRegistrationProfile.getId(), lectureRegistrationProfile.getEmail());
            emailService.sendMessage(EmailType.REGISTRATION, UserType.LECTURE, lectureRegistrationProfile.getEmail(), login);
            return lecture;
        }
        return null;
    }

    @Override
    public TeachingScheduleResponse getTeachingSchedule(String lectureId) {
        List<CourseSelectionClass> lectureSchedule = krsService.getClassByLectureId(lectureId);
        TeachingScheduleResponse response = new TeachingScheduleResponse();
        for(CourseSelectionClass c : lectureSchedule) {
            TeachingScheduleResponse.Schedule schedule = new TeachingScheduleResponse.Schedule();
            schedule.setLectureId(c.getLectureId());
            schedule.setCourseName(c.getCourse(context).getCourseName());
            schedule.setTeachingDate(c.getSchedule().toString());
            response.addSchedule(schedule);
        }

        return response;
    }

    private boolean isRegistered(StudentRegistrationRequest lectureRegistrationRequest){
        UserProfile profile = userProfileService.isUserProfileExist(lectureRegistrationRequest.getEmail(), lectureRegistrationRequest.getIdentityCardNumber());
        if(Objects.isNull(profile)) return false;
        else return true;
    }

    private UserProfile convertToUserProfile(StudentRegistrationRequest request){
        UserProfile profile = new UserProfile();
        profile.setName(request.getName());
        profile.setAddress(request.getAddress());
        profile.setEmail(request.getEmail());
        profile.setAddress(request.getAddress());
        profile.setGender(request.getGender());
        profile.setIdentityCardNumber(request.getIdentityCardNumber());
        profile.setIdentityCardNumberType(request.getIdentityCardNumberType());
        return profile;
    }

    private Lecture createNewLecture(){
        Lecture lecture = new Lecture();
        lecture.setId(createLectureId());
        lecture.setStatus("PENDING");
        lecture = lectureDao.save(lecture);
        return lecture;

    }

    private String createLectureId(){
        String lectureId = prefixRegistration + getIncrementId();
        return lectureId;
    }

    private Long getIncrementId() {
        Query q = entityManager.createNativeQuery("select nextval('"+ registrationIdSeq +"')");
        return (Long) q.getSingleResult();
    }
}
