package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name="request")
public class Request {
    @Id @GeneratedValue
    @Column(name = "request_id")
    private String request_id;

    @Column(name = "request_status")
    private String status;

    @Column(name = "student_id")
    private String student_id;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "expected_in-time")
    private Timestamp expectedInTime;

    @Column(name = "expected_out-time")
    private Timestamp expectedOutTime;


    public Request() {
    }

    public Request(String student_id, String status, String purpose, Timestamp expectedInTime, Timestamp expectedOutTime) {

        this.student_id = student_id;
        this.status = status;
        this.purpose = purpose;
        this.expectedInTime = expectedInTime;
        this.expectedOutTime = expectedOutTime;

    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Timestamp getExpectedInTime() {
        return expectedInTime;
    }

    public void setExpectedInTime(Timestamp expectedInTime) {
        this.expectedInTime = expectedInTime;
    }

    public Timestamp getExpectedOutTime() {
        return expectedOutTime;
    }

    public void setExpectedOutTime(Timestamp expectedOutTime) {
        this.expectedOutTime = expectedOutTime;
    }
}
