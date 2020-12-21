package com.suep.sos;

import com.suep.sos.Entity.SimpleAnswer;
import com.suep.sos.Entity.Vue.RowData;
import com.suep.sos.Entity.Vue.VueAnalyze;
import com.suep.sos.Service.AnswerService;
import com.suep.sos.Service.Implementation.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
