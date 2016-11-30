package com.simakad.dao.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 11/30/2016.
 */
public class StudentSemesterResultResponse {
    private List<Result> resultList;
    private int totalSks;
    private double ips;

    public StudentSemesterResultResponse() {
        resultList = new ArrayList<>();
        totalSks = 0;
        ips = 0;
    }

    public void addResult(String courseName, int assignmentScore, int midExamScore, int finalExamScore, int finalScore, String letterScore) {
        Result result = new Result();
        result.courseName = courseName;
        result.assignmentScore = assignmentScore;
        result.midExamScore = midExamScore;
        result.finalExamScore = finalExamScore;
        result.finalScore = finalScore;
        result.letterScore = letterScore;
    }

    public class Result {
        public String courseName;
        public int assignmentScore;
        public int midExamScore;
        public int finalExamScore;
        public int finalScore;
        public String letterScore;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public int getTotalSks() {
        return totalSks;
    }

    public void setTotalSks(int totalSks) {
        this.totalSks = totalSks;
    }

    public double getIps() {
        return ips;
    }

    public void setIps(double ips) {
        this.ips = ips;
    }
}
