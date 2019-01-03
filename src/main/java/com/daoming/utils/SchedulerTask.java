package com.daoming.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    private int count = 0;

    @Scheduled(cron = "*/60 * * * * ?")
    private void process() {
        LogUtils.d("this is scheduler task runing  " + (count++));
    }
}
