package com.simakad.service.registration;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;

import java.util.List;

/**
 * Created by SRIN on 10/31/2016.
 */
public interface RegPaymentService {
    // Business Logic
    RegPayment createRegistrationPaymentData(RegStaticFile regStaticFile, NewStudent newStudent);
    RegPayment updateRegistrationPaymentData(RegStaticFile regStaticFile);

    RegPayment updatePaymentStatus(long paymentId, String status);

    // CRUD to Database
    RegPayment getPaymentByStudentIdAndType(String studentId, RegStaticFileType regStaticFileType);
    List<RegPayment> getPaymentByStudentId(String studentId);
    List<RegPayment> getAllPayment();

}
