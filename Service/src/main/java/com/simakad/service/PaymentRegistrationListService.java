package com.simakad.service;

import com.simakad.dao.entity.PaymentListRegistration;

import java.util.List;
import java.util.Set;

/**
 * Created by vikraa on 10/11/16.
 */
public interface PaymentRegistrationListService {
    Set<PaymentListRegistration> getPaymentList(String year);
    void addPaymentList(List<PaymentListRegistration> registrationList, String year);
    void updatePaymentList(List<PaymentListRegistration> registrationList, String year);
}
