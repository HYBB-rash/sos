package com.suep.sos.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Entity.Vue.VueSurvey;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.AnswerService;
import com.suep.sos.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnswerController {

    @Autowired
    SurveyService surveyService;
    @Autowired
    AnswerService answerService;

    @CrossOrigin
    @PostMapping(value = "/api/ans")
    @ResponseBody
    public Result getAnswerPage(@RequestBody PostId id) {
        VueSurvey survey = surveyService.getSurvey((long)id.getId());
        return ResultFactory.buildSuccessResult(survey);
    }

    @CrossOrigin
    @PostMapping(value = "/api/submit")
    @ResponseBody
    public Result storeAnswer(@RequestBody Object answer) {
        JSONObject jb = JSON.parseObject(answer.toString()).getJSONObject("ans");
        VueSurvey tmp = JSON.parseObject(jb.toJSONString(), VueSurvey.class);
//        System.out.println(tmp);
        answerService.saveAnswer(tmp);
        return ResultFactory.buildSuccessResult(null);
    }

    @CrossOrigin
    @PostMapping(value = "/api/answer/clear")
    @ResponseBody
    public Result clearAnswer(@RequestBody PostId id) {
        try {
            answerService.clearAnswer((long)id.getId());
            return ResultFactory.buildSuccessResult("success");
        } catch (Exception e) {
            return ResultFactory.buildFailResult("clearError");
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/answer/status")
    @ResponseBody
    public Result getSurveyStatus(@RequestBody PostId id) {
        try {
            Integer status = surveyService.getStatus((long) id.getId());
            return ResultFactory.buildSuccessResult(status);
        } catch (Exception e) {
            return ResultFactory.buildFailResult("find error");
        }
    }
}
