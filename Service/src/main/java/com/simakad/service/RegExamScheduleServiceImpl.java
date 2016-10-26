package com.simakad.service;

import com.simakad.dao.dto.RegExamScheduleDto;
import com.simakad.dao.entity.RegExamSchedule;
import com.simakad.dao.repo.RegExamScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vikra on 10/25/16.
 */
@Component
public class RegExamScheduleServiceImpl implements RegExamScheduleService {

    @Autowired
    private RegExamScheduleDao regExamScheduleDao;

    @Override
    public List<RegExamScheduleDto> findExamSchedule(String strataId, String year) {
        List<RegExamSchedule> examScheduleList =  regExamScheduleDao.findScheduleByStrata(strataId, year);
        List<RegExamScheduleDto> listSchedule = new ArrayList<>();
        for (RegExamSchedule s : examScheduleList) {
            RegExamScheduleDto examDto = new RegExamScheduleDto();
            examDto.setExamName(s.getRegExamSchedulePK().getExamName());
            examDto.setExamStrataId(s.getRegExamSchedulePK().getStrataId());
            examDto.setExamYear(s.getExamYear());
            examDto.setExamDate(s.getExamDate());
            listSchedule.add(examDto);
        }
        return listSchedule;
    }

    @Override
    public void addExam(String name, Date schedule, String year) {

    }
}
