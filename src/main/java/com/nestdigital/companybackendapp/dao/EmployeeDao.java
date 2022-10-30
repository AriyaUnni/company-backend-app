package com.nestdigital.companybackendapp.dao;

import com.nestdigital.companybackendapp.model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `designation`, `doj`, `emp_code`, `name`, `password`, `username` FROM `employee` WHERE `name`=:name",nativeQuery = true)
    List<EmployeeModel> searchEmp(String name);

    @Modifying
    @Query(value = "DELETE FROM `employee` WHERE `id`=:id",nativeQuery = true)
    void deleteEmployeeById(Integer id);

    @Modifying
    @Query(value = "UPDATE `employee` SET `designation`=:designation,`doj`=:doj,`emp_code`=:emp_code,`name`=:name,`password`=:password,`username`=:username WHERE `id`=:id",nativeQuery = true)
    void editEmp(String designation,String doj,Integer emp_code,String name,String password,String username,Integer id);

    @Query(value = "SELECT `id`, `designation`, `doj`, `emp_code`, `name`, `password`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<EmployeeModel> Login(String username,String password);
}
