package com.suep.sos.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.Implementation.SurveyServiceImp;
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

    @CrossOrigin
    @PostMapping(value = "/api/important")
    @ResponseBody
    public Result changeToImportant(@RequestBody PostId id) {
        System.out.println(id.getId());
        surveyService.setStatus((long)id.getId(), SurveyServiceImp.Important);
        return ResultFactory.buildSuccessResult(id);
    }

    @CrossOrigin
    @PostMapping(value = "/api/unimportant")
    @ResponseBody
    public Result changToUnimportant(@RequestBody PostId id) {
        System.out.println(id.getId());
        surveyService.setStatus((long)id.getId(), SurveyServiceImp.New);
        return ResultFactory.buildSuccessResult(id);
    }

    @CrossOrigin
    @PostMapping(value = "/api/trash")
    @ResponseBody
    public Result changToTrash(@RequestBody PostId id) {
        System.out.println(id.getId());
        surveyService.setStatus((long) id.getId(), SurveyServiceImp.Trash);
        return ResultFactory.buildSuccessResult(id);
    }

    @CrossOrigin
    @PostMapping(value = "/api/surveyList")
    @ResponseBody
    public Result getSurveyInfoBySelect(@RequestBody Object rec) {
        System.out.println(rec.toString());
        JSONObject jo = JSON.parseObject(rec.toString());
        Integer id = (Integer) jo.get("id");
        Integer status = (Integer) jo.get("key");
        List<SurveyInfo> surveys;
        if (status == -1)  surveys = surveyService.getAllSurvey(id);
        else surveys = surveyService.getAllSurveyByStatus(id, status);
        return ResultFactory.buildSuccessResult(surveys);
    }

    @CrossOrigin
    @PostMapping(value = "/api/send")
    @ResponseBody
    public Result changeToSend(@RequestBody PostId id) {
        System.out.println(id.getId());
        surveyService.setStatus((long) id.getId(), SurveyServiceImp.Send);
        return ResultFactory.buildSuccessResult(id);
    }
}
