package com.suep.sos.Entity.Vue;

public class Choice {

    private String value;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"value\":\"")
                .append(value).append('\"');
        builder.append('}');
        return builder.toString();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
