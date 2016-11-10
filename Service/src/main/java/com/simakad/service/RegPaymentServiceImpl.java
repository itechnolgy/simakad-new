package com.simakad.service;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.constant.VerificationType;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.dao.repo.RegPaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by SRIN on 10/31/2016.
 */
@Component
public class RegPaymentServiceImpl implements RegPaymentService {
    @Autowired
    RegPaymentDao regPaymentDao;

    @Override
    public RegPayment createRegistrationPaymentData(RegStaticFile regStaticFile, NewStudent student) {
        RegPayment payment = new RegPayment();
        payment.setStudentId(student.getId());
        payment.setStaticFile(regStaticFile);
        payment.setType(regStaticFile.getType());
        payment.setCreationTime(new Date());
        payment.setLastUpdateTime(new Date());
        payment.setStatus(VerificationType.PENDING);
        payment = regPaymentDao.save(payment);
        return payment;
    }

    @Override
    public RegPayment updateRegistrationPaymentData(RegStaticFile regStaticFile) {

        RegPayment regPayment = regPaymentDao.findByStudentIdAndType(regStaticFile.getStudentId(), regStaticFile.getType());
        if(Objects.isNull(regPayment)) {
            NewStudent newStudent = new NewStudent();
            newStudent.setId(regStaticFile.getStudentId());
            regPayment = createRegistrationPaymentData(regStaticFile, newStudent);
        } else {
            regPayment.setStatus(VerificationType.PENDING);
            regPayment.setStaticFile(regStaticFile);
            regPayment.setLastUpdateTime(new Date());
            regPayment = regPaymentDao.save(regPayment);
        }

        return regPayment;
    }

    @Override
    public RegPayment updatePaymentStatus(long paymentId, String status) {
        RegPayment regPayment = regPaymentDao.findOne(paymentId);
        if(Objects.isNull(regPayment)) {
            throw new RuntimeException("Unusual behaviour this will be reported");
        }
        regPayment.setStatus(verificationTypeConverter(status));
        regPayment.setLastUpdateTime(new Date());
        regPayment = regPaymentDao.save(regPayment);
        return regPayment;
    }


    @Override
    public List<RegPayment> getPaymentByStudentId(String studentId) {
        return regPaymentDao.findByStudentId(studentId);
    }

    @Override
    public List<RegPayment> getAllPayment() {
        return regPaymentDao.findAll();
    }

    private VerificationType verificationTypeConverter(String status) {
        switch (status) {
            case "ACCEPTED" :
                return VerificationType.ACCEPTED;
            case "REJECTED" :
                return VerificationType.REJECTED;
            default:
                return VerificationType.PENDING;
        }
    }
}
