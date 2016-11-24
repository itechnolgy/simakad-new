package com.simakad.dao.repo;

import com.simakad.dao.entity.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 11/15/2016.
 */
public interface TranscriptDao extends JpaRepository<Transcript, Long> {
    Transcript findByStudentIdAndCourseId(String studentId, String courseId);
}
