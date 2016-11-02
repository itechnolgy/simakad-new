package com.simakad.service.util;

import com.simakad.dao.entity.RegStaticFile;
import com.simakad.dao.repo.RegStaticFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.UUID;

/**
 * Created by SRIN on 10/27/2016.
 */
@Component
public class StorageUtil {
    private static final int SUBDIR_RANDOM_SIZE = 9999;
    private static final int SUBDIR_DEPTH = 2;

    @Autowired
    RegStaticFileDao regStaticFileDao;

    public File createStaticFile(File baseUrl, InputStream inputStream, boolean isPayment, String extension) throws Exception{
        File randomFolder = createRandomSubDirectory();
        String fileName = generateFileName(extension);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        File dstFile = null;
        if(isPayment) {
            dstFile = new File(baseUrl, randomFolder.getPath());
        }

        if (!dstFile.exists()) {
            if (!dstFile.mkdirs()) {
//                LOG.warn("createRandomSubDirectory mkdirs result failed for subDirectory:[{}]", fileDirComplete);
            }
        }
        dstFile = new File(dstFile, fileName);
        OutputStream outputStream = new FileOutputStream(dstFile);
        outputStream.write(buffer);

        return new File(randomFolder, fileName);
    }


    private File createRandomSubDirectory() {
        Random r = new Random();

        File file = new File(String.valueOf(r.nextInt(SUBDIR_RANDOM_SIZE)));
        for(int i = 1 ; i <= SUBDIR_DEPTH ; i++) {
            file = new File(file, String.valueOf(r.nextInt(SUBDIR_RANDOM_SIZE)));
        }
        return file;
    }

    private String generateFileName(String extension) {
        return UUID.randomUUID().toString() + extensionConverter(extension);
    }

    private String extensionConverter(String contentType) {
        switch (contentType) {
            case "image/jpeg" :
                return ".png";
            case "application/vnd.ms-excel" :
                return ".xls";
            case "application/msword" :
                return ".doc";
            case "application/pdf" :
                return ".pdf";
        }
        return null;
    }

}
