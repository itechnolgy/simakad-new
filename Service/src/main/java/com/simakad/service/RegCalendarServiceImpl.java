package com.simakad.service;

import com.simakad.dao.constant.DegreeEnum;
import com.simakad.dao.constant.RegCalendarType;
import com.simakad.dao.entity.RegCalendar;
import com.simakad.dao.repo.RegCalendarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by SRIN on 11/8/2016.
 */
@Component
public class RegCalendarServiceImpl implements RegCalendarService {
    @Autowired
    RegCalendarDao regCalendarDao;

    @Override
    public RegCalendar getParam(RegCalendarType regCalendarType, int degreeId) {
        return regCalendarDao.findByParamAndDegreeId(regCalendarType, degreeId);
    }
}
