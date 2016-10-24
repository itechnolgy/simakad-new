package com.simakad.service;

import com.simakad.dao.constant.EmailType;

/**
 * Created by HighDream on 10/23/2016.
 */
public interface EmailService {
    void sendMessage(EmailType emailType, String recepient, Object messageObj);
}
