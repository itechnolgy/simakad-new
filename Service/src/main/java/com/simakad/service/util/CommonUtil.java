package com.simakad.service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by SRIN on 10/7/2016.
 */
public class CommonUtil {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String passwordEncoder(String pass) {
        return encoder.encode(pass);
    }
}
