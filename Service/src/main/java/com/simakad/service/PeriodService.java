package com.simakad.service;

import com.simakad.dao.entity.Period;

import java.util.Date;
import java.util.List;

/**
 * Created by HighDream on 10/16/2016.
 */
public interface PeriodService {
    Period findPeriod(String year);
    List<Period> getAllPeriod();
    Period savePeriod(String year, Date startDate, Date endDate);
}
