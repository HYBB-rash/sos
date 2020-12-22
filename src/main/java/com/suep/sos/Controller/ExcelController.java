package com.suep.sos.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suep.sos.Entity.Vue.VueAnalyze;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @CrossOrigin
    @PostMapping(value = "/api/excel")
    @ResponseBody
    public Result generateExcel(@RequestBody Object excelData) {
        System.out.println(excelData);
        JSONObject o = JSON.parseObject("excelData");
        System.out.println(o);
        List<VueAnalyze> excel = JSON.parseArray("excelData", VueAnalyze.class);
        System.out.println(excel);
        return ResultFactory.buildSuccessResult(excelData);
    }
}
