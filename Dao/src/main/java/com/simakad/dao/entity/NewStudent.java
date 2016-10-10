package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by SRIN on 9/20/2016.
 */
@Entity
@Table(name = "new_student")
public class NewStudent {
    @Basic(optional = false)
    @Column(name = "id")
    String id;

    @Basic(optional = false)
    @Column(name = "status")
    String status;

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
}
