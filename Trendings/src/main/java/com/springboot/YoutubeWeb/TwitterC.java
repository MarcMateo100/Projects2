package com.springboot.YoutubeWeb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import twitter4j.Location;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
/**
*
* @author Marc Mateo
*
*/
public class TwitterC {  //Constructor de la clase
	
	//public static void main(String[] args) {
		public static String getTwitterTrends() {
	
	ConfigurationBuilder configBuilder = new ConfigurationBuilder();
	configBuilder.setDebugEnabled(true).setOAuthConsumerKey("fwsR7X3OzKt7QZcthp0asZYq4")
	.setOAuthConsumerSecret("qHL2OirP3wx7gP6UgWyuvZK3AMY253eidNdusL4V4jtKCv963x")
	.setOAuthAccessToken("1433038842-iCadBdcOOvIyVPiWQQ3g0xmIfddN6ttvDVevOAp")
	.setOAuthAccessTokenSecret("UWdt2dS5eRIEDNw4LyDjuW6j586PHuBEi7wm9KwVefd8U");
	TwitterFactory tf = new TwitterFactory(configBuilder.build());
	Twitter twitter = tf.getInstance();
	
	 //Query query = new Query("trump");

	 
	 try{
	    //QueryResult result = twitter.search(query);
		// ResponseList<Location> locations;
		// locations = twitter.getAvailableTrends();
		// for (Location location : locations) {
          //   System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
         //}
		 
		 Trends trends = twitter.getPlaceTrends(1);
		 //getWeeklyTrends()
		 //getDailyTrends()

         System.out.println("Showing trends for " + trends.getLocation().getName());
         String sourcecode=null;

		 for (Trend trend : trends.getTrends()) {
             sourcecode= sourcecode + String.format("%s (tweet_volume: %d)", trend.getName(), trend.getTweetVolume()) +  "****";
         }
		 return sourcecode;
	   // System.out.println(result.getTweets().stream().map(item -> item.getText()).collect(Collectors.toList()));
	 }catch(TwitterException tw) {
		 System.out.println(tw);
	 }  
	 
	 return null;
	}
}
