package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/11/2016.
 */
@Entity
@Table(name = "exam_schedule")
public class ExamSchedule {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "schedule_start_time")
    private Timestamp scheduleStartTime;

    @Basic
    @Column(name = "schedule_end_time")
    private Timestamp scheduleEndTime;

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
