package com.suep.sos.Entity.Vue;

import java.util.ArrayList;
import java.util.List;

public class VueAnalyze {

    private String title;
    private Integer type;
    private List<String> xData;
    private List data;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"title\":\"")
                .append(title).append('\"');
        builder.append(",\"type\":")
                .append(type);
        builder.append(",\"xData\":")
                .append(xData);
        builder.append(",\"data\":")
                .append(data);
        builder.append('}');
        return builder.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getxData() {
        return xData;
    }

    public void setxData(List<String> xData) {
        this.xData = xData;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
