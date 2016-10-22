package com.simakad.dao.constant;

/**
 * Created by SRIN on 10/7/2016.
 */
public enum UsersProfileType {
    STUDENT ("STUDENT"),
    NEW_STUDENT ("NEW_STUDENT"),
    TEACHER ("TEACHER"),
    FINANCE ("FINANCE"),
    ACADEMIC ("ACADEMIC");

    private String text;

    private UsersProfileType(String s) {
        text = s;
    }

    @Override
    public String toString() {
        return text;
    }
}
