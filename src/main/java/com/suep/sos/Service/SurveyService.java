package com.suep.sos.Service;

import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Entity.Vue.VueSurvey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurveyService {

    List<SurveyInfo> getAllSurvey(Integer id);
    Boolean storeSurvey(VueSurvey survey);
    VueSurvey getSurvey(Long id);

    Boolean updateStopStatus(Long id);
}
