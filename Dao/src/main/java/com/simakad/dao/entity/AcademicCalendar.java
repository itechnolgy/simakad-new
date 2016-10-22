package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by SRIN on 10/13/2016.
 */
@Entity
@Table(name = "academic_calendar")
public class AcademicCalendar {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(name = "academic_calendar_id_seq", sequenceName = "academic_calendar_id_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_calendar_id_seq")
    private Long id;


}
