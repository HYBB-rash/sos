package com.suep.sos;

import com.suep.sos.Entity.SimpleAnswer;
import com.suep.sos.Entity.Vue.RowData;
import com.suep.sos.Entity.Vue.VueAnalyze;
import com.suep.sos.Service.AnswerService;
import com.suep.sos.Service.Implementation.UserServiceImp;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SosApplicationTests {

    @Autowired
    UserServiceImp userService;
    @Autowired
    AnswerService answerService;

    @Test
    void contextLoads() {
        System.out.println(userService.get("admin", "123"));;
        System.out.println(answerService.getAnswerBySurveyId((long)25));
        VueAnalyze vueAnalyze = new VueAnalyze();
        ArrayList<Integer> demo = new ArrayList<>();
        demo.add(1); demo.add(2); demo.add(3); demo.add(4);
        vueAnalyze.setData(demo);
        System.out.println(vueAnalyze);
        vueAnalyze = new VueAnalyze();
        RowData d = new RowData();
        d.setName("demo");
        d.setValue(1234);
        List<RowData> list = new ArrayList<>();
        list.add(d);
        vueAnalyze.setData(list);
        System.out.println(vueAnalyze);
    }

    @Test
    void testAnsDao() {
        List<VueAnalyze> ans = answerService.getAnalyzeData((long) 25);
        System.out.println(ans);
    }

    @Test
    void testExcel() throws IOException {
        Workbook excel = new HSSFWorkbook();


        Sheet sheet1 = excel.createSheet("new sheet");
        Sheet sheet2 = excel.createSheet("new two sheet");
        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales?]");
        Sheet sheet3 = excel.createSheet(safeName);
        FileOutputStream fileOutputStream = new FileOutputStream("excelData/workbook.xls");
        excel.write(fileOutputStream);
        fileOutputStream.close();


    }

    @Test
    void testExcel1() throws IOException {
        Workbook wb = new HSSFWorkbook();
        CreationHelper creationHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        Row row = sheet.createRow((short)0);
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        row.createCell(1).setCellValue(10);
        row.createCell(2).setCellValue(creationHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);

        FileOutputStream fileOutputStream = new FileOutputStream("excelData/workbook3.xls");
        wb.write(fileOutputStream);

        fileOutputStream.close();
    }

    @Test
    void realTestExcel() throws IOException {
        Workbook wb = new HSSFWorkbook();
        CreationHelper creationHelper = wb.getCreationHelper();
        List<VueAnalyze> ans = answerService.getAnalyzeData((long) 25);
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
                        RowData rowData = (RowData) analyze.getData().get(i);
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
        FileOutputStream fileOutputStream = new FileOutputStream("excelData/workbook4.xls");
        wb.write(fileOutputStream);

        fileOutputStream.close();
    }

    @Test
    void testShare() {
        System.out.println("share is ok");
    }


}
