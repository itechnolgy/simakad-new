package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "transcript")
public class Transcript {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "student_id")
    private String studentId;

    @Basic
    @Column(name = "course_id")
    private String courseId;

    @Basic
    @Column(name = "semester_credit_number")
    private Integer semesterCreditNumber;

    @Basic
    @Column(name = "assignment_score")
    private Integer assignmentScore;

    @Basic
    @Column(name = "mid_exam_score")
    private Integer midExamScore;

    @Basic
    @Column(name = "final_exam_score")
    private Integer finalExamScore;

    @Basic
    @Column(name = "final_score")
    private Integer finalScore;

    @Basic
    @Column(name = "final_grade")
    private String finalGrade;

    @Column(name = "creation_time")
    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSemester() {
        return semesterCreditNumber;
    }

    public void setSemester(Integer semesterCreditNumber) {
        this.semesterCreditNumber = semesterCreditNumber;
    }

    public Integer getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(Integer assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public Integer getMidExamScore() {
        return midExamScore;
    }

    public void setMidExamScore(Integer midExamScore) {
        this.midExamScore = midExamScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getFinalExamScore() {
        return finalExamScore;
    }

    public void setFinalExamScore(Integer finalExamScore) {
        this.finalExamScore = finalExamScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
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
