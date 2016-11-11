package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/11/2016.
 */
@Entity
@Table(name = "krs")
public class Krs {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "applied_semester")
    private Timestamp appliedSemester;

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

    public Timestamp getAppliedSemester() {
        return appliedSemester;
    }

    public void setAppliedSemester(Timestamp appliedSemester) {
        this.appliedSemester = appliedSemester;
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
