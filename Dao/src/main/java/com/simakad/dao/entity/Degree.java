package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by SRIN on 10/13/2016.
 */
@Entity
@Table(name = "degree")
public class Degree {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "degree_id_seq", sequenceName = "degree_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "degree_id_seq")
    private Long id;

    @Basic(optional = false)
    @Column(name = "degree_name")
    private String degreeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
