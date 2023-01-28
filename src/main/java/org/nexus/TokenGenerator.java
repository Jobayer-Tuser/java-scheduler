package org.nexus;

import java.io.FileReader;
import java.util.Properties;
import java.util.Timer;

public class TokenGenerator {
    public static void main(String[] args) throws Exception {

        FileReader file = new FileReader("/Users/jobayer/Project/Java/cron-scheduler/src/main/resources/config.properties");
        Properties properties = new Properties();
        properties.load(file);
//        System.out.println(properties.getProperty("processName"));

        int interval = Integer.parseInt(properties.getProperty("interval"));
        int runAt = Integer.parseInt(properties.getProperty("runAt"));
        String apiUrl = properties.getProperty("apiUrl");

        Timer timer = new Timer();
        long period = 7 * 60 * 60 * 1000; //7 hours
        timer.schedule(new CronRunner(apiUrl), 0,1000*60);
    }
}