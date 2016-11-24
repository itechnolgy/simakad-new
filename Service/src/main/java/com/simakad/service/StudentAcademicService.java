package com.simakad.service;

import com.simakad.dao.constant.ScoreType;

/**
 * Created by SRIN on 11/23/2016.
 */
public interface StudentAcademicService {
    void editStudentScore(String studentId, String courseId, ScoreType scoreType, int score);
}
