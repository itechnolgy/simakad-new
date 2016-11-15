package com.simakad.dao.repo;

import com.simakad.dao.entity.CourseSelectionClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 11/15/2016.
 */
public interface CourseSelectionSheetDao extends JpaRepository<CourseSelectionClass, Long> {
}
