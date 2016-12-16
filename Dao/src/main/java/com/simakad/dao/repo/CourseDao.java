package com.simakad.dao.repo;

import com.simakad.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 11/15/2016.
 */
public interface CourseDao extends JpaRepository<Course, String> {
    List<Course> findByDegreeId(long degreeId);
    List<Course> findBySemester(Integer semester);
}
