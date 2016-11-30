package com.simakad.service;

import com.simakad.dao.dto.response.StudentScheduleResponse;
import com.simakad.dao.dto.response.StudentSemesterResultResponse;

/**
 * Created by SRIN on 11/28/2016.
 */
public interface StudentService {
    public StudentScheduleResponse showSchedule(String studentId);
    public StudentSemesterResultResponse showSemesterResult(String studentId, int semester);
}
