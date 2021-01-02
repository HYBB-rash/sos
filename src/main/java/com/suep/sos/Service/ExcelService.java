package com.suep.sos.Service;

import com.suep.sos.Entity.Vue.VueAnalyze;
import com.suep.sos.Entity.Vue.VueSurvey;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public interface ExcelService {

    String getExcelData(List<VueAnalyze> analyze) throws IOException;
    void loadExcelSurvey(VueSurvey survey);
    String getExcelSurvey (Long surveyID) throws IOException;
}
