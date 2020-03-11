package com.springboot.YoutubeWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Dashboard {

	    //public static void main(String[] args) {
		public static String getGoogleTrends() {
	    	try{
	    		URL rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=US");
	    		BufferedReader in= new BufferedReader(new InputStreamReader(rssUrl.openStream()));
	    		String sourcecode="";
	    		String line;
	    		boolean tit = true;
	    		boolean pic = true;
	    		boolean titl = true;
	    		boolean url =true;
	    		int i=0;
	    		HashMap<String, String> GoogleTrends = new HashMap<String, String>();
	    		while((line = in.readLine()) !=null && i<5){
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
	    		String strLineApp = sourcecode.replaceAll("&"+"amp;" + "#39", " "); 	
	    		String strLineApp2 = strLineApp.replaceAll(" "+";", ""); 
	    		//System.out.println(strLineApp2);
	    		in.close();
	    		return strLineApp2;
	    	}catch(MalformedURLException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}
	    }	
}
