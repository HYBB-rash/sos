package com.suep.sos.Controller;

import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Entity.Vue.VueSurvey;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EditController {

    @Autowired
    SurveyService surveyService;

    @CrossOrigin
    @PostMapping(value = "/api/edit")
    @ResponseBody
    public Result editPage(@RequestBody PostId surveyId) {
        VueSurvey survey = surveyService.getSurvey((long)surveyId.getId());
        System.out.println(survey);
        return ResultFactory.buildSuccessResult(survey);
    }
}
