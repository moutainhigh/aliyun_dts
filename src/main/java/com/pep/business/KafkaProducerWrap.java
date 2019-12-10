package com.pep.business;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.InputStream;
import java.util.Properties;

/**
 * 描述:
 *
 * @author zhangfz
 * @create 2019-09-03 11:12
 */
public class KafkaProducerWrap {
    public static final String SEPARATOR = "~~__~~";

    public static Producer<String, String> producer;
    static{
//        props.put("bootstrap.servers", "192.168.186.32:9092,192.168.186.33:9092,192.168.186.34:9092");
//        props.put("acks", "all");
//        props.put("retries", 0);
//        props.put("batch.size", 16384);
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        InputStream stream=Bootstrap.class.getResourceAsStream(StaticConstant.YW_KAFKA_PATH);
        Properties prop = new Properties();
        try{
            prop.load(stream);
            stream.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        producer = new KafkaProducer<String, String>(prop);
    }

    public static void send(String value) {
        if (!StringUtils.isEmpty(value) && value.indexOf(KafkaProducerWrap.SEPARATOR) >= 0 ) {
            String[] msgArray = value.split(KafkaProducerWrap.SEPARATOR);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(msgArray[0], msgArray[1]);
            producer.send(record);
        }
    }

    public static void main(String[] args) {
        send("1");
    }
}
