package com.simakad.dao.repo;

import com.simakad.dao.entity.RegExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 11/3/2016.
 */
public interface RegExamResultDao extends JpaRepository<RegExamResult, String> {
//    RegExamResult findByStudentId();
}
