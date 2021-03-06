package com.pay.schedule.service;

import com.pay.database.dao.BasicDao;
import com.pay.schedule.pojo.dtm.ScheduleExecutionRecordDtm;
import com.pay.schedule.pojo.model.ScheduleExecutionRecord;

public interface ScheduleExecutionRecordService extends BasicDao<ScheduleExecutionRecordDtm>{
    void insertNewExecuteLog(ScheduleExecutionRecord record);
    void saveExecuteLogResult(ScheduleExecutionRecord record);
}
