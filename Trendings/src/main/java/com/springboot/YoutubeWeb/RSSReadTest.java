package com.springboot.YoutubeWeb;

import java.io.*;
import java.net.*;

import javax.net.ssl.SSLContext;

public class RSSReadTest {

	    public static void main(String[] args) {
	       /* RSSFeedParser parser = new RSSFeedParser(
	              "http://ep00.epimg.net/rss/elpais/portada.xml");
	        RSSFeed feed = parser.readFeed();
	        System.out.println(feed);
	        for (RSSFeedMessage message : feed.getMessages()) {
	        System.out.println(message);

	        }*/
	    	//System.setProperty("https.protocols", "TLSv1.1");
	    	
	    	try{
	    		URL rssUrl = new URL("https://www.lavanguardia.com/mvc/feed/rss/home");
	    		//https://www.lavanguardia.com/mvc/feed/rss/home
	    		//http://ep00.epimg.net/rss/elpais/portada.xml
	    		BufferedReader in= new BufferedReader(new InputStreamReader(rssUrl.openStream()));
	    		String sourcecode = "";
	    		String line;
	    		while((line = in.readLine()) !=null){
	    			if(line.contains("<title>")) {
	    				int firstPos = line.indexOf("<title>");
	    				String temp = line.substring(firstPos);
	    				temp = temp.replace("<title>", "");
	    				int lastPos = line.indexOf("<title>");
	    				temp = line.substring(lastPos);
	    				sourcecode += temp+"\n";
	    			}
	    		}
	    		System.out.println(sourcecode);
	    		in.close();
	    	}catch(MalformedURLException ioe) {
	    		System.out.println(ioe);
	    	}catch(IOException ioe) {
	    		System.out.println(ioe);
	    	}

	    }
	
}
