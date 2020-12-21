package com.suep.sos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "simpleAnswer")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class SimpleAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    Long surveyId;
    Long detailId;
    String ans;
    Integer type;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":")
                .append(id);
        builder.append(",\"surveyId\":")
                .append(surveyId);
        builder.append(",\"detail\":")
                .append(detailId);
        builder.append(",\"ans\":\"")
                .append(ans).append('\"');
        builder.append(",\"type\":")
                .append(type);
        builder.append('}');
        return builder.toString();
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detail) {
        this.detailId = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
