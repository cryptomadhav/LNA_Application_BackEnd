package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TripData {
    @Id
    private Long trip_id;
    private Long student_id;
    boolean permissionPresent;
    private Timestamp actual_out_time;
    private Timestamp actual_in_time;

    public TripData() {

    }

    public TripData(Long student_id, boolean permissionPresent, Timestamp actual_out_time) {
        this.student_id = student_id;
        this.permissionPresent = permissionPresent;
        this.actual_out_time = actual_out_time;
    }

    public Long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Long trip_id) {
        this.trip_id = trip_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public boolean isPermissionPresent() {
        return permissionPresent;
    }

    public void setPermissionPresent(boolean permissionPresent) {
        this.permissionPresent = permissionPresent;
    }

    public Timestamp getActual_out_time() {
        return actual_out_time;
    }

    public void setActual_out_time(Timestamp actual_out_time) {
        this.actual_out_time = actual_out_time;
    }

    public Timestamp getActual_in_time() {
        return actual_in_time;
    }

    public void setActual_in_time(Timestamp actual_in_time) {
        this.actual_in_time = actual_in_time;
    }
}
