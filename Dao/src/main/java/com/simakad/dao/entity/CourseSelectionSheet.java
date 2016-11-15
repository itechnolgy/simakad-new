package com.simakad.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "course_selection_sheet")
public class CourseSelectionSheet {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "student_id")
    private Long studentId;

    @Basic
    @Column(name = "course_selection_class")
    private Long courseSelectionClass;

    @Basic
    @Column(name = "applied_semester")
    private Integer appliedSemester;

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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseSelectionClass() {
        return courseSelectionClass;
    }

    public void setCourseSelectionClass(Long courseSelectionClass) {
        this.courseSelectionClass = courseSelectionClass;
    }

    public Integer getAppliedSemester() {
        return appliedSemester;
    }

    public void setAppliedSemester(Integer appliedSemester) {
        this.appliedSemester = appliedSemester;
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
