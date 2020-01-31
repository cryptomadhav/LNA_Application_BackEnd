package com.LNAproject.LNAApplication.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
//@Table(name="request")
public class Request {
    @Id //@GeneratedValue
//    @Column(name = "request_id")
    private String request_id;

//    @Column(name = "request_status")
    private String status;

//    @Column(name = "student_id")
    private Long student_id;

//    @OneToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
//    private Student student;

//    @Column(name = "purpose")
    private String purpose;

//    @Column(name = "expected_in-time")
    private Timestamp expectedInTime;

//    @Column(name = "expected_out-time")
    private Timestamp expectedOutTime;


    public Request() {
    }

    public Request(Long student_id,String request_id,  String purpose, Timestamp expectedOutTime,Timestamp expectedInTime,String status) {

        this.student_id = student_id;
        this.request_id=request_id;

        this.purpose = purpose;
        this.expectedOutTime = expectedOutTime;
        this.expectedInTime = expectedInTime;

        this.status = status;

    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
