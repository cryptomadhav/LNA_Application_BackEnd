package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private Long user_id;
    private String user_type;

    public User() {
    }

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
