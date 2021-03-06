package com.simakad.dao.dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by vikra on 10/25/16.
 */
public class RegExamScheduleResponse {
    private String examName;
    private long degreeId;
    private Date examDate;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(long examStrataId) {
        this.degreeId = degreeId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

}
