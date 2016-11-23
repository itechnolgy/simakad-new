package com.simakad.dao.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by HighDream on 9/11/2016.
 */

@Entity
public class Student {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;

    @Column(name = "creation_time")
    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
