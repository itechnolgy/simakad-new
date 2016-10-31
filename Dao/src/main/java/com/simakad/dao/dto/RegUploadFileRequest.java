package com.simakad.dao.dto;

import javax.validation.constraints.NotNull;
import java.io.File;

/**
 * Created by SRIN on 10/31/2016.
 */
public class RegUploadFileRequest {
    @NotNull
    private String type;
    @NotNull
    private String document;
//    @NotNull
//    private File file;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }
}
