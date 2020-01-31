package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    @Id @GeneratedValue
    private Long id;
//    @Column(name = "user_id")
    private Long user_id;

//    @OneToOne(mappedBy = "parent_id")
//    private Parent parent;
//
//    @OneToOne(mappedBy = "admin_id")
//    private Admin admin;

//    @Column(name = "user_type")
    private String user_type;

    public User(Long user_id, String user_type) {
        this.user_id = user_id;
        this.user_type = user_type;
    }


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
