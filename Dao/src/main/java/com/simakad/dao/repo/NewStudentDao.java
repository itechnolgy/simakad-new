package com.simakad.dao.repo;

import com.simakad.dao.entity.NewStudent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 9/20/2016.
 */
public interface NewStudentDao extends JpaRepository<NewStudent, String> {

}
