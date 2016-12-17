package com.simakad.service.registration;

import com.simakad.dao.constant.RegStaticFileType;
import com.simakad.dao.entity.RegStaticFile;

import java.io.File;
import java.io.InputStream;

/**
 * Created by SRIN on 10/22/2016.
 */
public interface RegistrationStaticFileService {
    RegStaticFile save(String baseUrl, InputStream streamData, RegStaticFileType regStaticFileType, String username, String extension) throws Exception;
}
