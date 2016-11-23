package com.simakad.dao.entity;

import com.simakad.dao.repo.CourseDao;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by SRIN on 11/15/2016.
 */
@Entity
@Table(name = "course_selection_class")
public class CourseSelectionClass {
    @Transient
    CourseDao courseDao;

    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "course_id")
    private String courseId;

    @Basic
    @Column(name = "schedule")
    @Temporal(TemporalType.DATE)
    private Date schedule;

    @Basic
    @Column(name = "quota")
    private Integer quota;

    @Basic
    @Column(name = "lecture_id")
    private String lectureId;

    @Basic
    @Column(name = "degree_id")
    private Long degreeId;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;

    @Transient
    private Course course;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
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

    public Course getCourse(ApplicationContext applicationContext) {
        if(Objects.isNull(course)) {
            if(Objects.isNull(courseDao)) courseDao = applicationContext.getBean(CourseDao.class);
            course = courseDao.findOne(this.courseId);
        }

        return course;
    }
}
