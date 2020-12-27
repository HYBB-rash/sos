package com.suep.sos.Entity.Vue;

public class VueProfile {

    private Integer id;
    private VueCustomer customer;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"customer\":")
                .append(customer);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VueCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(VueCustomer customer) {
        this.customer = customer;
    }
}
