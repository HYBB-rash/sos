package com.suep.sos.Service;

import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Entity.Vue.VueSurvey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurveyService {

    List<SurveyInfo> getAllSurvey(Integer id);
    List<SurveyInfo> getAllSurveyByStatus(Integer id, Integer status);
    Boolean storeSurvey(VueSurvey survey);
    VueSurvey getSurvey(Long id);

    Boolean updateStopStatus(Long id);
    Boolean setStatus(Long surveyId, int status);

    Integer getStatus(Long surveyId);
}
