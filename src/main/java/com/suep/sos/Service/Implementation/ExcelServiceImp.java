package com.suep.sos.Service.Implementation;

import com.alibaba.fastjson.JSONObject;
import com.suep.sos.Entity.Vue.*;
import com.suep.sos.Service.AnswerService;
import com.suep.sos.Service.ExcelService;
import com.suep.sos.Service.SurveyService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ExcelServiceImp implements ExcelService {

    @Autowired
    AnswerService answerService;
    @Autowired
    SurveyService surveyService;

    @Override
    public String getExcelData(List<VueAnalyze> ans) throws IOException {
        Date date = new Date();
        String dataUrl = "excelData/" + date.getTime() + ".xls";

        Workbook wb = new HSSFWorkbook();
        CreationHelper creationHelper = wb.getCreationHelper();
        Sheet totalSheet = wb.createSheet("汇总");
        int cnt = 0;
        int rowCnt = 0;
        for (VueAnalyze analyze : ans) {
            Sheet sheet = wb.createSheet(analyze.getTitle() + (cnt ++));
            totalSheet.createRow(rowCnt ++).createCell(0).setCellValue(analyze.getTitle());
            switch (analyze.getType()) {
                case 0:
                    Row row1 = sheet.createRow(0);
                    Row totalRow1 = totalSheet.createRow(rowCnt ++);
                    for (int i = 0; i < analyze.getxData().size(); i ++){
                        row1.createCell(i).setCellValue(analyze.getxData().get(i));
                        totalRow1.createCell(i).setCellValue(analyze.getxData().get(i));
                    }
                    Row row2 = sheet.createRow(1);
                    Row totalRow2 = totalSheet.createRow(rowCnt ++);
                    for (int i = 0; i < analyze.getData().size(); i ++){
                        row2.createCell(i).setCellValue((Integer)analyze.getData().get(i));
                        totalRow2.createCell(i).setCellValue((Integer)analyze.getData().get(i));
                    }
                    break;
                case 1:
                    Row row3 = sheet.createRow(0);
                    Row totalRow3 = totalSheet.createRow(rowCnt ++);
                    Row row4 = sheet.createRow(1);
                    Row totalRow4 = totalSheet.createRow(rowCnt ++);
                    for (int i = 0; i < analyze.getData().size(); i ++) {
                        RowData rowData = ((JSONObject)analyze.getData().get(i)).toJavaObject(RowData.class);
                        row3.createCell(i).setCellValue(rowData.getName());
                        totalRow3.createCell(i).setCellValue(rowData.getName());
                        row4.createCell(i).setCellValue(rowData.getValue());
                        totalRow4.createCell(i).setCellValue(rowData.getValue());
                    }
                    break;
                case 2:
                    sheet.createRow(0).createCell(0).setCellValue("所有评价");
                    for (int i = 1; i <= analyze.getData().size(); i ++) {
                        totalSheet.createRow(rowCnt ++).createCell(0).setCellValue((String) analyze.getData().get(i - 1));
                        sheet.createRow(i + 1).createCell(0).setCellValue((String) analyze.getData().get(i - 1));
                    }
                    break;
                case 3:
                    Row row5 = sheet.createRow(0);
                    Row totalRow5 = totalSheet.createRow(rowCnt ++);
                    for (int i = 0; i < 6; i ++){
                        row5.createCell(i).setCellValue(i);
                        totalRow5.createCell(i).setCellValue(i);
                    }
                    Row row6 = sheet.createRow(1);
                    Row totalRow6 = totalSheet.createRow(rowCnt ++);
                    for (int i = 0; i < analyze.getData().size(); i ++){
                        row6.createCell(i).setCellValue((Integer)analyze.getData().get(i));
                        totalRow6.createCell(i).setCellValue((Integer)analyze.getData().get(i));
                    }
                    break;
            }

            rowCnt ++;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(dataUrl);
        wb.write(fileOutputStream);

        fileOutputStream.close();
        return dataUrl;
    }

    @Override
    public void loadExcelSurvey(VueSurvey survey) {

    }

    @Override
    public String getExcelSurvey(Long surveyID) throws IOException {
        VueSurvey survey = surveyService.getSurvey(surveyID);
        System.out.println(survey);
        Date date = new Date();
        String dataUrl = "excelData/" + date.getTime() + ".xls";

        Workbook wb = new HSSFWorkbook();
        CreationHelper creationHelper = wb.getCreationHelper();
        Sheet surveyExcel = wb.createSheet("问卷");

        Row title = surveyExcel.createRow(0);
        title.createCell(0).setCellValue(survey.getSurveyTitle());

        Row instruction = surveyExcel.createRow(1);
        instruction.createCell(0).setCellValue(survey.getInstruction());

        List<VueQuestion> vueQuestions = survey.getForms();
        for (int i = 0; i < vueQuestions.size(); i ++) {
            VueQuestion question = vueQuestions.get(i);
            Row q = surveyExcel.createRow(3 + i);
            q.createCell(0).setCellValue(question.getQuestion());

            String type = "";
            if (question.getType() == 0) type = "单选题";
            if (question.getType() == 1) type = "多选题";
            if (question.getType() == 2) type = "评价题";
            if (question.getType() == 3) type = "评分题";
            q.createCell(2).setCellValue(type);

            if (question.getType() == 0 || question.getType() == 1) {
                List<Choice> choices = question.getChoices();
                q.createCell(4).setCellValue(choices.size());
                for (int j = 0; j < choices.size(); j ++) {
                    q.createCell(6 + j).setCellValue(choices.get(j).getValue());
                }
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(dataUrl);
        wb.write(fileOutputStream);
        fileOutputStream.close();

        return dataUrl;
    }
}
