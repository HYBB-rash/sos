package com.suep.sos.Entity.Vue;

import java.util.List;

public class VueSurvey {

    private Long id;
    private Integer userId;
    private String surveyTitle;
    private String instruction;
    private List<VueQuestion> forms;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":")
                .append(id);
        builder.append(",\"userId\":")
                .append(userId);
        builder.append(",\"surveyTitle\":\"")
                .append(surveyTitle).append('\"');
        builder.append(",\"instruction\":\"")
                .append(instruction).append('\"');
        builder.append(",\"forms\":")
                .append(forms);
        builder.append('}');
        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<VueQuestion> getForms() {
        return forms;
    }

    public void setForms(List<VueQuestion> forms) {
        this.forms = forms;
    }
}
