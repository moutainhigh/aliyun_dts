package com.pep.canal.example;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Properties;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.pep.business.StaticConstant;

public class SimpleCanalClient extends AbstractCanalClient {

    public SimpleCanalClient(String destination){
        super(destination);
    }

    public static void main(String args[]) {
        // 根据ip，直接创建链接，无HA的功能
        Properties prop = getConfigs();
        String destination = "example";
        String ip = AddressUtils.getHostIp();
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(prop.getProperty("canal.host"), Integer.valueOf(prop.getProperty("canal.port"))),
                prop.getProperty("canal.destination"),
            "",
            "");

        final SimpleCanalClient client = new SimpleCanalClient(destination);
        client.setConnector(connector);
        client.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                try {
                    logger.info("## stop the canal client");
                    client.stop();
                } catch (Throwable e) {
                    logger.warn("##something goes wrong when stopping canal:", e);
                } finally {
                    logger.info("## canal client is down.");
                }
            }

        });
    }

    public static Properties getConfigs() {
        InputStream streamSCP = SimpleCanalClient.class.getResourceAsStream(StaticConstant.CANAL_CONF_PATH);
        Properties propScp = new Properties();
        try {
            propScp.load(streamSCP);
            streamSCP.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propScp;
    }

}
