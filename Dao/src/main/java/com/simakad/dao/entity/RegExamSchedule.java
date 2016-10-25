package com.simakad.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by vikraa on 10/21/16.
 */
@Entity
@Table(name="reg_exam_schedule")
public class RegExamSchedule implements Serializable{
    @EmbeddedId
    protected RegExamSchedulePK regExamSchedulePK;

    @Basic(optional = false)
    @Column(name = "exam_date")
    private Timestamp examDate;

    @Basic(optional = false)
    @Column(name = "exam_year")
    private String examYear;

    public RegExamSchedule() {
    }

    public RegExamSchedule(RegExamSchedulePK regExamSchedulePK, Timestamp examDate) {
        this.regExamSchedulePK = regExamSchedulePK;
        this.examDate = examDate;
    }

    public RegExamSchedulePK getRegExamSchedulePK() {
        return regExamSchedulePK;
    }

    public void setRegExamSchedulePK(RegExamSchedulePK regExamSchedulePK) {
        this.regExamSchedulePK = regExamSchedulePK;
    }

    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
    }

    public String getExamYear() {
        return examYear;
    }

    public void setExamYear(String examYear) {
        this.examYear = examYear;
    }
}
