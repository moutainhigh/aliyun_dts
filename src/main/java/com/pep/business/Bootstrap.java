package com.pep.business;

import common.RecordListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static boot.Boot.boot;

public class Bootstrap {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    public static Map<String, RecordListener> buildRecordListener() {
        RecordListener yunwangRecordListener = new YwRecordListener();
        //将YwRecordListener封装成Map返回
        return Collections.singletonMap("mysqlRecordPrinter", yunwangRecordListener);
    }

    /**
     * This demo use  hard coded config. User can modify variable value for test
     * The detailed describe for var in resources/demoConfig
     */
    /*public static Properties getConfigs() {
        Properties properties = new Properties();
        properties.setProperty(USER_NAME, "rdsdt_dtsacct");
        properties.setProperty(PASSWORD_NAME, "szgs2019");
        properties.setProperty(SID_NAME, "dtspdwx820v26prbcp");
        // kafka consumer group general same with sid
        properties.setProperty(GROUP_NAME, "dtspdwx820v26prbcp");
        // topic to consume, partition is 0
        properties.setProperty(KAFKA_TOPIC, "cn_beijing_rm_2zedcqc2oz0298wby_rdsdt_dtsacct");
        // kafka broker url
        properties.setProperty(KAFKA_BROKER_URL_NAME, "dts-cn-beijing.aliyuncs.com:18001");
        // initial checkpoint for first seek(a timestamp to set, eg 1566180200 if you want (Mon Aug 19 10:03:21 CST 2019))
        properties.setProperty(INITIAL_CHECKPOINT_NAME, "1566809724");
        // if force use config checkpoint when start. for checkpoint reset
        properties.setProperty(USE_CONFIG_CHECKPOINT_NAME, "true");
        // use consumer assign or subscribe interface
        // when use subscribe mode, group config is required. kafka consumer group is enabled
        properties.setProperty(SUBSCRIBE_MODE_NAME, "assign");
        return properties;
    }*/

    //将加载了DTS配置文件的Properties对象返回
    public static Properties getConfigs() {
        InputStream streamSCP = Bootstrap.class.getResourceAsStream(StaticConstant.DTS_CONF_PATH);
        Properties propScp = new Properties();
        try {
            propScp.load(streamSCP);
            streamSCP.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propScp;
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            boot(getConfigs(), buildRecordListener());
        } catch (Throwable e) {
            log.error("Bootstrap: failed cause " + e.getMessage(), e);
            throw e;
        } finally {
            System.exit(0);
        }
    }
}
