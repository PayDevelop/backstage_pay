package com.pay.schedule.testJob;

import com.pay.schedule.job.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class NewJob  implements BaseJob {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("new 执行时间：" + new Date());
    }
}
