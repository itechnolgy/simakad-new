package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "course_name")
    private String courseName;

    @Basic
    @Column(name = "degree_id")
    private Long degreeId;

    @Basic
    @Column(name = "semester_credit_number")
    private Integer semesterCreditNumber;

    @Basic
    @Column(name = "semester")
    private Integer semester;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public Integer getSemesterCreditNumber() {
        return semesterCreditNumber;
    }

    public void setSemesterCreditNumber(Integer semesterCreditNumber) {
        this.semesterCreditNumber = semesterCreditNumber;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
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
