package com.itheima.ssm.controller;

import com.itheima.ssm.SysLog;
import com.itheima.ssm.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISystemLogService systemLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = systemLogService.findAll();
        mv.addObject("sysLogs", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }

}
