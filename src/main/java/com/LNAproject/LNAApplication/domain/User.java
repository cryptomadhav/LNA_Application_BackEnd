package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    @Id
    @Column(name = "user_id")
    private String user_id;

//    @OneToOne(mappedBy = "parent_id")
//    private Parent parent;
//
//    @OneToOne(mappedBy = "admin_id")
//    private Admin admin;

    @Column(name = "user_type")
    private String user_type;

    @Column(name = "name")
    private String name;

    public User(String user_id, String user_type) {

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
