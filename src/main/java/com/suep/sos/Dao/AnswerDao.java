package com.suep.sos.Dao;

import com.suep.sos.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

@Transactional
public interface AnswerDao extends JpaRepository<Answer, Integer> {

    @Modifying
    void deleteAnswersBySurveyId(Long surveyId);
}
