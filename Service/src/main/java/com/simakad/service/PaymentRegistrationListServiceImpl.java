package com.simakad.service;

import com.simakad.dao.entity.PaymentListRegistration;
import com.simakad.dao.repo.PaymentListRegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vikraa on 10/11/16.
 */
public class PaymentRegistrationListServiceImpl implements PaymentRegistrationListService {

    @Autowired
    PaymentListRegistrationDao paymentListRegistrationDao;

    @Override
    public Set<PaymentListRegistration> getPaymentList(String year) {
        return paymentListRegistrationDao.findPaymentYear(year);
    }

    @Override
    public void addPaymentList(List<PaymentListRegistration> registrationList, String year) {
        Set<PaymentListRegistration> setPayments = new HashSet<>();
        for (PaymentListRegistration p : registrationList) {
            p.setPaymentYear(year);
            setPayments.add(p);
        }
        paymentListRegistrationDao.save(setPayments);
    }

    @Override
    public void updatePaymentList(List<PaymentListRegistration> registrationList, String year) {
        Set<PaymentListRegistration> setPayments = paymentListRegistrationDao.findPaymentYear(year);
        if (setPayments != null && !setPayments.isEmpty()) {
            for (PaymentListRegistration p : setPayments) {
                PaymentListRegistration item = paymentListRegistrationDao.findOne(p.getId());
            }
        }
    }




}
