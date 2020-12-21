package com.suep.sos.Service;

import com.suep.sos.Entity.SimpleAnswer;
import com.suep.sos.Entity.Vue.VueAnalyze;
import com.suep.sos.Entity.Vue.VueSurvey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {

    public Boolean saveAnswer(VueSurvey answer);
    public List<SimpleAnswer> getAnswerBySurveyId(Long surveyId);
    public List<VueAnalyze> getAnalyzeData(Long surveyId);
}
