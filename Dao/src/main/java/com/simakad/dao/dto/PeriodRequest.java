package com.simakad.dao.dto;

import java.util.Date;

/**
 * Created by HighDream on 10/16/2016.
 */
public class PeriodRequest {
    private String year;
    private Date startDate;
    private Date endDate;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
