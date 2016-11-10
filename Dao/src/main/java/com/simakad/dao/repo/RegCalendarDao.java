package com.simakad.dao.repo;

import com.simakad.dao.constant.RegCalendarType;
import com.simakad.dao.entity.RegCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HighDream on 11/5/2016.
 */
public interface RegCalendarDao extends JpaRepository<RegCalendar, Long> {
    List<RegCalendar> findByParam(RegCalendarType param);
    RegCalendar findByParamAndDegreeId(RegCalendarType param, int degreeId);
}
