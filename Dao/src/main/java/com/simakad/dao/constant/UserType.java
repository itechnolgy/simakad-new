package com.simakad.dao.constant;

/**
 * Created by SRIN on 10/11/2016.
 */
public enum UserType {
    STUDENT ("ROLE_STUDENT"),
    NEW_STUDENT ("ROLE_NEW_STUDENT"),
    LECTURE ("ROLE_LECTURE"),
    FINANCE ("ROLE_FINANCE"),
    ACADEMIC ("ROLE_ACADEMIC"),
    ROLE_ADMIN ("ROLE_ADMIN");

    private String text;

    private UserType(String s) {
        text = s;
    }

    @Override
    public String toString() {
        return text;
    }
}
