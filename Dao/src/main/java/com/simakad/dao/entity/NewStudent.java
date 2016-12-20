package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by SRIN on 9/20/2016.
 */
@Entity
@Table(name = "student_registration")
public class NewStudent {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    String id;

    @Basic(optional = false)
    @Column(name = "status")
    String status;

    @Basic(optional = false)
    @Column(name = "degree_id")
    Long degreeId;

//    @Basic(optional = false)
//    @Column(name = "student_id")
//    String studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }
}
