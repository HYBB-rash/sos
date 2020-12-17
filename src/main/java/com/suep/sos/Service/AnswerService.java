package com.suep.sos.Service;

import com.suep.sos.Entity.Vue.VueSurvey;
import org.springframework.stereotype.Service;

@Service
public interface AnswerService {

    public Boolean saveAnswer(VueSurvey answer);
}
