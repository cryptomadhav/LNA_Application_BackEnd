package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
//@Table(name = "student")
public class Student {

    @Id @GeneratedValue
    private Long id;
//    @GeneratedValue
//    @Column(name = "student_id")
    private Long student_id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_id", referencedColumnName = "user_id")
//    private User user;

//    @Column(name = "phone_number")
    private String phoneNumber;

//    @Column(name = "property")
    private String property;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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
