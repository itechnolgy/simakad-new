package com.simakad.dao.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 11/28/2016.
 */
public class StudentScheduleResponse {
    private List<CourseDetail> courseDetailList;

    public StudentScheduleResponse() {
        this.courseDetailList = new ArrayList<>();
    }

    public void addCourseDetail(String courseName, String schedule) {
        CourseDetail courseDetail = new CourseDetail();
        courseDetail.courseName = courseName;
        courseDetail.schedule = schedule;
        courseDetailList.add(courseDetail);
    }

    public class CourseDetail {
        public String courseName;
        public String schedule;
    }

}
