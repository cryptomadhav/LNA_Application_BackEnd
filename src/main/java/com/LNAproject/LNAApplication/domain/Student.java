package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
public class Student {

    @Id @GeneratedValue
    private Long id;
    private Long student_id;
    private String phoneNumber;
    private String property;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
