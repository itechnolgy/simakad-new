package com.simakad.dao.repo;

import com.simakad.dao.entity.PaymentListRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vikraa on 10/11/16.
 */
public interface PaymentListRegistrationDao extends JpaRepository<PaymentListRegistration, String> {
    List<PaymentListRegistration> findByYear(String year);
    void save(List<PaymentListRegistration> paymentList, String year);
    void save(PaymentListRegistration paymentItem, String year);
}
