package com.nestdigital.companybackendapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class LogModel {
    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private int login_id;
    private int logout_id;
    private String login_time;
    private String logout_time;

    public LogModel() {
    }

    public LogModel(int id, int empid, int login_id, int logout_id, String login_time, String logout_time) {
        this.id = id;
        this.empid = empid;
        this.login_id = login_id;
        this.logout_id = logout_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public int getLogout_id() {
        return logout_id;
    }

    public void setLogout_id(int logout_id) {
        this.logout_id = logout_id;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(String logout_time) {
        this.logout_time = logout_time;
    }
}
