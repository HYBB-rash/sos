package com.suep.sos.Dao;

import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyCount;
import com.suep.sos.Entity.SurveyEditBase;
import com.suep.sos.Entity.SurveyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SurveyDao extends JpaRepository<Survey, Integer> {

    List<SurveyInfo> findByUserIdAndStatusNot(int userId, int status);
    List<SurveyInfo> findByUserIdAndStatus(int userId, int status);
    SurveyEditBase findById(Long id);
    Survey getSurveyById(Long id);

    @Modifying
    @Query(value = "update Survey set status = ?1 where id = ?2")
    Integer updateStatus(Integer status, Long id);

    @Modifying
    @Query(value = "update Survey s set s.count = s.count + 1 where s.id = ?1")
    Integer updateCount(Long id);

    SurveyCount getById(Long id);
}
