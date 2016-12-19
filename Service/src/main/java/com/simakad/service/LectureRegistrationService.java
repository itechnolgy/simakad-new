package com.simakad.service;

import com.simakad.dao.constant.ScoreType;
import com.simakad.dao.dto.LectureRequest;
import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.dto.response.LectureResponse;
import com.simakad.dao.dto.response.TeachingScheduleResponse;
import com.simakad.dao.entity.Lecture;

import java.util.List;

/**
 * Created by wendy on 11/21/16.
 */
public interface LectureRegistrationService {
    Lecture register(LectureRequest lectureRequest);
    LectureResponse getLectureList();

    TeachingScheduleResponse getTeachingSchedule(String lectureId);

    void insertScore(String studentId, String courseId, ScoreType scoreType, int score);
}
