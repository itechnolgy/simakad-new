package com.simakad.dao.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 11/22/2016.
 */
public class TeachingScheduleResponse {
    List<Schedule> scheduleList = new ArrayList<>();

    public void addSchedule(Schedule schedule) {
        scheduleList.add(schedule);
    }

    public static class Schedule {
        private String lectureId;
        private String courseName;
        private String teachingDate;

        public String getLectureId() {
            return lectureId;
        }

        public void setLectureId(String lectureId) {
            this.lectureId = lectureId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getTeachingDate() {
            return teachingDate;
        }

        public void setTeachingDate(String teachingDate) {
            this.teachingDate = teachingDate;
        }
    }

}
