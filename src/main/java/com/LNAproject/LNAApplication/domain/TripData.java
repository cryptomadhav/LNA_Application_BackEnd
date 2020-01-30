package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//@Table(name="trip_data")
public class TripData {
    @Id
//    @GeneratedValue
//    @Column(name = "trip_id")
    private String trip_id;

//    @Column(name = "student_id")
    private String student_id;
//
//    @OneToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
//    private Student student;

//    @Column(name = "permission_present")
    boolean permissionPresent;

//    @Column(name = "actual_out_time")
    private Timestamp actual_out_time;

//    @Column(name = "actual_in_time")
    private Timestamp actual_in_time;

    public TripData() {

    }

    public TripData(String student_id, boolean permissionPresent, Timestamp actual_out_time) {
        this.student_id = student_id;
        this.permissionPresent = permissionPresent;
        this.actual_out_time = actual_out_time;
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
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

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
