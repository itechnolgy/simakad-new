package com.simakad.dao.repo;

import com.simakad.dao.entity.ExamSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 11/11/2016.
 */
public interface ExamScheduleDao extends JpaRepository<ExamSchedule, Long> {
}
