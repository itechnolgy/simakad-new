package com.simakad.service;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.constant.VerificationType;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.dao.repo.RegPaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Created by SRIN on 10/31/2016.
 */
@Component
public class RegPaymentServiceImpl implements RegPaymentService {
    @Autowired
    RegPaymentDao regPaymentDao;

//    @Override
//    public RegPayment save(RegStaticFile regStaticFile) {
//        RegPayment regPayment = new RegPayment();
//        regPayment.setStatus(VerificationType.PENDING);
//        regPayment.setType(regStaticFile.getType());
//        regPayment.setStudentId(regStaticFile.getStudentId());
//        regPayment.setStaticFile(regStaticFile);
//
//        regPayment = regPaymentDao.save(regPayment);
//        return regPayment;
//    }

    @Override
    public RegPayment createRegistrationPaymentData(NewStudent student) {
        RegPayment payment = new RegPayment();
        payment.setStudentId(student.getId());
        payment.setType(RegStaticFileType.BIAYA_PENDAFTARAN);
        payment = regPaymentDao.save(payment);
        return payment;
    }

    @Override
    public RegPayment updateRegistrationPaymentData(RegStaticFile regStaticFile) {

        RegPayment regPayment = regPaymentDao.findByStudentIdAndType(regStaticFile.getStudentId(), regStaticFile.getType());
        if(Objects.isNull(regPayment)) {
            NewStudent newStudent = new NewStudent();
            newStudent.setId(regStaticFile.getStudentId());
            regPayment = createRegistrationPaymentData(newStudent);
        } else {
            regPayment.setStatus(VerificationType.PENDING);
            regPayment.setStaticFile(regStaticFile);
            regPayment = regPaymentDao.save(regPayment);
        }

        return regPayment;
    }

    @Override
    public List<RegPayment> getPaymentByStudentId(String studentId) {
        return regPaymentDao.findByStudentId(studentId);
    }
}
