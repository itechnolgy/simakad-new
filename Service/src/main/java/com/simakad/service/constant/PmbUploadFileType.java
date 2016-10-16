package com.simakad.service.constant;

/**
 * Created by HighDream on 10/16/2016.
 */
public enum PmbUploadFileType {
    PAYMENT("PAYMENT"),
    TOEFL("TOEFL");

    private String text;

    private PmbUploadFileType(String s) {
        text = s;
    }

    @Override
    public String toString() {
        return text;
    }
}
