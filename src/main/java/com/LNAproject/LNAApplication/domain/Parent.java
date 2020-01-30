package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
//@Table(name = "parent")
public class Parent {

    @Id
//    @Column(name = "parent_id")
    private String parent_id;

//    @Column(name = "student_id")
    private String student_id;

//    @Column(name = "phone_number")
    private String phoneNumber;

    public Parent() {
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
