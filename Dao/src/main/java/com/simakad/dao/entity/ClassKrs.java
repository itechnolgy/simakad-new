package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/11/2016.
 */
@Entity
@Table(name = "class_krs")
public class ClassKrs {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "schedule")
    private Timestamp schedule;

    @Basic
    @Column(name = "quota")
    private int quota;

    @Basic
    @Column(name = "creation_time")
    private Timestamp creationTime;

    @Basic
    @Column(name = "last_update_time")
    private Timestamp lastUpdateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getSchedule() {
        return schedule;
    }

    public void setSchedule(Timestamp schedule) {
        this.schedule = schedule;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
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
