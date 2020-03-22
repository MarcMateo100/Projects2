package com.springboot.YoutubeWeb;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJobYouTube7 implements Job {
	
	 private static int count;
	
	 public void execute(JobExecutionContext jobContext) throws JobExecutionException {
	        System.out.println("--------------------------------------------------------------------");
	        System.out.println("MyJobYoutube start: " + jobContext.getFireTime());
	        JobDetail jobDetail = jobContext.getJobDetail();
	        System.out.println("Example name is: " + jobDetail.getJobDataMap().getString("example"));       
	        System.out.println("MyJobYoutube end: " + jobContext.getJobRunTime() + ", key: " + jobDetail.getKey());
	        System.out.println("MyJobYoutube next scheduled time: " + jobContext.getNextFireTime());
	        System.out.println("--------------------------------------------------------------------");
	        
	        Search7d.main(null);
	         
	        ILatch latch = (ILatch) jobDetail.getJobDataMap().get("latch");
	        latch.countDown();
	        count++;
	        System.out.println("Job count " + count);
	    
	    }

}
