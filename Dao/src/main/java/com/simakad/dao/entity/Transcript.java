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
    private Long studentId;

    @Basic
    @Column(name = "course_id")
    private Long courseId;

    @Basic
    @Column(name = "semester_credit_number")
    private Integer semesterCreditNumber;

    @Basic
    @Column(name = "assignment_score")
    private Long assignmentScore;

    @Basic
    @Column(name = "mid_exam_score")
    private Long midExamScore;

    @Basic
    @Column(name = "final_exam_score")
    private Long finalExamScore;

    @Basic
    @Column(name = "final_score")
    private Long finalScore;

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

    public Long getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(Long assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public Long getMidExamScore() {
        return midExamScore;
    }

    public void setMidExamScore(Long midExamScore) {
        this.midExamScore = midExamScore;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getFinalExamScore() {
        return finalExamScore;
    }

    public void setFinalExamScore(Long finalExamScore) {
        this.finalExamScore = finalExamScore;
    }

    public Long getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Long finalScore) {
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
