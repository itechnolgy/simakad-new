package com.simakad.service.impl;

import com.simakad.dao.dto.KrsFillingRequest;
import com.simakad.dao.dto.KrsScheduleRequest;
import com.simakad.dao.entity.CourseResultSheet;
import com.simakad.dao.entity.CourseSelectionClass;
import com.simakad.dao.entity.CourseSelectionSheet;
import com.simakad.dao.repo.CourseResultSheetDao;
import com.simakad.dao.repo.CourseSelectionClassDao;
import com.simakad.dao.repo.CourseSelectionSheetDao;
import com.simakad.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HighDream on 11/19/2016.
 */
@Component
public class KrsServiceImpl implements KrsService {
    @Autowired
    ApplicationContext context;

    @Autowired
    CourseSelectionClassDao courseSelectionClassDao;

    @Autowired
    CourseSelectionSheetDao courseSelectionSheetDao;

    @Autowired
    CourseResultSheetDao courseResultSheetDao;

    @Autowired
    EntityManager entityManager;

    @Override
    public void addKrsSchedule(KrsScheduleRequest krsScheduleRequest) {
        CourseSelectionClass krsSchedule = new CourseSelectionClass();
        krsSchedule.setCourseId(krsSchedule.getCourseId());
        krsSchedule.setDegreeId(krsSchedule.getDegreeId());
        krsSchedule.setLectureId(krsSchedule.getLectureId());
        krsSchedule.setQuota(krsSchedule.getQuota());

        courseSelectionClassDao.save(krsSchedule);
    }

    @Override
    public void fillKrs(KrsFillingRequest krsFillingRequest) {
        if(isQuotaAvailable(krsFillingRequest.getKrsScheduleId())) {
            CourseSelectionSheet krs = new CourseSelectionSheet();
            krs.setCourseSelectionClassId(krsFillingRequest.getKrsScheduleId());
            krs.setStudentId(krsFillingRequest.getStudentId());
            krs.setAppliedSemester(krsFillingRequest.getAppliedSemester());
            krs.setCreationTime(new Date());
            krs.setLastUpdateTime(new Date());

            courseSelectionSheetDao.save(krs);
        }
    }

    @Override
    public void addKrsPeriod() {

    }

    @Override
    public void startKrsPeriod() {
        clearKrsSelection();

    }

    @Override
    public void closeKrsPeriod() {
        moveKrsToCourseResultSheet();
    }

    private void clearKrsSelection() {
        Query query = entityManager.createNativeQuery("DELETE FROM course_selection_sheet");
        query.executeUpdate();
    }

    private void closeResultSheetStatusPeriod() {

    }

    private void moveKrsToCourseResultSheet() {
        List<CourseSelectionSheet> courseSelectionSheets = courseSelectionSheetDao.findAll();
        HashMap<Long, CourseSelectionClass> classDetail = new HashMap<>();

        for(CourseSelectionSheet choosenKrs : courseSelectionSheets) {
            CourseResultSheet ksm = new CourseResultSheet();
            if(classDetail.get(choosenKrs.getCourseSelectionClassId()) == null) {
                CourseSelectionClass courseSelectionClass = choosenKrs.getCourseSelectionClass(context);
                classDetail.put(courseSelectionClass.getId(), courseSelectionClass);
            }
            ksm.setCourseId(classDetail.get(choosenKrs.getCourseSelectionClassId()).getCourseId());
            ksm.setStudentId(ksm.getStudentId());
            ksm.setLectureId(classDetail.get(choosenKrs.getCourseSelectionClassId()).getLectureId());

            courseResultSheetDao.save(ksm);
        }
    }

    private boolean isQuotaAvailable(Long krsScheduleId) {
        CourseSelectionClass krsClass = courseSelectionClassDao.findOne(krsScheduleId);

        Query query = entityManager.createNativeQuery("SELECT count(id) FROM course_selection_sheet WHERE course_selection_class_id =" + krsScheduleId);
        int usedQuota = (int)query.getSingleResult();

        return (krsClass.getQuota() > usedQuota) ? true : false;
    }

    @Override
    public List<CourseSelectionClass> getClassByLectureId(String lectureId) {
        return courseSelectionClassDao.findByLectureId(lectureId);
    }
}
