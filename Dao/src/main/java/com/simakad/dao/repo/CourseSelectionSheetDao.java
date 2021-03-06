package com.simakad.dao.repo;

import com.simakad.dao.entity.CourseSelectionClass;
import com.simakad.dao.entity.CourseSelectionSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 11/15/2016.
 */
public interface CourseSelectionSheetDao extends JpaRepository<CourseSelectionSheet, Long> {
    List<CourseSelectionSheet> getByStudentId(String studentId);
}
