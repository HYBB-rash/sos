package com.suep.sos.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class CreateController {

    @Autowired
    SurveyService surveyService;

    @CrossOrigin
    @PostMapping(value = "/api/create")
    @ResponseBody
    public Result createNewSurvey(@RequestBody Object survey) {
        System.out.println(survey);
        JSONObject jb = JSON.parseObject(survey.toString()).getJSONObject("survey");
        VueSurvey tmp = JSON.parseObject(jb.toJSONString(), VueSurvey.class);
        System.out.println(tmp.toString());
        try {
            Boolean result = surveyService.storeSurvey(tmp);
            return ResultFactory.buildSuccessResult(result);
        } catch (Exception e) {
            return ResultFactory.buildFailResult("fail");
        }
    }
}
