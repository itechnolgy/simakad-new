package com.simakad.dao.repo;

import com.simakad.dao.entity.PaymentListRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * Created by vikraa on 10/11/16.
 */
public interface PaymentListRegistrationDao extends JpaRepository<PaymentListRegistration, Integer> {

    @Query("SELECT P from PaymentListRegistration where P.year_date = :paramYear")
    Set<PaymentListRegistration> findPaymentYear(@Param("paramYear") String year);

    //@Query("delete p from PaymentListRegistration where p.id = ?:1 and p.year_date = ?:2")
    //void deletePaymentItemYear(int paymentId, String year);

//    void save(List<PaymentListRegistration> paymentList, String year);
//    void save(PaymentListRegistration paymentItem, String year);
}
