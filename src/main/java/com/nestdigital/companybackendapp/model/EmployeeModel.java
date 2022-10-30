package com.nestdigital.companybackendapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue
    private int id;
    private int emp_code;
    private String name;
    private String designation;
    private String doj;
    private String username;
    private String password;

    public EmployeeModel() {
    }

    public EmployeeModel(int id, int emp_code, String name, String designation, String doj, String username, String password) {
        this.id = id;
        this.emp_code = emp_code;
        this.name = name;
        this.designation = designation;
        this.doj = doj;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_code() {
        return emp_code;
    }

    public void setEmp_code(int emp_code) {
        this.emp_code = emp_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
