package com.simakad.service;

import com.simakad.dao.constant.RegExamResultType;
import com.simakad.dao.dto.RegExamScheduleResponse;
import com.simakad.dao.entity.RegExamResult;
import com.simakad.dao.entity.RegExamSchedule;
import com.simakad.dao.repo.RegExamResultDao;
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
public class RegExamServiceImpl implements RegExamService {

    @Autowired
    private RegExamScheduleDao regExamScheduleDao;

    @Autowired
    private RegExamResultDao regExamResultDao;

    @Override
    public List<RegExamScheduleResponse> findExamSchedule(Long strataId) {
        List<RegExamSchedule> examScheduleList =  regExamScheduleDao.findByDegreeId(strataId);
        List<RegExamScheduleResponse> listSchedule = new ArrayList<>();
        for (RegExamSchedule s : examScheduleList) {
            RegExamScheduleResponse examDto = new RegExamScheduleResponse();
            examDto.setExamName(s.getName());
            examDto.setDegreeId(s.getDegreeId());
            examDto.setExamDate(s.getDate());
            listSchedule.add(examDto);
        }
        return listSchedule;
    }

    @Override
    public void addExam(String name, Date schedule, String year) {

    }

    @Override
    public void putDefaultExamResult(String studentId) {
        RegExamResult regExamResult = new RegExamResult();
        regExamResult.setStudentId(studentId);
        regExamResult.setStatus(RegExamResultType.PENDING);
        regExamResult.setCreationTime(new Date());
        regExamResult.setLastUpdateTime(new Date());
        regExamResultDao.save(regExamResult);
    }

    @Override
    public RegExamResult updateExamResult(String studentId, RegExamResultType regExamResultType) {
        RegExamResult regExamResult = regExamResultDao.findOne(studentId);
        regExamResult.setLastUpdateTime(new Date());
        regExamResult.setStatus(regExamResultType);
        regExamResult = regExamResultDao.save(regExamResult);
        return regExamResult;
    }

    @Override
    public RegExamResult findExamResult(String studentId) {
        return regExamResultDao.findOne(studentId);
    }
}
