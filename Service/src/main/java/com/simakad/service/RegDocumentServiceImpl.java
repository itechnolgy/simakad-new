package com.simakad.service;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.constant.VerificationType;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegPayment;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.dao.repo.RegDocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        document.setStudentId(regStaticFile.getStudentId());
        document.setStaticFile(regStaticFile);
        document.setType(regStaticFile.getType());
        document = regDocumentDao.save(document);
        return document;
    }

    @Override
    public RegDocument updateDocumentData(RegStaticFile regStaticFile) {

        RegDocument document = regDocumentDao.findByStudentIdAndType(regStaticFile.getStudentId(), regStaticFile.getType());
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
}
