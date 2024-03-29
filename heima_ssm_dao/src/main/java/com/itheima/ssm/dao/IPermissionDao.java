package com.itheima.ssm.dao;

import com.itheima.ssm.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("Insert into permission(permissionName, url) values (#{permissionName}, #{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id = #{id}")
    Permission findById(String id) throws Exception;

    @Delete("delete from role_permission where permissionId = #{id}")
    void deleteFromRole_Permission(String id) throws Exception;

    @Delete("delete from permission where id = #{id}")
    void deleteById(String id) throws Exception;
}
