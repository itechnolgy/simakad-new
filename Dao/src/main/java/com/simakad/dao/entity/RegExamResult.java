package com.simakad.dao.entity;

import com.simakad.dao.constant.RegExamResultType;
import com.simakad.dao.constant.RegStaticFileType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 11/3/2016.
 */

@Entity
@Table(name = "reg_exam_result")
public class RegExamResult {
    @Id
    @Basic(optional = false)
    @Column(name = "student_registration_id")
    private String studentId;

    @Transient
    private NewStudent newStudent;

    @Basic(optional = false)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RegExamResultType status;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public NewStudent getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    public RegExamResultType getStatus() {
        return status;
    }

    public void setStatus(RegExamResultType status) {
        this.status = status;
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
