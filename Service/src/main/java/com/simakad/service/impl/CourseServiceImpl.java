package com.simakad.service.impl;

import com.simakad.dao.dto.CourseRequest;
import com.simakad.dao.entity.Course;
import com.simakad.dao.repo.CourseDao;
import com.simakad.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendy on 12/12/16.
 */
@Component
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Course addCourse(CourseRequest courseRequest) {
        Course course = createNewCourse(courseRequest);
        return course;
    }

    @Override
    public List<Course> getCourseList() {
        List<Course> listCourse = courseDao.findAll();
        return listCourse;
    }

    @Override
    public Course getCourseByCourseId(String courseId) {
        Course course = courseDao.findById(courseId);
        return course;
    }

    @Override
    public List<Course> getCourseListByDegree(long degreeId) {
        return courseDao.findByDegreeId(degreeId);
    }

    @Override
    public List<Course> getCourseListBySemester(Integer semester) {
        return courseDao.findBySemester(semester);
    }

    @Override
    public Course editCourse(CourseRequest courseRequest) {
        return null;
    }

    @Override
    public Course deleteCourse(String courseId) {
        courseDao.delete(courseId);
        return null;
    }

    private Course createNewCourse(CourseRequest courseRequest){
        Course course = new Course();
        course.setId(courseRequest.getId());
        course.setCourseName(courseRequest.getCourseName());
        course.setDegreeId(courseRequest.getDegreeId());
        course.setSemester(courseRequest.getSemester());
        course.setSemesterCreditNumber(courseRequest.getSemesterCreditNumber());
        course = courseDao.save(course);
        return course;
    }


}
