package com.nestdigital.companybackendapp.dao;

import com.nestdigital.companybackendapp.model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `logs` SET `logout_id`=:logout_id,`logout_time`=:logout_time WHERE `id`=:id",nativeQuery = true)
    void updateLog(Integer logout_id,String logout_time,Integer id);

    @Query(value = "SELECT l.`id`, l.`empid`, l.`login_id`, l.`login_time`, l.`logout_id`, l.`logout_time`,e.name,s.name AS login_name,c.name AS logout_name FROM logs l JOIN employee e JOIN security s  JOIN security c ON l.empid=e.id AND l.login_id=s.id AND l.logout_id=c.id",nativeQuery = true)
    List<Map<String,String>> viewAllLogs();

    @Query(value = "SELECT l.`id`, l.`empid`, l.`login_id`, l.`login_time`, l.`logout_id`, l.`logout_time`,e.name,s.name AS login_name,c.name AS logout_name FROM logs l JOIN employee e JOIN security s  JOIN security c ON l.empid=e.id AND l.login_id=s.id AND l.logout_id=c.id WHERE l.empid=:empid",nativeQuery = true)
    List<Map<String,String>> viewLogByEmpId(Integer empid);
}
