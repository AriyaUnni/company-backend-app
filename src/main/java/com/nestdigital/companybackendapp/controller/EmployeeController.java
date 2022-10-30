package com.nestdigital.companybackendapp.controller;

import com.nestdigital.companybackendapp.dao.EmployeeDao;
import com.nestdigital.companybackendapp.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public String addEmployee(@RequestBody EmployeeModel add){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        add.setDoj(currentdate);
        System.out.println(add.toString());
        dao.save(add);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemployee")
    public List<EmployeeModel> viewEmployee(){
        return (List<EmployeeModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> searchEmployee(@RequestBody EmployeeModel search){
        return (List<EmployeeModel>) dao.searchEmp(search.getName());
    }

    @CrossOrigin(value = "*")
    @Transactional
    @PostMapping(path = "/deleteemployee",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody EmployeeModel delete){
        dao.deleteEmployeeById(delete.getId());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editemployee",consumes = "application/json",produces = "application/json")
    public String editEmployee(@RequestBody EmployeeModel edit){
        dao.editEmp(edit.getDesignation(),edit.getDoj(),edit.getEmp_code(),edit.getName(),edit.getPassword(),edit.getUsername(),edit.getId());
        return "{status:'success'}";

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> employeeLogin(@RequestBody EmployeeModel login){
        return (List<EmployeeModel>) dao.Login(login.getUsername(),login.getPassword());
    }
}
