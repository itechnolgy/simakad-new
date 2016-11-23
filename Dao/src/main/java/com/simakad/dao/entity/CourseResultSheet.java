package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 11/23/2016.
 */
@Entity
@Table(name = "course_result_sheet")
public class CourseResultSheet {
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
    @Column(name = "lecture_id")
    private String lectureId;

    @Basic
    @Column(name = "applied_semester")
    private Integer appliedSemester;

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

    @Basic
    @Column(name = "periode")
    private Boolean periode;

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

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public Integer getSemester() {
        return appliedSemester;
    }

    public void setSemester(Integer appliedSemester) {
        this.appliedSemester = appliedSemester;
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

    public Boolean getPeriode() {
        return periode;
    }

    public void setPeriode(Boolean periode) {
        this.periode = periode;
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
