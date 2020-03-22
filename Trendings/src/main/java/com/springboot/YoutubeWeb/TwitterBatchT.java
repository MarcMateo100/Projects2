package com.springboot.YoutubeWeb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
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
public class TwitterBatchT {  //Constructor de la clase
	
	public static void main(String[] args) {
	//public static String getTwitterTrends() {
	
	ConfigurationBuilder configBuilder = new ConfigurationBuilder();
	configBuilder.setDebugEnabled(true).setOAuthConsumerKey("fwsR7X3OzKt7QZcthp0asZYq4")
	.setOAuthConsumerSecret("qHL2OirP3wx7gP6UgWyuvZK3AMY253eidNdusL4V4jtKCv963x")
	.setOAuthAccessToken("1433038842-iCadBdcOOvIyVPiWQQ3g0xmIfddN6ttvDVevOAp")
	.setOAuthAccessTokenSecret("UWdt2dS5eRIEDNw4LyDjuW6j586PHuBEi7wm9KwVefd8U");
	TwitterFactory tf = new TwitterFactory(configBuilder.build());
	Twitter twitter = tf.getInstance();
	
	String sourcecode ="";
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
         
        int j=0;
		for (int i=0; i< trends.getTrends().length; i++ ) {
			 Trend trend= trends.getTrends()[i];
             sourcecode +=  trend.getName() + "parapa2" + trend.getTweetVolume() +  "parapa2";
             j++;
	         Query query = new Query( trend.getName() + " min_retweets:1000");
	         QueryResult result = twitter.search(query);
	         String stringResult= result.toString();
	         int intIndex = stringResult.indexOf("expandedURL");
	         if (intIndex>0){
		    	  int beg=intIndex+13;
		    	  int end=intIndex+100;
				  String txt2 = stringResult.substring(beg,end);
				  intIndex = txt2.indexOf(",");
				  String txt3 = txt2.substring(0,intIndex-1);
				  txt3.replace(",", "");
				  sourcecode += txt3 + 	"parapa2";		 
		      }
	         else {
	        	 sourcecode += "No more 500 retweets" + 	"parapa2";	
	         }
	         
	         if(j==10){
	        	 i= trends.getTrends().length;
	         }
        }
		//return sourcecode;
	   // System.out.println(result.getTweets().stream().map(item -> item.getText()).collect(Collectors.toList()));
	 }catch(TwitterException tw) {
		 System.out.println(tw);
	 }  
	 
	//  List<String> list = new ArrayList<String>();
	//  ResultSet rs= null;
		
	  //Connect DB
	  try {			
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
				
				System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
				e.printStackTrace();
				//return null;			
				}		
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
			
		try {						
				String[] parts=null;	
				GetPropertyValues properties = new GetPropertyValues();
				try{
					String url = properties.getPropValues();
					url = url.replaceAll(" ","");
					parts = url.split(",");
				}catch(IOException io) {
					System.out.println("Get Properties Failed!");
				}	
				connection = DriverManager.getConnection(parts[0], parts[1],parts[2]);			
				System.out.println("PostgreSQL Connected!" + connection);
				
		} catch (SQLException e) {			
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				//return null;			
		}
		String queryI="";
		try {			
			Statement sql = connection.createStatement();
			
			queryI = "INSERT INTO TWITTER1H SELECT * FROM TWITTER";
			sql.executeUpdate(queryI);
			
			queryI = "DELETE FROM TWITTER";
			sql.executeUpdate(queryI);
			
			String[] parts = sourcecode.split("parapa2");
			sourcecode=sourcecode.replace("'","");
			sourcecode=sourcecode.replace("}","");
			sourcecode=sourcecode.replace("?","");
			sourcecode=sourcecode.replace("...","");
			for(int i=0;i<30; i++){
				String title= parts[i];
				String url= parts[i+2];
				String retweets= parts[i+1];
				i++;
				i++;
				queryI = "INSERT INTO TWITTER (title,retweets, url,created_on,last_login) VALUES ( '"+title+"','"+ retweets +"','"+url+"',  CURRENT_TIMESTAMP, CURRENT_TIMESTAMP )";
				sql.executeUpdate(queryI);
			}					
				if (connection != null) {			
					sql.close();
			    	System.out.println("Successfully selected");				
				} 
			}catch (SQLException e) {
					System.out.println("Got an exception! "); 
		            System.out.println(e.getMessage());
			} 
	 //return null;
	}
}
