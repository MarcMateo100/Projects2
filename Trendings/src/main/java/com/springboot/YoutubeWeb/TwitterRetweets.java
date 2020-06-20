package com.springboot.YoutubeWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TwitterRetweets {

	 //public static void main(String[] args) {
	 public static String getTwitterAccount()  {
			
			try {
				
				String txt2="";				
				URL url = new URL("https://en.wikipedia.org/wiki/List_of_most-followed_Twitter_accounts");
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
				String txt;;
				while ((txt = bs.readLine()) != null) {
					
					  int intIndex = txt.indexOf(">@");
				      if (intIndex>0){
				    	  int beg=intIndex+2;
				    	  int intIndex2 = txt.indexOf("</a>");
				    	  if(intIndex2>0) {
				    	  int end=intIndex2;
						      txt2 = txt2 + "****" +  txt.substring(beg,end);	
				    	  }
				    	  else {
				    		  txt2 = txt2 + "****" +  txt.substring(beg,txt.length());
				    	  }
				      }
				}
			return txt2;
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}
	 }
}
