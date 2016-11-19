package com.simakad.service;

import com.simakad.dao.dto.KrsFillingRequest;
import com.simakad.dao.dto.KrsScheduleRequest;

/**
 * Created by HighDream on 11/19/2016.
 */
public interface KrsService {
    void addKrsSchedule(KrsScheduleRequest krsScheduleRequest);

    void fillKrs(KrsFillingRequest krsFillingRequest);
}
