package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    private Long admin_id;

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }
}
