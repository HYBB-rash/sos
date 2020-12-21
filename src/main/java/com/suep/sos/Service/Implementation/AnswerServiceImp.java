package com.suep.sos.Service.Implementation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suep.sos.Dao.AnswerDao;
import com.suep.sos.Dao.DetailDao;
import com.suep.sos.Dao.SimpleAnswerDao;
import com.suep.sos.Dao.SurveyDao;
import com.suep.sos.Entity.Answer;
import com.suep.sos.Entity.Detail;
import com.suep.sos.Entity.SimpleAnswer;
import com.suep.sos.Entity.SurveyEditBase;
import com.suep.sos.Entity.Vue.*;
import com.suep.sos.Service.AnswerService;
import org.hsqldb.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerServiceImp implements AnswerService {

    @Autowired
    AnswerDao answerDao;
    @Autowired
    SurveyDao surveyDao;
    @Autowired
    DetailDao detailDao;
    @Autowired
    SimpleAnswerDao simpleAnswerDao;

    Map<Long, Long> hash = new HashMap<>();
    Long cnt = (long)0;

    private List<Answer> loadAnswer(VueSurvey answer) {
        List<Answer> answers = new LinkedList<>();
        Long surveyId = answer.getId();
        for (VueQuestion question : answer.getForms()) {
            Answer ans = new Answer();
            ans.setId(null);
            ans.setSurveyId(surveyId);
            ans.setDetailId(question.getId());
            String text = "";
            if (question.getType() == 0)
                text = JSON.toJSONString(question.getAns());
            else if (question.getType() == 1)
                text = JSON.toJSONString(question.getMulti());
            else if (question.getType() == 2)
                text = JSON.toJSONString(question.getContext());
            else if (question.getType() == 3)
                text = JSON.toJSONString(question.getRate());
            ans.setAns(text);
            answers.add(ans);
        }
        return answers;
    }

    @Override
    public Boolean saveAnswer(VueSurvey answer) {
        List<Answer> answers = loadAnswer(answer);
        answerDao.saveAll(answers);
        Long surveyId = answer.getId();
        Integer res = surveyDao.updateCount(surveyId);
        System.out.println(res);
        return res == 1;
    }

    @Override
    public List<SimpleAnswer> getAnswerBySurveyId(Long surveyId) {
        return simpleAnswerDao.findAllBySurveyId(surveyId);
    }

    @Override
    public List<VueAnalyze> getAnalyzeData(Long surveyId) {
        List<SimpleAnswer> temp = getAnswerBySurveyId(surveyId);
        List<VueAnalyze> res = new ArrayList<>();
        initHashMap();
        for (SimpleAnswer answer : temp) {
            Object ans = JSON.parse(answer.getAns());
            addNode(answer, res);
            Long resId = getListId(answer.getDetailId());
            switch (answer.getType()) {
                case 0: case 3:
                    Object tmp = JSON.parse(answer.getAns());
                    VueAnalyze getItem = res.get(Math.toIntExact(resId));
                    List<Integer> data = getItem.getData();
                    data.set((Integer) tmp, data.get((Integer) tmp) + 1);
                    getItem.setData(data);
                    res.set(Math.toIntExact(resId), getItem);
                    break;
                case 1:
                    List<Integer> array = JSON.parseArray(answer.getAns(), Integer.class);
                    VueAnalyze getItem1 = res.get(Math.toIntExact(resId));
                    List<RowData> data1 = getItem1.getData();
                    for (Integer a : array) {
                        RowData change = data1.get(a);
                        change.setValue(change.getValue() + 1);
                        data1.set(a, change);
                    }
                    getItem1.setData(data1);
                    res.set(Math.toIntExact(resId), getItem1);
                    break;
                case 2:
                    Object tmp2 = JSON.parse(answer.getAns());
                    VueAnalyze getItem2 = res.get(Math.toIntExact(resId));
                    List<String> data2 = getItem2.getData();
                    data2.add(tmp2.toString());
                    getItem2.setData(data2);
                    res.set(Math.toIntExact(resId), getItem2);
                    break;
            }
        }
//        System.out.println(res);
        return res;
    }

    private void addNode (SimpleAnswer answer, List<VueAnalyze> res) {

        Long resId = getListId(answer.getDetailId());
        if (resId >= res.size()) {
            VueAnalyze analyze = new VueAnalyze();
            SurveyEditBase titleData = surveyDao.findById(answer.getSurveyId());
            analyze.setTitle(titleData.getTitle());
            Detail detail = detailDao.findByIdAndSurveyId(answer.getDetailId(), answer.getSurveyId());
            List<Choice> choices = JSON.parseArray(detail.getChoices(), Choice.class);
            List<String> xData = new LinkedList<>();
            for (Choice choice : choices) {
                xData.add(choice.getValue());
            }
            analyze.setxData(xData);
            analyze.setType(answer.getType());
            switch (answer.getType()) {
                case 0:
                    List<Integer> data0 = new ArrayList<Integer>(xData.size());
                    for (int i = 0; i < xData.size(); i ++) data0.add(0);
                    analyze.setData(data0);
                    break;
                case 3:
                    List<Integer> data3 = new ArrayList<Integer>(6);
                    for (int i = 0; i < 6; i ++) data3.add(0);
                    analyze.setData(data3);
                    break;
                case 1:
                    List<RowData> list = new ArrayList<RowData>();
                    for (String xDatum : xData) {
                        RowData data = new RowData();
                        data.setName(xDatum);
                        data.setValue(0);
                        list.add(data);
                    }
                    analyze.setData(list);
                    xData.clear();
                    break;
                case 2:
                    analyze.setData(new ArrayList<String>());
                    break;
            }
            res.add(analyze);
        }
    }

    private void initHashMap() {
        hash.clear();
        cnt = (long)0;
    }

    private Long getListId (Long detailId) {
        if (hash.containsKey(detailId)) return hash.get(detailId);
        else {
            hash.put(detailId, cnt ++);
            return cnt;
        }
    }
}
