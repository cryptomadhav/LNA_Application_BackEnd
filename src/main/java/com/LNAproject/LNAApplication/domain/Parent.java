package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
//@Table(name = "parent")
public class Parent {

    @Id
//    @Column(name = "parent_id")
    private Long parent_id;

//    @Column(name = "student_id")
    private Long student_id;

//    @Column(name = "phone_number")
    private String phoneNumber;

    public Parent() {
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

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
}
