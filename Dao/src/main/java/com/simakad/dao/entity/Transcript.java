package com.simakad.dao.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

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
    @Column(name = "lecture_id")
    private Long lectureId;

    @Basic
    @Column(name = "semester")
    private Integer semester;

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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
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

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
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
