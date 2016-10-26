package com.simakad.dao.dto;

import java.sql.Timestamp;

/**
 * Created by vikra on 10/25/16.
 */
public class RegExamScheduleDto {
    private String examName;
    private String examStrataId;
    private Timestamp examDate;
    private String examYear;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamStrataId() {
        return examStrataId;
    }

    public void setExamStrataId(String examStrataId) {
        this.examStrataId = examStrataId;
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
