package com.tiktok.Monitor.scheduled.service;

import com.tiktok.Monitor.scheduled.Entity.MonitorEntity;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-26 16:40
 * @desc: 监控服务类
 */
public interface IMonitorService{
    void start(MonitorEntity monitorEntity) throws Exception;
}
