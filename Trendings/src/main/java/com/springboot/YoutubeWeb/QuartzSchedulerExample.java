package com.springboot.YoutubeWeb;

import java.util.concurrent.CountDownLatch;
import java.util.Calendar;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
 

public class QuartzSchedulerExample implements ILatch {
	
	 private int repeatCount = 3;
	    private CountDownLatch latch = new CountDownLatch(repeatCount + 1);
	    public static void main(String[] args) throws Exception {   
	        QuartzSchedulerExample quartzSchedulerExample = new QuartzSchedulerExample();
	        quartzSchedulerExample.fireJob();
	    }
	     
	    public void fireJob() throws SchedulerException, InterruptedException {
	        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
	        Scheduler scheduler = schedFact.getScheduler();
	        scheduler.start();
	         
	        // define the job and tie it to our HelloJob class
	        JobBuilder jobBuilder = JobBuilder.newJob(MyJob.class);
	        JobDataMap data = new JobDataMap();
	        data.put("latch", this);
	         
	        JobDetail jobDetail = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample") 
	                .usingJobData(data)
	                .withIdentity("myJob", "group1")
	                .build();
	         
	         
	        Calendar rightNow = Calendar.getInstance();
	        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	        int min = rightNow.get(Calendar.MINUTE);
	         
	        System.out.println("Current time: " + new Date());
	         
	        // Fire at curent time + 1 min every day
	        Trigger trigger = TriggerBuilder.newTrigger()
	        .withIdentity("myTrigger", "group1")
	        .startAt(DateBuilder.todayAt(19, 14, 00))
	        .withSchedule(CronScheduleBuilder.cronSchedule("0 " + (min + 1) + " " + hour + " * * ? *"))     
	        .build();
	         
	        // Tell quartz to schedule the job using our trigger
	        scheduler.scheduleJob(jobDetail, trigger);
	        latch.await();
	        System.out.println("All triggers executed. Shutdown scheduler");
	        scheduler.shutdown();
	    }
	     
	    public void countDown() {
	        latch.countDown();
	    }

}
