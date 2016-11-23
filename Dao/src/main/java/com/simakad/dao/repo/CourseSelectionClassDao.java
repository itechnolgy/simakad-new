package com.simakad.dao.repo;

import com.simakad.dao.entity.CourseSelectionClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 11/15/2016.
 */
public interface CourseSelectionClassDao extends JpaRepository<CourseSelectionClass, Long> {
    List<CourseSelectionClass> findByLectureId(String lectureId);
}
