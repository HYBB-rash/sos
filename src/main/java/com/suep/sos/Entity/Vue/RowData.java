package com.suep.sos.Entity.Vue;

public class RowData {

    private Integer value;
    private String name;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"value\":")
                .append(value);
        builder.append(",\"name\":\"")
                .append(name).append('\"');
        builder.append('}');
        return builder.toString();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}