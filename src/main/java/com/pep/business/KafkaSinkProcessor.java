package com.pep.business;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * 描述:
 *
 * @author zhangfz
 * @create 2019-09-03 9:50
 */
public class KafkaSinkProcessor implements Runnable ,Closeable {
    private static final Logger log = LoggerFactory.getLogger(KafkaSinkProcessor.class);
    public static BlockingQueue<String> toKafkaChannel = new ArrayBlockingQueue<String>(1024);
    private static final ExecutorService pool = new ThreadPoolExecutor(5, 20, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(20), new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        }
    });
    private volatile boolean existed = false;


    @Override
    public void run() {
        try {
            while (!existed) {
                pool.submit(new DoKafkaSinkProcedure());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        existed = true;
    }
}

/**
 * kafka生产者，执行生产动作
 */
class DoKafkaSinkProcedure implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(DoKafkaSinkProcedure.class);
    private String sinkToTopic;

    @Override
    public void run() {
        try {
            String msg = KafkaSinkProcessor.toKafkaChannel.poll(1000L,TimeUnit.MILLISECONDS);
            if (!StringUtils.isEmpty(msg)) {
                KafkaProducerWrap.send(msg);
                log.info(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
