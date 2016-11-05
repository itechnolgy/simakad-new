package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HighDream on 11/5/2016.
 */
@Entity
@Table(name = "reg_calendar")
public class RegCalendar {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "reg_calendar_id_seq", sequenceName = "reg_calendar_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_calendar_id_seq")
    private Long id;

    @Basic(optional = false)
    @Column(name = "param")
    private String param;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Basic(optional = false)
    @Column(name = "degree_id")
    private Long degreeId;

    @Basic(optional = false)
    @Column(name = "period")
    private String period;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
