package com.springboot.YoutubeWeb;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
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
	
	// Query query = new Query("FiestaWithIZONE min_retweets:1000");
	 try{
	  //  QueryResult result = twitter.search(query);
		// ResponseList<Location> locations;
		// locations = twitter.getAvailableTrends();
		// for (Location location : locations) {
          //   System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
         //}
		 
		 Trends trends = twitter.getPlaceTrends(1);
		 //twitter.search("min_retweets:10");
		 //twitter.getPlaceTrends(1);
		 //getWeeklyTrends()
		 //getDailyTrends()
		 //min_retweets

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
