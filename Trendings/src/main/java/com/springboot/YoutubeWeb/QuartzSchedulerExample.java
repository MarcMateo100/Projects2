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
	                .withIdentity("MyJob", "group1")
	                .build();
	         
	         
	       // Calendar rightNow = Calendar.getInstance();
	       // int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	       // int min = rightNow.get(Calendar.MINUTE);
	         
	       // System.out.println("Current time: " + new Date());
	         
	        // Fire every 2 hours
	        Trigger trigger = TriggerBuilder.newTrigger()
	        .withIdentity("myTrigger", "group1")
	        .startNow()
	        .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0/2 * * ?"))     
	        .build();
	        
	        
	        JobDetail jobDetail2 = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample") 
	                .usingJobData(data)
	                .withIdentity("MyJobYoutube24", "group1")
	                .build();
	        
	        // Fire every 24 hours
	        Trigger trigger2 = TriggerBuilder.newTrigger()
	        .withIdentity("myTrigger", "group1")
	        .startNow()
	        .withSchedule(CronScheduleBuilder.cronSchedule("0 0 23 * * ?"))     
	        .build();
	        
	         
	         
	        // Tell quartz to schedule the job using our trigger
	        scheduler.scheduleJob(jobDetail, trigger);
	        scheduler.scheduleJob(jobDetail2, trigger2);
	        latch.await();
	        System.out.println("All triggers executed. Shutdown scheduler");
	        scheduler.shutdown();
	    }
	     
	    public void countDown() {
	        latch.countDown();
	    }

}
