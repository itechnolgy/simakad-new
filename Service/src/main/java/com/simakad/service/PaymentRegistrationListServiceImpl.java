package com.simakad.service;

import com.simakad.dao.entity.PaymentListRegistration;
import com.simakad.dao.repo.PaymentListRegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikraa on 10/11/16.
 */
public class PaymentRegistrationListServiceImpl extends PaymentRegistrationListService {

    @Autowired
    PaymentListRegistrationDao paymentListRegistrationDao;

    List<PaymentListRegistration> getPaymentList(String year) {
        return paymentListRegistrationDao.findByPaymentYear(year);
    }


}
