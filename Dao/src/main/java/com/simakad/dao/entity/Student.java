package com.simakad.dao.entity;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HighDream on 9/11/2016.
 */

@Entity
public class Student {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    String id;

    @Basic(optional = false)
    @Column(name = "creation_time")
    Timestamp creationTime;

    @Basic(optional = false)
    @Column(name = "last_update_time")
    Timestamp lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
