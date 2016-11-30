package com.simakad.dao.repo;

import com.simakad.dao.entity.CourseResultSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 11/23/2016.
 */
public interface CourseResultSheetDao extends JpaRepository<CourseResultSheet, Long> {
    CourseResultSheet findByStudentIdAndCourseIdAndPeriode(String studentId, String courseId, Boolean periode);

    List<CourseResultSheet> findByStudentIdAndAppliedSemester(String studentId, int appliedSemester);
}
