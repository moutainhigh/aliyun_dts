package com.pep.business;

import common.RecordListener;
import common.UserRecord;

/**
 * 描述:
 * 用户表消费者
 *
 * @author zhangfz
 * @create 2019-08-26 16:20
 */
public class YwRecordListener implements RecordListener {
    @Override
    public void consume(UserRecord record) throws Exception {
        MysqlRecordResolver.recordToMessage(record.getRecord());
    }
}
