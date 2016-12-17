package com.simakad.service.impl;

import com.simakad.dao.entity.Period;
import com.simakad.dao.repo.PeriodDao;
import com.simakad.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by HighDream on 10/16/2016.
 */
@Component
public class PeriodServiceImpl implements PeriodService {
    @Autowired
    PeriodDao periodDao;

    @Override
    public Period findPeriod(String year) {
        Period period = periodDao.findOne(year);
        return period;
    }

    @Override
    public List<Period> getAllPeriod() {
        return periodDao.findAll();
    }

    @Override
    public Period savePeriod(String year, Date startDate, Date endDate) {
        Period period = new Period();
        period.setAcademicYear(year);
        period.setStartDate(startDate);
        period.setEndDate(endDate);

        period = periodDao.save(period);
        return period;
    }
}
