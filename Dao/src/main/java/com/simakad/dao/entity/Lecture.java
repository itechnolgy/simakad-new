package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @Column(name = "id")
    private String id;

    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Basic
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
