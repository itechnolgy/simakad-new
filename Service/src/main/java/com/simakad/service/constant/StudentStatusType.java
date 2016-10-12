package com.simakad.service.constant;

/**
 * Created by SRIN on 10/11/2016.
 */
public enum StudentStatusType {
    ACTIVE ("ACTIVE"),
    NOT_ACTIVE ("NOT_ACTIVE");

    private String text;

    private StudentStatusType(String s) {
        text = s;
    }

    @Override
    public String toString() {
        return text;
    }
}
