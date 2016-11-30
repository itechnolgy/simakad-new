package com.simakad.service;

import com.simakad.dao.dto.response.StudentScheduleResponse;
import com.simakad.dao.dto.response.StudentSemesterResultResponse;
import com.simakad.dao.entity.Course;
import com.simakad.dao.entity.CourseResultSheet;
import com.simakad.dao.entity.CourseSelectionClass;
import com.simakad.dao.entity.CourseSelectionSheet;
import com.simakad.dao.repo.CourseDao;
import com.simakad.dao.repo.CourseResultSheetDao;
import com.simakad.dao.repo.CourseSelectionSheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by SRIN on 11/28/2016.
 */
@Component
public class StudentServiceImpl implements StudentService {
    private HashMap<String, Course> courseHashMap = new HashMap<>();
    private HashMap<Long, CourseSelectionClass> courseSelectionClassHashMap = new HashMap<>();

    private ApplicationContext context;
    private CourseSelectionSheetDao courseSelectionSheetDao;
    private CourseResultSheetDao courseResultSheetDao;
    private CourseDao courseDao;

    @Autowired
    public StudentServiceImpl(ApplicationContext context, CourseSelectionSheetDao courseSelectionSheetDao, CourseResultSheetDao courseResultSheetDao) {
        this.context = context;
        this.courseSelectionSheetDao = courseSelectionSheetDao;
        this.courseResultSheetDao = courseResultSheetDao;
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
}
