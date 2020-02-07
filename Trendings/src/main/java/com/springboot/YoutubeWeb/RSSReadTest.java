package com.springboot.YoutubeWeb;

import java.io.*;
import java.net.*;
import java.util.HashMap;

import javax.net.ssl.SSLContext;

public class RSSReadTest {

	    //public static void main(String[] args) {
		public static String getGoogleTrends() {
	    	try{
	    		URL rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=US");
	    		//https://www.lavanguardia.com/mvc/feed/rss/home
	    		//http://ep00.epimg.net/rss/elpais/portada.xml
	    		BufferedReader in= new BufferedReader(new InputStreamReader(rssUrl.openStream()));
	    		String sourcecode="";
	    		String line;
	    		boolean tit = true;
	    		boolean pic = true;
	    		boolean titl = true;
	    		boolean url =true;
	    		int i=0;
	    		HashMap<String, String> GoogleTrends = new HashMap<String, String>();
	    		while((line = in.readLine()) !=null && i<10){
	    			if(line.contains("<title>")) {
	    				int firstPos = line.indexOf("<title>");
	    				String temp = line.substring(firstPos);
	    				temp = temp.replace("<title>", "");
	    				temp = temp.replace("</title>", "");
	    				if (!temp.equals("Daily Search Trends")){
	    					if(tit) {
		    					tit=false;
			    				sourcecode = sourcecode + temp + "****" ;
			    				GoogleTrends.put("Title"+i, temp);
	    					}
	    				}
	    			}
		    				
	    			else if(line.contains("<ht:picture>")) {
	    				if(pic && !tit) {
	    					pic=false;
			    			int firstPos = line.indexOf("<ht:picture>");
				    		String	temp = line.substring(firstPos);
				    		temp = temp.replace("<ht:picture>", "");
				    		temp = temp.replace("</ht:picture>", "");
				    		sourcecode = sourcecode + temp + "****";
			    			GoogleTrends.put("Picture"+i, temp);
	    				}
		    		}
	    			else if(line.contains("<ht:news_item_title>")) {
	    				if(titl && !pic && !tit) {
	    					titl=false;
			    			int firstPos = line.indexOf("<ht:news_item_title>");
				    		String temp = line.substring(firstPos);
				    		temp = temp.replace("<ht:news_item_title>", "");
				    		temp = temp.replace("</ht:news_item_title>", "");
				    		sourcecode = sourcecode + temp + "****";
			    			GoogleTrends.put("TitleL"+i, temp);
	    				}
		    		}
	    			else if(line.contains("<ht:news_item_url>")) {
	    				if(url && !titl && !pic && !tit) {
	    					url=false;
			    			int firstPos = line.indexOf("<ht:news_item_url>");
				    		String	temp = line.substring(firstPos);
				    		temp = temp.replace("<ht:news_item_url>", "");
				    		temp = temp.replace("</ht:news_item_url>", "");
				    		sourcecode = sourcecode + temp + "****";
			    			GoogleTrends.put("Url"+i, temp);
			    			i++;
	    				}
		    		}  
	    			if(!tit && !pic && !titl && !url) {
		    			tit = true;
			    		pic = true;
			    		titl = true;
			    		url =true;
	    			}
	    		}
	    	//	System.out.println(sourcecode);
	    		in.close();
	    		return sourcecode;
	    	}catch(MalformedURLException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}

	    }
	
}
