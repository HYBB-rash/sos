package com.suep.sos.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.suep.sos.Entity.Vue.PostId;
import com.suep.sos.Entity.Vue.VueAnalyze;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.ExcelService;
import org.apache.http.HttpResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @CrossOrigin
    @PostMapping(value = "/api/excel")
    @ResponseBody
    public void generateExcel(@RequestBody Object excelData, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(excelData);
        JSONArray o = JSON.parseObject(excelData.toString()).getJSONArray("excelData");
        System.out.println(o);
        List<VueAnalyze> excel = JSON.parseArray(o.toString(), VueAnalyze.class);
//        List<VueAnalyze> excel = JSON.parseArray("excelData", VueAnalyze.class);
//        System.out.println(excel);


        String url = excelService.getExcelData(excel);
        InputStream inp = new FileInputStream(url);
        Workbook workbook = WorkbookFactory.create(inp);
        try {
            url = URLEncoder.encode(url, "utf-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + url);
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            OutputStream osOut = response.getOutputStream();
            workbook.write(osOut);
            osOut.flush();
            osOut.close();
            workbook.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
//        return ResultFactory.buildSuccessResult(url);
    }

    @CrossOrigin
    @PostMapping(value = "/api/excel/survey")
    @ResponseBody
    public void getSurveyExcel (@RequestBody PostId postId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(postId.getId());
        String url = excelService.getExcelSurvey((long) postId.getId());
        InputStream inputStream = new FileInputStream(url);
        Workbook workbook = WorkbookFactory.create(inputStream);
        try {
            url = URLEncoder.encode(url, "utf-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+url);
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
