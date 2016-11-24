package com.simakad.service;

import com.simakad.dao.constant.ScoreType;
import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.dto.response.TeachingScheduleResponse;
import com.simakad.dao.entity.Lecture;

/**
 * Created by wendy on 11/21/16.
 */
public interface LectureRegistrationService {
    Lecture register(StudentRegistrationRequest lectureRegistrationRequest);

    TeachingScheduleResponse getTeachingSchedule(String lectureId);

    void insertScore(String studentId, String courseId, ScoreType scoreType, int score);
}
