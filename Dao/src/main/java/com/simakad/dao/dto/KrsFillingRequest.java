package com.simakad.dao.dto;

/**
 * Created by HighDream on 11/19/2016.
 */
public class KrsFillingRequest {
    private String studentId;
    private long krsScheduleId;

    public long getKrsScheduleId() {
        return krsScheduleId;
    }

    public void setKrsScheduleId(long krsScheduleId) {
        this.krsScheduleId = krsScheduleId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
