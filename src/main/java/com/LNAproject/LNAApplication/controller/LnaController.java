package com.LNAproject.LNAApplication.controller;

import com.LNAproject.LNAApplication.domain.*;
import com.LNAproject.LNAApplication.repository.*;
import com.LNAproject.LNAApplication.repository.AdminRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    //only admin can access all students request data
    @GetMapping(value = "/request")
    public List<Request> viewAllRequest() {
        return (List<Request>) requestRepository.findAll();
    }

    //all can access request data of student
    @GetMapping(value = "/request/{student_id}")
    public List<Request> viewRequest(@PathVariable Long student_id) {
        List<Request> list = (List<Request>) requestRepository.findAll();
        List<Request> returnList = new ArrayList<Request>();
        for (Request request : list) {
            if (request.getStudent_id().equals(student_id)) {
                returnList.add(request);
            }
        }
        return returnList;
    }

    //only admin can access trip data of all students
    @GetMapping(value = "/trip")
    public List<TripData> viewAllTripData() {
        return (List<TripData>) tripDataRepository.findAll();
    }

    @GetMapping(value = "/user")
    public List<User> viewAllUserData() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(value = "/parent")
    public List<Parent> viewAllparentData() {
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
    @PostMapping(value = "/request")
    public void enterRequestDetails(@RequestBody @NotNull List<Request> requests) {
        for(Request request : requests) {
            requestRepository.save(request);

        }
    }
    @PostMapping(value = "/user")
    public void getUserdata(@RequestBody User user) {
        User new_record;
        new_record = new User(user.getUser_id(), user.getUser_type());
        userRepository.save(new_record);
    }

//    @PostMapping(value = "/request")
//    public void enterUserDetails(@RequestBody Request requests) {
//        Request request =new Request(requests.getStudent_id(),requests.getRequest_id(),requests.getPurpose(),requests.getExpectedOutTime(),requests.getExpectedInTime(),requests.getStatus());
//
//            requestRepository.save(request);
//
//
//    }

    @PostMapping(value = "/parent")
    public void enterParentDetails(@RequestBody @NotNull List<Parent> parentList) {
        for(Parent parent : parentList) {
            parentRepository.save(parent);
            userRepository.save(new User(parent.getParent_id(), "parent"));
        }
    }
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

    //student creates request in request table
//    @PostMapping(value = "/student/{student_id}")
//    public void makeRequest(@PathVariable Long student_id, Long request_id, String purpose, Timestamp expectedOutTime, Timestamp expectedInTime,String status) {
//        requestRepository.save(new Request(student_id, request_id ,purpose,  expectedOutTime, expectedInTime, status));
//    }

    //parent responds to request by changing status if request
    @PutMapping(value = "/request/*/{request_id}")
    public void respondRequest(@PathVariable String request_id,@RequestBody String new_status) {
        Request request;
        request = requestRepository.findById(request_id).get();
        request.setStatus(new_status);
        requestRepository.deleteById(request_id);
        requestRepository.save(request);
    }

    //executed whenever card is scanned starts or ends trip
    @PostMapping(value = "/trip")
    public void startOrEndTrip(Long student_id) {
        Date date= new Date();
        long time = date.getTime();
        Timestamp currentTimestamp = new Timestamp(time);

        List<TripData> studentOutTrip = (List<TripData>) tripDataRepository.getStudentIn(Long.toString(student_id));//first check if student is checking in
        if(studentOutTrip.size() > 0) {//not checked case where more than one trips may have missing in-times

            long gapBetweenEntryExit = 10 * 1000;//check if card is scanned after 5 mins from previous
            if(
                    (new Timestamp(studentOutTrip.get(0).getActual_out_time().getTime() + gapBetweenEntryExit))
                            .after(currentTimestamp)
            ){
                return;
            }
            studentOutTrip.get(0).setActual_in_time(currentTimestamp);
            return;
        }
        //if not returned then student in checking out
        List<Request> requests = (List<Request>) requestRepository.findAll();
        boolean permissionPresent = false;
        for(Request request : requests) {
            if(currentTimestamp.before(request.getExpectedInTime()) && currentTimestamp.after(request.getExpectedOutTime())) {
                permissionPresent = true;
                break;
            }
        }
        TripData newTrip = new TripData(student_id, permissionPresent, currentTimestamp);
    }
}
