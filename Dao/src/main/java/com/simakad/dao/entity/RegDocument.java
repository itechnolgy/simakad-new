package com.simakad.dao.entity;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.constant.VerificationType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SRIN on 10/22/2016.
 */
@Entity
@Table(name = "reg_document")
public class RegDocument {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "reg_document_id_seq", sequenceName = "reg_document_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_document_id_seq")
    private Long id;

//    @JoinColumn(name = "student_registration_id", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private NewStudent newStudent;
    @Basic(optional = false)
    @Column(name = "student_registration_id")
    private String studentId;

    @Transient
    private NewStudent newStudent;

    @OneToOne
    @JoinColumn(name = "reg_static_file_id")
    private RegStaticFile staticFile;

    @Basic(optional = false)
    @Column(name = "reason")
    private String reason;

    @Basic(optional = false)
    @Column(name = "status")
    private VerificationType status;

    @Basic(optional = false)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RegStaticFileType type;

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

    public NewStudent getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    public RegStaticFile getStaticFile() {
        return staticFile;
    }

    public void setStaticFile(RegStaticFile staticFile) {
        this.staticFile = staticFile;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public VerificationType getStatus() {
        return status;
    }

    public void setStatus(VerificationType status) {
        this.status = status;
    }


    public RegStaticFileType getType() {
        return type;
    }

    public void setType(RegStaticFileType type) {
        this.type = type;
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
