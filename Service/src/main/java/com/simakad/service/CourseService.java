package com.simakad.service;

import com.simakad.dao.dto.CourseRequest;
import com.simakad.dao.entity.Course;

import java.util.List;

/**
 * Created by wendy on 12/12/16.
 */
public interface CourseService {
    Course addCourse(CourseRequest courseRequest);
    Course getCourseByCourseId(String courseId);
    List<Course> getCourseList();
    List<Course> getCourseListByDegree(long degreeId);
    List<Course> getCourseListBySemester(Integer semester);
    Course editCourse(CourseRequest courseRequest);
    Course deleteCourse(String courseId);
}
