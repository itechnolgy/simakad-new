package com.simakad.service;

import com.simakad.dao.constant.EmailType;
import com.simakad.dao.constant.UserType;

/**
 * Created by HighDream on 10/23/2016.
     */
public interface EmailService {
    void sendMessage(EmailType emailType, UserType userType, String recepient, Object messageObj);
}