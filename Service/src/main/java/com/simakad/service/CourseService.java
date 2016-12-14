package com.simakad.service;

import com.simakad.dao.dto.CourseRequest;
import com.simakad.dao.entity.Course;

import java.util.List;

/**
 * Created by wendy on 12/12/16.
 */
public interface CourseService {
    Course addCourse(CourseRequest courseRequest);

    List<Course> getCourseList();
}
