package com.simakad.dao.repo;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 10/22/2016.
 */
public interface RegDocumentDao extends JpaRepository<RegDocument, Long> {
    RegDocument findByStudentIdAndType(String studentId, RegStaticFileType regStaticFileType);
    List<RegDocument> findByStudentId(String studentId);
}
