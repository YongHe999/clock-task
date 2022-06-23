package com.clock.config;

import cn.hutool.core.util.StrUtil;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.io.File;
import java.io.IOException;

/**
 * @author Z
 * @description 配置
 * @date create in 2021/9/16 14:32
 */

@ComponentScan(value = "com.clock")
@Configuration
@ConfigurationProperties(prefix = "ant-task.conf")
public class TaskConfig {

    /**
     * 定时任务线程池，默认为 6
     */
    public int poolSize = 6;

    /**
     * 任务数据配置文件存储路径(必填)
     */
    public static String filePath;

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

        taskScheduler.setPoolSize(poolSize);
        taskScheduler.setRemoveOnCancelPolicy(true);
        taskScheduler.setThreadNamePrefix("SysTaskThreadPool-");

        if (StrUtil.isEmpty(filePath)) {
            throw new RuntimeException("ant-task.conf.file-path 配置为空");
        }

//        if (StrUtil.isEmpty(filePath)) {
//            File file = new File(filePath);
//            if (!file.exists()) {
//                try {
//                    file.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        return taskScheduler;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        TaskConfig.filePath = filePath;
    }
}
