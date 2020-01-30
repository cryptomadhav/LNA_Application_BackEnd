package com.LNAproject.LNAApplication.controller;

import com.LNAproject.LNAApplication.domain.Request;
import com.LNAproject.LNAApplication.domain.TripData;
import com.LNAproject.LNAApplication.repository.ParentRepository;
import com.LNAproject.LNAApplication.repository.RequestRepository;
import com.LNAproject.LNAApplication.repository.StudentRepository;
import com.LNAproject.LNAApplication.repository.TripDataRepository;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LnaController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    TripDataRepository tripDataRepository;

    @GetMapping(value = "/request")  //only admin can access
    public List<Request> viewAllRequest() {
        return (List<Request>) requestRepository.findAll();
    }

    @GetMapping(value = "/request/{student_id}")  //all can access
    public List<Request> viewRequest(@PathVariable String student_id) {
        List<Request> list = (List<Request>) requestRepository.findAll();
        List<Request> returnList = new ArrayList<Request>();
        for (Request request : list) {
            if (request.getStatus().equals(student_id)) {
                returnList.add(request);
            }
        }
        return returnList;
    }

    @GetMapping(value = "/trip")   // only admin can access
    public List<TripData> viewAllTripData() {
        return (List<TripData>) tripDataRepository.findAll();
    }

    @GetMapping(value = "/trip/{student_id}")   // all can access
    public List<TripData> viewTripData(@PathVariable String student_id) {
        return (List<TripData>) tripDataRepository.findAll();
    }

    @PostMapping(value = "/student/{student_id}")   //student creates request
    public void makeRequest(@PathVariable String student_id, String status, String purpose, ZonedDateTime expectedInTime, ZonedDateTime expectedOutTime) {
        requestRepository.save(new Request(student_id, status, purpose, expectedInTime, expectedOutTime));
    }


    @PutMapping(value = "/request/*/{request_id}")
    public void respondRequest(@PathVariable String request_id, String new_status) {
        Request request = requestRepository.findById(request_id).get();
        request.setStatus(new_status);
        requestRepository.save(request);
    }

    @PostMapping(value = "/trip")
    public void startTrip(String student_id) {
        List<Request> requests = (List<Request>) requestRepository.findAll();
        List<Request> returnList = new ArrayList<Request>();
        Timestamp currentTime = ZonedDateTime.now();
        for(Request request : requests) {
            if(c)
        }
    }

}
