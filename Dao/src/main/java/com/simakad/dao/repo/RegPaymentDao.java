package com.simakad.dao.repo;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.entity.RegPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 10/22/2016.
 */
public interface RegPaymentDao extends JpaRepository<RegPayment, Long> {
    List<RegPayment> findByStudentId(String studentId);
    RegPayment findByStudentIdAndType(String studentId, RegStaticFileType regStaticFileType);
}
