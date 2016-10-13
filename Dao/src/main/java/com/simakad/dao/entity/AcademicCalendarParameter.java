package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by SRIN on 10/13/2016.
 */
@Entity
@Table(name = "academic_calendar_param")
public class AcademicCalendarParameter {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "param_name")
    private String paramName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
