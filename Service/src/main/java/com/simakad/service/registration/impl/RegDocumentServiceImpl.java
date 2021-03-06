package com.simakad.service.registration.impl;

import com.simakad.dao.constant.VerificationType;
import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.dao.repo.RegDocumentDao;
import com.simakad.service.registration.RegDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by SRIN on 10/31/2016.
 */

@Component
public class RegDocumentServiceImpl implements RegDocumentService {
    @Autowired
    RegDocumentDao regDocumentDao;

    @Override
    public RegDocument createDocumentData(RegStaticFile regStaticFile) {
        RegDocument document = new RegDocument();
        document.setStudentId(regStaticFile.getNewStudent().getId());
        document.setStaticFile(regStaticFile);
        document.setType(regStaticFile.getType());
        document.setStatus(VerificationType.PENDING);
        document = regDocumentDao.save(document);
        return document;
    }

    @Override
    public RegDocument updateDocumentData(RegStaticFile regStaticFile) {

        RegDocument document = regDocumentDao.findByStudentIdAndType(regStaticFile.getNewStudent().getId(), regStaticFile.getType());
        if(Objects.isNull(document)) {
            createDocumentData(regStaticFile);
        } else {
            document.setStatus(VerificationType.PENDING);
            document.setStaticFile(regStaticFile);
            document = regDocumentDao.save(document);
        }

        return document;
    }

    @Override
    public List<RegDocument> getDocumentByStudentId(String studentId) {
        List<RegDocument> document = regDocumentDao.findByStudentId(studentId);
        return document;
    }

    @Override
    public List<RegDocument> getAllDocument() {
        return regDocumentDao.findAll();
    }

    @Override
    public RegDocument verifyDocument(long docId, String status) {
        RegDocument document = regDocumentDao.findOne(docId);
        document.setStatus(verificationTypeConverter(status));
        document.setLastUpdateTime(new Date());
        document = regDocumentDao.save(document);
        return document;
    }

    private VerificationType verificationTypeConverter(String status) {
        switch (status) {
            case "ACCEPTED" :
                return VerificationType.ACCEPTED;
            case "REJECTED" :
                return VerificationType.REJECTED;
            default:
                return VerificationType.PENDING;
        }
    }
}
