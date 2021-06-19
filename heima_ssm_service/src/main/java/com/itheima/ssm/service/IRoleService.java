package com.itheima.ssm.service;

import com.itheima.ssm.Permission;
import com.itheima.ssm.Role;

import java.util.List;

public interface IRoleService {

   public List<Role> findAll() throws Exception;

   void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    void deleteRoleById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
