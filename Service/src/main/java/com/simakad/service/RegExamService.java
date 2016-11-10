package com.simakad.service;

import com.simakad.dao.constant.RegExamResultType;
import com.simakad.dao.dto.RegExamScheduleResponse;
import com.simakad.dao.entity.RegExamResult;

import java.util.Date;
import java.util.List;

/**
 * Created by vikra on 10/25/16.
 */
public interface RegExamService {
    List<RegExamScheduleResponse> findExamSchedule(Long strataId);
    void addExam(String name, Date schedule, long degreeId, String year);

    void putDefaultExamResult(String studentId);

    RegExamResult updateExamResult(String studentId, String status);

    List<RegExamResult> getAllExamResult();

    RegExamResult findExamResult(String studentId);
}
