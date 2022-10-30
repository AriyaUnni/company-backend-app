package com.nestdigital.companybackendapp.controller;

import com.nestdigital.companybackendapp.dao.LogDao;
import com.nestdigital.companybackendapp.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/checkIn",consumes = "application/json",produces = "application/json")
    public String addLogin(@RequestBody LogModel log){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        log.setLogout_time(String.valueOf(dt.format(now)));
        System.out.println(log.toString());
        dao.save(log);
        return "{status:'success'}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/checkout",consumes = "application/json",produces = "application/json")
    public String updateLog(@RequestBody LogModel log){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        log.setLogout_time(String.valueOf(dt.format(now)));

        dao.updateLog(log.getLogout_id(),log.getLogout_time(),log.getId());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Map<String,String>> viewallLog(){
        return (List<Map<String, String>>) dao.viewAllLogs();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/viewLogById")
    public List<Map<String,String>> viewLogById(@RequestBody LogModel log){
        return (List<Map<String, String>>) dao.viewLogByEmpId(log.getEmpid());
    }

}
