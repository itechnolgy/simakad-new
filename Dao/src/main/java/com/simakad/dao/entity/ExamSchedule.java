package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "exam_schedule", schema = "public", catalog = "simakadtest")
public class ExamSchedule {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "course_id")
    private Long courseId;

    @Basic
    @Column(name = "schedule_start_time")
    private Timestamp scheduleStartTime;

    @Basic
    @Column(name = "schedule_end_time")
    private Timestamp scheduleEndTime;

    @Basic
    @Column(name = "degree_id")
    private Integer degreeId;

    @Basic
    @Column(name = "creation_time")
    private Timestamp creationTime;

    @Basic
    @Column(name = "last_update_time")
    private Timestamp lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public Timestamp getScheduleStartTime() {
        return scheduleStartTime;
    }

    public void setScheduleStartTime(Timestamp scheduleStartTime) {
        this.scheduleStartTime = scheduleStartTime;
    }

    public Timestamp getScheduleEndTime() {
        return scheduleEndTime;
    }

    public void setScheduleEndTime(Timestamp scheduleEndTime) {
        this.scheduleEndTime = scheduleEndTime;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
