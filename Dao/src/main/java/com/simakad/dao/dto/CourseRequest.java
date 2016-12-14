package com.simakad.dao.dto;

/**
 * Created by wendy on 12/12/16.
 */
public class CourseRequest {

    private String courseId;
    private String courseName;
    private long degreeId;
    private Integer semesterCreditNumber;
    private Integer semester;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(long degreeId) {
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
}
