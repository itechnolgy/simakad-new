package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by SRIN on 11/11/2016.
 */

@Entity
@Table(name = "transcript")
public class Transcript {
    @Id
    @Column(name = "id")
    private Long id;

}
