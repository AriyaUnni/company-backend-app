package com.nestdigital.companybackendapp.controller;

import com.nestdigital.companybackendapp.dao.SecurityDao;

import com.nestdigital.companybackendapp.model.EmployeeModel;
import com.nestdigital.companybackendapp.model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity", consumes = "application/json", produces = "application/json")
    public String addSecurity(@RequestBody SecurityModel add) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        add.setDoj(currentdate);
        System.out.println(add.toString());
        dao.save(add);
        return "{status:'success'}";

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecurity")
    public List<SecurityModel> viewSecurity() {
        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginsecurity", consumes = "application/json", produces = "application/json")
    public List<SecurityModel> employeeLogin(@RequestBody EmployeeModel login) {
        return (List<SecurityModel>) dao.Login(login.getUsername(), login.getPassword());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchsecurity", consumes = "application/json", produces = "application/json")
    public List<SecurityModel> searchsecurity(@RequestBody SecurityModel search) {
        return (List<SecurityModel>) dao.searchSecurity(search.getName());
    }

    @CrossOrigin(value = "*")
    @Transactional
    @PostMapping(path = "/deletesecurity", consumes = "application/json", produces = "application/json")
    public String deleteSecurity(@RequestBody SecurityModel delete) {
        dao.deleteSecurityById(delete.getId());
        ;
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editsecurity", consumes = "application/json", produces = "application/json")
    public String editsecurity(@RequestBody SecurityModel edit) {
        dao.editSecurity(edit.getDoj(), edit.getName(), edit.getPassword(), edit.getSecurity_code(), edit.getUsername(), edit.getId());
        return "{status:'success'}";
    }

}
