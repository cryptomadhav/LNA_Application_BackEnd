package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {


    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private String admin_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "user_id")
    private User user;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
