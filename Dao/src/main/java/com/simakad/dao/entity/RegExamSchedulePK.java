package com.simakad.dao.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by vikraa on 10/21/16.
 */
@Embeddable
public class RegExamSchedulePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "exam_name", nullable = false)
    private String examName;

    @Basic(optional = false)
    @Column(name = "strata_id", nullable = false)
    private String strataId;

    public RegExamSchedulePK() {
    }

    public RegExamSchedulePK(String examName, String strataId) {
        this.examName = examName;
        this.strataId = strataId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getStrataId() {
        return strataId;
    }

    public void setStrataId(String strataId) {
        this.strataId = strataId;
    }
}
