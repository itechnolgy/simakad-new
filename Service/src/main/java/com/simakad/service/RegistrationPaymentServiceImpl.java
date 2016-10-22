package com.simakad.service;

import com.simakad.dao.constant.VerificationType;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.StudentRegistration;
import com.simakad.dao.repo.RegPaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by SRIN on 10/22/2016.
 */
@Component
public class RegistrationPaymentServiceImpl implements RegistrationPaymentService {
    @Autowired
    RegPaymentDao regPaymentDao;

    @Override
    public void createRegistrationPaymentData(NewStudent student) {
        RegPayment payment = new RegPayment();
        payment.setNewStudent(student);
        payment.setStatus(VerificationType.PENDING);
        regPaymentDao.save(payment);
    }
}
