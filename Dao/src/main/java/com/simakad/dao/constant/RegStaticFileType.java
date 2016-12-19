package com.simakad.dao.constant;

/**
 * Created by SRIN on 10/22/2016.
 */
public enum RegStaticFileType {
    BIAYA_PENDAFTARAN ("PENDAFTARAN"),
    BIAYA_UANG_MASUK ("UANG MASUK"),
    TOEFL ("TOEFL"),
    IJAZAH ("IJAZAH"),
    RAPOR ("RAPOR");

    private String text;

    private RegStaticFileType (String s) {
        text = s;
    }

    @Override
    public String toString() {
        return text;
    }
}
