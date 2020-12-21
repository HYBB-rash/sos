package com.suep.sos.Dao;

import com.suep.sos.Entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailDao extends JpaRepository<Detail, Integer> {

    // get
    List<Detail> findBySurveyId(Long surveyId);
    Detail findById(Long id);
    Detail findByIdAndSurveyId(Long id, Long surveyId);
    // to
}
