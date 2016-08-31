package org.seckill.job;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * User: xujiangjun
 * Date: 16/8/31 16:06
 */
@Slf4j
public class Job {

    public void execute(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipAddress = inetAddress.getHostAddress();
            System.out.println("不继承QuartzJobBean方式---调度进行中... [ip:" + ipAddress + "]");
        } catch (UnknownHostException e) {
            log.error("获取本机ip异常", e);
        }
    }
}
