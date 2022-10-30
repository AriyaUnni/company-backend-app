package com.nestdigital.companybackendapp.dao;

import com.nestdigital.companybackendapp.model.LeaveModel;
import com.nestdigital.companybackendapp.model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `security_code`, `username` FROM `security` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<SecurityModel> Login(String username,String password);

    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `security_code`, `username` FROM `security` WHERE `name`=:name",nativeQuery = true)
    List<SecurityModel> searchSecurity(String name);

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `id`=:id",nativeQuery = true)
    void deleteSecurityById(Integer id);

    @Modifying
    @Query(value = "UPDATE `security` SET `doj`=:doj,`name`=:name,`password`=:password,`security_code`=:security_code,`username`=:username WHERE `id`=:id",nativeQuery = true)
    void editSecurity(String doj,String name,String password,Integer security_code,String username,Integer id);
}
