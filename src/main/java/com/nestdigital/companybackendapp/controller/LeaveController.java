package com.nestdigital.companybackendapp.controller;

import com.nestdigital.companybackendapp.dao.LeaveDao;
import com.nestdigital.companybackendapp.model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping("/addLeave")
    public String addLeave(@RequestBody LeaveModel leave){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        leave.setApplied_date((String.valueOf(date.format(now))));
        leave.setStatus(0);
        dao.save(leave);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveapply",consumes = "application/json",produces = "application/json")
    List<Map<String,String>> leaveApply(@RequestBody LeaveModel leave){
        return (List<Map<String, String>>) dao.View(leave.getEmpid());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallLeaves")
    public List<Map<String,String>> viewLeaves(){
        return (List<Map<String, String>>) dao.Leave();
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/leavestatus",consumes = "application/json",produces = "application/json")
    public String changeleaveStatus(@RequestBody LeaveModel leave){
        dao.changeStatus(leave.getId(),leave.getStatus());
        return "{status:'success'}";
    }

}
