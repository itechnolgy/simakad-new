package com.simakad.dao.entity;

import com.simakad.dao.constant.RegStaticFileType;

import javax.persistence.*;

/**
 * Created by SRIN on 10/20/2016.
 */
@Entity
@Table(name = "reg_static_file")
public class RegStaticFile {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "reg_static_file_id_seq", sequenceName = "reg_static_file_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_static_file_id_seq")
    private Long id;

    @JoinColumn(name = "student_registration_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NewStudent newStudent;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RegStaticFileType type;

    @Basic(optional = false)
    @Column(name = "refId")
    private Long refId;

    @Basic(optional = false)
    @Column(name = "reason")
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NewStudent getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegStaticFileType getType() {
        return type;
    }

    public void setType(RegStaticFileType type) {
        this.type = type;
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
