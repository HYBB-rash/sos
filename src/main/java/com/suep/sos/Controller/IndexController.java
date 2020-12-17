package com.suep.sos.Controller;

import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    SurveyService surveyService;

    @CrossOrigin
    @PostMapping(value = "/api/survey")
    @ResponseBody
    public Result getSurveyInfo(@RequestBody PostId id) {
        List<SurveyInfo> surveys = surveyService.getAllSurvey(id.getId());
        return ResultFactory.buildSuccessResult(surveys);
    }

    @CrossOrigin
    @PostMapping(value = "/api/stop")
    @ResponseBody
    public Result stopSurvey(@RequestBody PostId id) {
        System.out.println(id.getId());
        Boolean res = surveyService.updateStopStatus((long)id.getId());
        return res ? ResultFactory.buildSuccessResult(res) : ResultFactory.buildFailResult("refresh fail");
    }
}
