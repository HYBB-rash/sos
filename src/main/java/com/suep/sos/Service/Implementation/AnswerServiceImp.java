package com.suep.sos.Service.Implementation;

import com.alibaba.fastjson.JSON;
import com.suep.sos.Dao.AnswerDao;
import com.suep.sos.Dao.SurveyDao;
import com.suep.sos.Entity.Answer;
import com.suep.sos.Entity.Vue.VueQuestion;
import com.suep.sos.Entity.Vue.VueSurvey;
import com.suep.sos.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {

    @Autowired
    AnswerDao answerDao;
    @Autowired
    SurveyDao surveyDao;

    private List<Answer> loadAnswer(VueSurvey answer) {
        List<Answer> answers = new LinkedList<>();
        Long surveyId = answer.getId();
        for (VueQuestion question : answer.getForms()) {
            Answer ans = new Answer();
            ans.setId(null);
            ans.setSurveyId(surveyId);
            ans.setDetailId(question.getId());
            String text = "";
            if (question.getType() == 0)
                text = JSON.toJSONString(question.getAns());
            else if (question.getType() == 1)
                text = JSON.toJSONString(question.getMulti());
            else if (question.getType() == 2)
                text = JSON.toJSONString(question.getContext());
            else if (question.getType() == 3)
                text = JSON.toJSONString(question.getRate());
            ans.setAns(text);
            answers.add(ans);
        }
        return answers;
    }

    @Override
    public Boolean saveAnswer(VueSurvey answer) {
        List<Answer> answers = loadAnswer(answer);
        answerDao.saveAll(answers);
        Long surveyId = answer.getId();
        Integer res = surveyDao.updateCount(surveyId);
        System.out.println(res);
        return res == 1;
    }
}
