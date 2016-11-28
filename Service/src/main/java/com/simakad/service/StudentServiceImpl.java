package com.simakad.service;

import com.simakad.dao.dto.response.StudentScheduleResponse;
import com.simakad.dao.entity.Course;
import com.simakad.dao.entity.CourseSelectionClass;
import com.simakad.dao.entity.CourseSelectionSheet;
import com.simakad.dao.repo.CourseSelectionSheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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

    @Autowired
    ApplicationContext context;

    @Autowired
    CourseSelectionSheetDao courseSelectionSheetDao;

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

            Course course = courseHashMap.get(selectionClass.getCourseId());
            if(Objects.isNull(course)) {
                course = selectionClass.getCourse(context);
                courseHashMap.put(course.getId(), course);
            }
            response.addCourseDetail(course.getCourseName(), selectionClass.getSchedule().toString());
        }

        return response;
    }


}
