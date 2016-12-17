package com.simakad.service.registration.impl;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.entity.RegStaticFile;
import com.simakad.dao.repo.RegStaticFileDao;
import com.simakad.service.registration.RegistrationStaticFileService;
import com.simakad.service.util.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by SRIN on 10/22/2016.
 */
@Component
public class RegistrationStaticFileServiceImpl implements RegistrationStaticFileService {
    @Autowired
    StorageUtil storageUtil;

    @Autowired
    RegStaticFileDao regStaticFileDao;


    @Override
    public RegStaticFile save(String baseUrl, InputStream streamData, RegStaticFileType regStaticFileType, String studentId, String extension) throws Exception{
        File savedFile;
        RegStaticFile regStaticFile;
        if(isPaymentFile(regStaticFileType)) {
            savedFile = storageUtil.createStaticFile(new File(baseUrl), streamData, true, extension);
            regStaticFile = saveToDb(savedFile, studentId, regStaticFileType, true);
        } else {
            savedFile = storageUtil.createStaticFile(new File(baseUrl), streamData, false, extension);
            regStaticFile = saveToDb(savedFile, studentId, regStaticFileType, false);
        }

        return regStaticFile;
    }

    private boolean isPaymentFile(RegStaticFileType regStaticFileType) {
        if(regStaticFileType == RegStaticFileType.BIAYA_PENDAFTARAN || regStaticFileType == RegStaticFileType.BIAYA_UANG_MASUK) {
            return true;
        }
        return false;
    }

    private RegStaticFile saveToDb (File savedFile, String studentId, RegStaticFileType regStaticFileType, boolean isPayment) {
        RegStaticFile regStaticFile = new RegStaticFile();
        regStaticFile.setName(savedFile.getPath());
        regStaticFile.setType(regStaticFileType);
        regStaticFile.setStudentId(studentId);
        regStaticFile.setCreationTime(new Date());
        regStaticFile.setLastUpdateTime(new Date());

        regStaticFile = regStaticFileDao.save(regStaticFile);
        return regStaticFile;
    }
}
