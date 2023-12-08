package org.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.SQLException;

public class Establecer {
    public void Establecer() throws SQLException {
        CronScheduleBuilder he =   CronScheduleBuilder.cronSchedule("0 0 0/6 1/1 * ? *");
        JobDetail job = JobBuilder.newJob(SendRequest.class).withIdentity("Send").build();
        Trigger trig = TriggerBuilder.newTrigger().withIdentity("aa","bb")
                .withSchedule(he)
                .build();
        try {

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // and start it off
            scheduler.start();
            scheduler.scheduleJob(job, trig);
            System.out.println("Suc");



        } catch (SchedulerException se) {
            System.out.println("Error");

        }

    }

}


