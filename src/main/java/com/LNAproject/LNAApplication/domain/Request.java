package com.LNAproject.LNAApplication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
//@Table(name="request")
public class Request {
    @Id
    private String request_id;
    private String status;
    private String student_id;
    private String purpose;
    private Date expectedInTime;
    private Date expectedOutTime;

    public Request() {
    }

    public Request(String request_id, String student_id, String purpose, String expectedOutTime,String expectedInTime,String status) throws ParseException {

        this.request_id = request_id;
        this.student_id = student_id;
        this.purpose = purpose;
        this.expectedOutTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).parse(expectedOutTime);
        this.expectedInTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).parse(expectedInTime);
        this.status = status;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getExpectedInTime() {
        return expectedInTime;
    }

    public void setExpectedInTime(Date expectedInTime) {
        this.expectedInTime = expectedInTime;
    }

    public Date getExpectedOutTime() {
        return expectedOutTime;
    }

    public void setExpectedOutTime(Date expectedOutTime) {
        this.expectedOutTime = expectedOutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
