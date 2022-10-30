package com.nestdigital.companybackendapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaveform")
public class LeaveModel {
    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String applied_date;
    private String approveddate;
    private String duration;
    private String type;
    private String reason;
    private int status;


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

    public String getApplied_date() {
        return applied_date;
    }

    public void setApplied_date(String applied_date) {
        this.applied_date = applied_date;
    }

    public String getApproveddate() {
        return approveddate;
    }

    public void setApproveddate(String approveddate) {
        this.approveddate = approveddate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LeaveModel() {
    }

    public LeaveModel(int id, int empid, String applied_date, String approveddate, String duration, String type, String reason, int status) {
        this.id = id;
        this.empid = empid;
        this.applied_date = applied_date;
        this.approveddate = approveddate;
        this.duration = duration;
        this.type = type;
        this.reason = reason;
        this.status = status;
    }
}
