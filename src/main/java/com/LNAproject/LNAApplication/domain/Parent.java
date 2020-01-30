package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue
    @Column(name = "parent_id")
    private String parent_id;

    @Column(name = "student_id")
    private String student_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "phone_number")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
