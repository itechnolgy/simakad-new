package com.simakad.service;

import com.simakad.dao.dto.RegExamScheduleDto;

import java.util.Date;
import java.util.List;

/**
 * Created by vikra on 10/25/16.
 */
public interface RegExamScheduleService {
    List<RegExamScheduleDto> findExamSchedule(String strataId, String year);
    void addExam(String name, Date schedule, String year);

}
