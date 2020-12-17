package com.suep.sos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "survey")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "userid")
    int userId;
    String title;
    String instruction;
    int status;
    String day;
    int count;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":")
                .append(id);
        builder.append(",\"userId\":")
                .append(userId);
        builder.append(",\"title\":\"")
                .append(title).append('\"');
        builder.append(",\"instruction\":\"")
                .append(instruction).append('\"');
        builder.append(",\"status\":")
                .append(status);
        builder.append(",\"day\":\"")
                .append(day).append('\"');
        builder.append(",\"count\":")
                .append(count);
        builder.append('}');
        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
