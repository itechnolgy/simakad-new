package com.simakad.dao.entity;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.constant.VerificationType;

import javax.persistence.*;

/**
 * Created by SRIN on 10/22/2016.
 */
@Entity
@Table(name = "reg_payment")
public class RegPayment {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "reg_payment_id_seq", sequenceName = "reg_payment_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_payment_id_seq")
    private Long id;

    @JoinColumn(name = "student_registration_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NewStudent newStudent;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private RegStaticFile staticFile;

    @Basic(optional = false)
    @Column(name = "reason")
    private String reason;

    @Basic(optional = false)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private VerificationType status;

    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;

    @Basic(optional = false)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RegStaticFileType type;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public RegStaticFileType getType() {
        return type;
    }

    public void setType(RegStaticFileType type) {
        this.type = type;
    }
}
