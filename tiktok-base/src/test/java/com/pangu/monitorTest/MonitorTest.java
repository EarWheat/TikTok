package com.pangu.monitorTest;

import com.pangu.Monitor.scheduled.Entity.MonitorEntity;
import com.pangu.Monitor.scheduled.service.IMonitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-26 16:54
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MonitorTest {
    private static final Logger logger = LoggerFactory.getLogger(MonitorTest.class);


    @Resource
    private IMonitorService monitorService;

    @Test
    @RequestMapping("/")
    public void monitor() throws Exception {
        MonitorEntity monitor = new MonitorEntity();
        monitor.setTitle("测试");
        monitor.setContent("监控测试");
        logger.info(monitor.toString());
        monitorService.start(monitor);
    }
}
