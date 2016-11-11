package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/11/2016.
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
    @Column(name = "study_program_id")
    private long studyProgramId;

    @Transient
    private Degree degree;

    @Basic
    @Column(name = "degree_id")
    private long degree_id;

    @Basic
    @Column(name = "sks")
    private Integer sks;

    @Basic
    @Column(name = "semester")
    private Integer semester;

    @Basic
    @Column(name = "creation_time")
    private Timestamp creationTime;

    @Basic
    @Column(name = "last_update_time")
    private Timestamp lastUpdateTime;

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

    public long getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(long studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public long getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(long degree_id) {
        this.degree_id = degree_id;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
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
