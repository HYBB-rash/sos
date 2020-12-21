package com.suep.sos.Controller;

import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnalyzeController {

    @Autowired
    AnswerService answerService;

    @CrossOrigin
    @PostMapping(value = "/api/analyze")
    @ResponseBody
    public Result getAnalyze(@RequestBody PostId id) {
        return ResultFactory.buildSuccessResult(answerService.getAnalyzeData((long) id.getId()));
    }
}
