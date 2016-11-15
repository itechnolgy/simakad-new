package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "course_name")
    private String courseName;

    @Basic
    @Column(name = "degree_id")
    private Integer degreeId;

    @Basic
    @Column(name = "semester_credit_number")
    private Integer semesterCreditNumber;

    @Basic
    @Column(name = "semester")
    private Integer semester;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
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
