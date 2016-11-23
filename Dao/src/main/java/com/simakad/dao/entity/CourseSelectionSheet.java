package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

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
    private String studentId;

    @Basic
    @Column(name = "course_selection_class_id")
    private Long courseSelectionClassId;

    @Basic
    @Column(name = "applied_semester")
    private Integer appliedSemester;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Long getCourseSelectionClassId() {
        return courseSelectionClassId;
    }

    public void setCourseSelectionClassId(Long courseSelectionClass) {
        this.courseSelectionClassId = courseSelectionClassId;
    }

    public Integer getAppliedSemester() {
        return appliedSemester;
    }

    public void setAppliedSemester(Integer appliedSemester) {
        this.appliedSemester = appliedSemester;
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
