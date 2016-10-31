package com.simakad.service;

import com.simakad.dao.entity.RegDocument;
import com.simakad.dao.entity.RegStaticFile;

/**
 * Created by SRIN on 10/31/2016.
 */
public interface RegDocumentService {
//    RegDocument save(RegStaticFile regStaticFile);
    RegDocument createDocumentData(RegStaticFile regStaticFile);
    RegDocument updateDocumentData(RegStaticFile regStaticFile);

}

