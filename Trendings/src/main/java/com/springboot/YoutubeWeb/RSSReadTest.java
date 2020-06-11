package com.springboot.YoutubeWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


import org.apache.log4j.Logger;


public class RSSReadTest {
	
	private static final byte POISON = (byte) 0xfc;
	
	final static Logger logger = Logger.getLogger(RSSReadTest.class);

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
	    		while((line = in.readLine()) !=null && i<20){
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
				    		temp = temp.replaceAll("Ã³;", "ó"); 	
				    		temp = temp.replaceAll("Ãº", "ú"); 
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
		
		//public static void main(String[] args) {
		public static String getGoogleTrends(int n) {
			
			if(logger.isDebugEnabled()){
			    logger.debug("This is debug");
			}

	    	try{
	    		URL rssUrl = new URL("http://example.com/");
	    		if (n==1) {
	    			 rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=US");
	    		}
	    		else if (n==2){
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=AR");
	    		}
	    		else if (n==3){
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=DE");
	    		}
	    		else if (n==4){
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=IT");
	    		}
	    		else if (n==5) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=AU");
	    		}
	    		else if (n==6) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=CO");
	    		}
	    		else if (n==7) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=MX");
	    		}
	    		else if (n==8) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=FR");
	    		}    		
	    		else if (n==9) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=JP");
	    		} 
	    		else if (n==10) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=RU");
	    		} 
	    		else if (n==11) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=IN");
	    		} 
	    		else if (n==12) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=TR");
	    		} 
	    		else if (n==13) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=BR");
	    		} 
	    		else if (n==14) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=ID");
	    		} 
	    		else if (n==15) {
	    			rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=NG");
	    		} 
	    		
	    		String urls=rssUrl.toString();
	    		String co = urls.substring(urls.length()-2, urls.length());

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
	    				temp = temp.replaceAll("Ã³", "ó"); 	
			    		temp = temp.replaceAll("Ã�;", "á"); 	
			    		temp = temp.replaceAll("Ã­;", "í"); 
			    		temp = temp.replaceAll("Ãº", "ú"); 
			    		temp = temp.replaceAll("Ã¡", "á"); 
			    		temp = temp.replaceAll("Ã©", "é"); 
			    		temp = temp.replaceAll("Ã±", "ñ"); 	
			    		temp = temp.replaceAll("Ã“", "Ó"); 
			    		temp = temp.replaceAll("&amp;quot;", "''"); 	
			    		temp = temp.replaceAll("â€œ", "''"); 
			    		temp = temp.replaceAll("â€�", "''"); 
			    		temp = temp.replaceAll("Ã¼", "ü"); 
			    		temp = temp.replaceAll("Ã¶", "ö"); 
			    		temp = temp.replaceAll("Ã¤", "ä"); 
			    		temp = temp.replaceAll("Ã", "à"); 
			    		temp = temp.replaceAll("â€¦", "..."); 
			    		temp = temp.replaceAll("â€”", "(");
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
				    		temp = temp.replaceAll("Ã³", "ó"); 	
				    		temp = temp.replaceAll("Ã�;", "á"); 	
				    		temp = temp.replaceAll("Ã­;", "í"); 	
				    		temp = temp.replaceAll("Ãº", "ú"); 
				    		temp = temp.replaceAll("Ã¡", "á"); 
				    		temp = temp.replaceAll("Ã±", "ñ"); 
				    		temp = temp.replaceAll("Ã©", "é"); 
				    		temp = temp.replaceAll("&amp;quot;", "''"); 
				    		temp = temp.replaceAll("&amp;amp;", "&"); 
				    		temp = temp.replaceAll("â€œ", "''"); 
				    		temp = temp.replaceAll("â€�", "''"); 
				    		temp = temp.replaceAll("Ã¼", "ü"); 
				    		temp = temp.replaceAll("Ã¶", "ö"); 
				    		temp = temp.replaceAll("Ã¤", "ä"); 
				    		temp = temp.replaceAll("â€ž", "„"); 	
				    		temp = temp.replaceAll("&amp;lt;i&amp;gt;", ""); 
				    		temp = temp.replaceAll("&lt;b&gt;", "''"); 
				    		if(co=="FR") {
				    		  temp = temp.replaceAll("Ã", "à"); 
				    		}else {
				    		temp = temp.replaceAll("Ã", "í"); 
				    		}
				    		temp = temp.replaceAll("àš", "Ú"); 
				    		temp = temp.replaceAll("Â", ""); 
				    		temp = temp.replaceAll("íª", "ê");
				    		temp = temp.replaceAll("í§", "ç");
				    		temp = temp.replaceAll("í£", "ã");
			
				    		if(co.equals("JP") || co.equals("RU") || co.equals("IN")|| co.equals("TR")) {
				    			 final Charset charset = StandardCharsets.UTF_8;	
						    	 final byte[] encoded = temp.getBytes(charset);
						         final ByteBuffer buf = ByteBuffer.allocate(encoded.length +1);
						         buf.put(encoded).put(POISON);
						         final String decoded = new String(buf.array(), charset);
						    					        
						        //new String(p.longTitle.getBytes("Cp1252"),"UTF-8")
						         temp = new String (decoded.getBytes(),"UTF-8");
						 						         
				    		}
				    	
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
