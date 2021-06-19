package com.itheima.ssm.controller;

import com.itheima.ssm.Permission;
import com.itheima.ssm.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
       roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");

        return mv;
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name="id",required = true) String roleId) throws Exception {
        roleService.deleteRoleById(roleId);
        return "redirect:findAll.do";
/*如果接收前端的值前端接收时所定义的变量名与前端传入变量的name所定义的名字一样的时候，不需要用 @RequestParam注解来接收，
如果我们所定义的变量名玉前端传入变量的name所定义的名字不一样是我们需要通过@RequestParam(name = “username”) String user 或者@RequestParam(value = “username”) String user ，
这种形式将前端变量的name为username的值传给我们定义的user。
最后@RequestParam(defaultValue = “1”) String demo，这样如果前端没有传一个demo值的话，demo就不是null而是我们定义的给他的默认值1。*/
    }

    //根据roleId查询role,并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");

        return mv;

    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId,
                                      @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {

        roleService.addPermissionToRole(roleId, permissionIds);

        return "redirect:findAll.do";
    }



}
