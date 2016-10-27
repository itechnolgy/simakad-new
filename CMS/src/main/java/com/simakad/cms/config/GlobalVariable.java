package com.simakad.cms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by SRIN on 10/27/2016.
 */
@Component
public class GlobalVariable {

    @Value("${upload.newStudentFile.baseUrl}")
    private String uploadBaseUrlNewStudent;

    @Value("${upload.file.baseUrl}")
    private String uploadBaseUrl;

    public String getUploadBaseUrlNewStudent() {
        return uploadBaseUrlNewStudent;
    }

    public void setUploadBaseUrlNewStudent(String uploadBaseUrlNewStudent) {
        this.uploadBaseUrlNewStudent = uploadBaseUrlNewStudent;
    }

    public String getUploadBaseUrl() {
        return uploadBaseUrl;
    }

    public void setUploadBaseUrl(String uploadBaseUrl) {
        this.uploadBaseUrl = uploadBaseUrl;
    }
}
