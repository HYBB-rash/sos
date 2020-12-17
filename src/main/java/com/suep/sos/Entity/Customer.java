package com.suep.sos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    int userId;
    String name;
    String sex;
    String address;
    String phone;
    String company;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":")
                .append(id);
        builder.append(",\"userId\":")
                .append(userId);
        builder.append(",\"name\":\"")
                .append(name).append('\"');
        builder.append(",\"sex\":\"")
                .append(sex).append('\"');
        builder.append(",\"address\":\"")
                .append(address).append('\"');
        builder.append(",\"phone\":\"")
                .append(phone).append('\"');
        builder.append(",\"company\":\"")
                .append(company).append('\"');
        builder.append('}');
        return builder.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
