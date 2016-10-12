package com.simakad.dao.entity;

import javax.persistence.*;
import java.util.Currency;

/**
 * Created by vikraa on 10/11/16.
 */
@Entity
@Table(name = "payment_registration_list")
public class PaymentListRegistration {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "payment_name")
    private String paymentName;

    @Basic(optional = false)
    @Column(name = "payment_year")
    private String paymentYear;

    @Basic(optional = false)
    @Column(name = "study_program_id")
    private boolean studyProgramId;

    @Basic(optional = false)
    @Column(name = "amount")
    private Currency amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentYear() {
        return paymentYear;
    }

    public void setPaymentYear(String paymentYear) {
        this.paymentYear = paymentYear;
    }

    public boolean isStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(boolean studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }
}
