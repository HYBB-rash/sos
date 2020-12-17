package com.suep.sos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "detail")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    Long surveyId;
    String question;
    int type;
    String choices;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":")
                .append(id);
        builder.append(",\"surveyId\":")
                .append(surveyId);
        builder.append(",\"question\":\"")
                .append(question).append('\"');
        builder.append(",\"type\":")
                .append(type);
        builder.append(",\"choices\":\"")
                .append(choices).append('\"');
        builder.append('}');
        return builder.toString();
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }
}
