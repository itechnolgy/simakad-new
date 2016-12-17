package com.simakad.service.registration;

import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;

import java.util.List;

/**
 * Created by SRIN on 10/31/2016.
 */
public interface RegDocumentService {
//    RegDocument save(RegStaticFile regStaticFile);
    RegDocument createDocumentData(RegStaticFile regStaticFile);
    RegDocument updateDocumentData(RegStaticFile regStaticFile);
    RegDocument verifyDocument(long docId, String status);

    List<RegDocument> getDocumentByStudentId(String studentId);
    List<RegDocument> getAllDocument();
}

