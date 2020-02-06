package com.LNAproject.LNAApplication.controller;

import com.LNAproject.LNAApplication.domain.*;
import com.LNAproject.LNAApplication.repository.*;
import com.LNAproject.LNAApplication.repository.AdminRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@CrossOrigin
@RestController
public class LnaController{

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    TripDataRepository tripDataRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminRepository adminRepository;

    //counts used to keep track trip_id and request_id
    int requestCount = 1;
    int tripCount = 1;

    //only admin can access all students request data
    @GetMapping(value = "/request/status/{status}")
    public List<Request> viewAllRequest(@PathVariable String status) {
        List<Request> list = (List<Request>) requestRepository.findAll();
        if(status.equals("all")) return list;
        List<Request> returnList = new ArrayList<Request>();
        for(Request request : list) {
            if(!request.getStatus().equals("started")) {
                returnList.add(request);
            }
        }
        return returnList;
    }

    //all can access request data of student
    @GetMapping(value = "/request/{student_id}")
    public List<Request> viewRequest(@PathVariable String student_id) {
        List<Request> list = (List<Request>) requestRepository.findAll();
        List<Request> returnList = new ArrayList<Request>();
        for (Request request : list) {
            if (request.getStudent_id().equals(student_id) && request.getStatus().equals("pending")) {
                returnList.add(request);
            }
        }
        return returnList;
    }

    //only admin can access, trip data of all students
    @GetMapping(value = "/trip")
    public List<TripData> viewAllTripData() {
        return (List<TripData>) tripDataRepository.findAll();
    }

    //only admin can access trip data of all students currently out
    @GetMapping(value = "/trip/current")
    public List<TripData> viewCurrentTripData() {
        List<TripData> tripData = (List<TripData>) tripDataRepository.findAll();
        List<TripData> ret = new ArrayList<>();
        for(TripData tripData1 : tripData) {
            if(tripData1.getActual_in_time() == null) {
                ret.add(tripData1);
            }
        }
        return ret;
    }

    //Get all trip data of a student
    @GetMapping(value = "/trip/student/{student_id}")
    public List<TripData> viewCurrentStudentTripData(@PathVariable String student_id) {
        List<TripData> tripData = (List<TripData>) tripDataRepository.findAll();
        List<TripData> ret = new ArrayList<>();
        for(TripData tripData1 : tripData) {
            if(tripData1.getStudent_id().equals(student_id)) {
                ret.add(tripData1);
            }
        }
        return ret;
    }

    //get all user data
    @GetMapping(value = "/user")
    public List<User> viewAllUserData() {
        return (List<User>) userRepository.findAll();
    }

    //get all parent data
    @GetMapping(value = "/parent")
    public List<Parent> viewAllParentData() {
        return (List<Parent>) parentRepository.findAll();
    }

    //get all students data
    @GetMapping(value = "/student")
    public List<Student> viewAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    //Enter list of students in post body
    @PostMapping(value = "/student")
    public void enterStudentDetails(@RequestBody @NotNull List<Student> students) {
        for(Student student : students) {
            studentRepository.save(student);
            userRepository.save(new User(student.getStudent_id(), "student"));
        }
    }

    //create request to request table
    @PostMapping(value = "/request")
    public void enterRequestDetails(@RequestBody TempRequest tempRequest) throws ParseException {
        //removes "T" present in data returned
        tempRequest.setExpectedOutTime((new StringBuilder(tempRequest.getExpectedOutTime()).replace(10, 11, " ")).toString());
        tempRequest.setExpectedInTime((new StringBuilder(tempRequest.getExpectedInTime()).replace(10, 11, " ")).toString());
        Request request = new Request(Integer.toString(requestCount ++), tempRequest.student_id, tempRequest.purpose, tempRequest.expectedOutTime, tempRequest.expectedInTime, tempRequest.status);
        requestRepository.save(request);
    }

    //add users to database
    @PostMapping(value = "/user")
    public void getUserdata(@RequestBody User user) {
        User new_record;
        new_record = new User(user.getUser_id(), user.getUser_type());
        userRepository.save(new_record);
    }

