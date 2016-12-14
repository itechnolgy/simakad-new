package com.simakad.dao.repo;

import com.simakad.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 11/15/2016.
 */
public interface CourseDao extends JpaRepository<Course, String> {
    Course findByCourseName(String courseName);
    Course findByDegreeId(long degreeId);
}
