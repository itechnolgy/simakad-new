package com.simakad.service.registration;

import com.simakad.dao.constant.DegreeEnum;
import com.simakad.dao.constant.RegCalendarType;
import com.simakad.dao.entity.RegCalendar;

/**
 * Created by SRIN on 11/8/2016.
 */
public interface RegCalendarService {
    RegCalendar getParam(RegCalendarType regCalendarType, int degreeId);
}
