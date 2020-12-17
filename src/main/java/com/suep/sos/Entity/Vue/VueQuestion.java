package com.suep.sos.Entity.Vue;

import java.util.List;

public class VueQuestion {

    private Long id;
    private String question;
    private Integer type;
    private String context;
    private Integer ans;
    private List<Integer> multi;
    private Integer rate;
    private Boolean flag;
    private List<Choice> choices;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":")
                .append(id);
        builder.append(",\"question\":\"")
                .append(question).append('\"');
        builder.append(",\"type\":")
                .append(type);
        builder.append(",\"context\":\"")
                .append(context).append('\"');
        builder.append(",\"ans\":")
                .append(ans);
        builder.append(",\"multi\":")
                .append(multi);
        builder.append(",\"rate\":")
                .append(rate);
        builder.append(",\"flag\":")
                .append(flag);
        builder.append(",\"choices\":")
                .append(choices);
        builder.append('}');
        return builder.toString();
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getAns() {
        return ans;
    }

    public void setAns(Integer ans) {
        this.ans = ans;
    }

    public List<Integer> getMulti() {
        return multi;
    }

    public void setMulti(List<Integer> multi) {
        this.multi = multi;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
