package com.suep.sos.Dao;

import com.suep.sos.Entity.SimpleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleAnswerDao extends JpaRepository<SimpleAnswer, Integer> {

    List<SimpleAnswer> findAllBySurveyId(Long surveyId);
}
