package com.simakad.dao.repo;

import com.simakad.dao.dto.RegExamScheduleDto;
import com.simakad.dao.entity.RegExamSchedule;
import com.simakad.dao.entity.RegExamSchedulePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vikraa on 10/21/16.
 */
public interface RegExamScheduleDao extends JpaRepository<RegExamSchedule, RegExamSchedulePK> {
    @Query("select e from RegExamSchedule e where e.regExamSchedulePK.strataId = :strata and e.examYear = :examyear order by e.examDate")
    List<RegExamSchedule> findScheduleByStrata(@Param("strata") String strataId, @Param("examyear") String examYear);

}
