package com.itheima.ssm.service;

import com.itheima.ssm.SysLog;

import java.util.List;

public interface ISystemLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