    //add parents to database
    @PostMapping(value = "/parent")
    public void enterParentDetails(@RequestBody @NotNull List<Parent> parentList) {
        for(Parent parent : parentList) {
            parentRepository.save(parent);
            userRepository.save(new User(parent.getParent_id(), "parent"));
        }
    }

    //add admins to database
    @PostMapping(value = "/admin")
    public void enterAdminDetails(@RequestBody @NotNull List<Admin> adminList) {
        for(Admin admin : adminList) {
            adminRepository.save(admin);
            userRepository.save(new User(admin.getAdmin_id(), "admin"));
        }
    }

    //all can get previous trip data of student
    @GetMapping(value = "/trip/{student_id}")
    public List<TripData> viewTripData(@PathVariable String student_id) {
        return (List<TripData>) tripDataRepository.findAll();
    }

    //parent responds to request by changing status of request
    @PostMapping(value = "/request/all/{request_id}")
    public void respondRequest(@PathVariable String request_id, @RequestBody String new_status) {
        Request request = requestRepository.findById(request_id).get();
        requestRepository.deleteById(request_id);
        //Removes "=" present in the end of new_status
        request.setStatus(new_status.substring(0, new_status.length() - 1));
        requestRepository.save(request);
    }

    //executed whenever card is scanned starts or ends trip
    @PostMapping(value = "/trip/{student_id}")
    public void startOrEndTrip(@PathVariable String student_id) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ZonedDateTime time = java.time.ZonedDateTime.now(ZoneOffset.ofHoursMinutes(5, 30));
        List<TripData> data = (List<TripData>) tripDataRepository.findAll();
        for(TripData trip : data) {
            if(trip.getStudent_id().equals(student_id) && trip.getActual_in_time() == null) {
                trip.setActual_in_time(java.time.ZonedDateTime.now(ZoneOffset.ofHoursMinutes(5, 30)));
                TripData temp = trip;
                tripDataRepository.deleteById(temp.getTrip_id());
                temp.setActual_in_time(java.time.ZonedDateTime.now(ZoneOffset.ofHoursMinutes(5, 30)));
                tripDataRepository.save(temp);
                return;
            }
        }

        //if not returned then student is checking out
        List<Request> list = (List<Request>) requestRepository.findAll();
        List<Request> requests = new ArrayList<Request>();
        for (Request request : list) {
            if (request.getStudent_id().equals(student_id) && request.getStatus().equals("approved")) {
                requests.add(request);
            }
        }
        boolean permissionPresent = false;
        for(Request request : requests) {
            if(time.compareTo(request.getExpectedInTime()) < 0 && time.compareTo(request.getExpectedOutTime()) > 0) {
                permissionPresent = true;
                break;
            }
        }
        TripData newTrip = new TripData(Integer.toString(tripCount ++), student_id, permissionPresent, time);
        tripDataRepository.save(newTrip);
    }
}

//Temporary class to handle incoming date data in string and convert it to date format
class TempRequest{
    String request_id;
    String status;
    String student_id;
    String purpose;
    String expectedInTime;
    String expectedOutTime;

    public TempRequest() {
    }

    public TempRequest(String request_id, String status, String student_id, String purpose, String expectedInTime, String expectedOutTime) {
        this.request_id = request_id;
        this.status = status;
        this.student_id = student_id;
        this.purpose = purpose;
        this.expectedInTime = (new StringBuilder(expectedInTime).replace(10, 11, " ")).toString();
        this.expectedOutTime = (new StringBuilder(expectedOutTime).replace(10, 11, " ")).toString();
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getExpectedInTime() {
        return expectedInTime;
    }

    public void setExpectedInTime(String expectedInTime) {
        this.expectedInTime = expectedInTime;
    }

    public String getExpectedOutTime() {
        return expectedOutTime;
    }

    public void setExpectedOutTime(String expectedOutTime) {
        this.expectedOutTime = expectedOutTime;
    }
}
