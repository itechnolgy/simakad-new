package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 10/13/2016.
 */
@Entity
@Table(name = "academic_calendar")
public class AcademicCalendar {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "academic_calendar_id_seq", sequenceName = "academic_calendar_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_calendar_id_seq")
    private Long id;

    @JoinColumn(name = "period_year", referencedColumnName = "academic_year")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Period period;

    @Basic(optional = false)
    @Column(name = "academic_type")
    private String academicType;

    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Degree degree;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getAcademicType() {
        return academicType;
    }

    public void setAcademicType(String academicType) {
        this.academicType = academicType;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
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
}
