package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class TripData {
    @Id
    private String trip_id;
    private String student_id;
    boolean permissionPresent;
    private ZonedDateTime actual_out_time;
    private ZonedDateTime actual_in_time;

    public TripData() {
    }

    public TripData(String trip_id,String student_id, boolean permissionPresent, ZonedDateTime actual_out_time) {
        this.trip_id = trip_id;
        this.student_id = student_id;
        this.permissionPresent = permissionPresent;
        this.actual_out_time = actual_out_time;
        this.actual_in_time = null;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public boolean isPermissionPresent() {
        return permissionPresent;
    }

    public void setPermissionPresent(boolean permissionPresent) {
        this.permissionPresent = permissionPresent;
    }

    public ZonedDateTime getActual_out_time() {
        return actual_out_time;
    }

    public void setActual_out_time(ZonedDateTime actual_out_time) {
        this.actual_out_time = actual_out_time;
    }

    public ZonedDateTime getActual_in_time() {
        return actual_in_time;
    }

    public void setActual_in_time(ZonedDateTime actual_in_time) {
        this.actual_in_time = actual_in_time;
    }
}
