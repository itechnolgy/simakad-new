package com.simakad.service;

import com.simakad.dao.dto.KrsFillingRequest;
import com.simakad.dao.dto.KrsScheduleRequest;
import com.simakad.dao.entity.CourseSelectionClass;

import java.util.List;

/**
 * Created by HighDream on 11/19/2016.
 */
public interface KrsService {
    void addKrsSchedule(KrsScheduleRequest krsScheduleRequest);

    void fillKrs(KrsFillingRequest krsFillingRequest);

    List<CourseSelectionClass> getClassByLectureId(String lectureId);
}
