package com.simakad.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by vikraa on 10/21/16.
 */
@Entity
@Table(name="reg_exam_schedule")
public class RegExamSchedule implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "reg_exam_schedule_id_seq", sequenceName = "reg_exam_schedule_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_exam_schedule_id_seq")
    private Long id;

    @Basic(optional = false)
    @Column(name = "exam_name")
    private String name;

    @Basic(optional = false)
    @Column(name = "exam_strata_id")
    private String degreeId;

    @Basic(optional = false)
    @Column(name = "exam_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(String degreeId) {
        this.degreeId = degreeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
