package com.springboot.YoutubeWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RSSReadTestList {
	
	    private static final byte POISON = (byte) 0xfc;
	
		//public static void main(String[] args) {
		public static String getGoogleTrendsList() {
						
			ArrayList<URL> ar = new ArrayList<URL>();
			ArrayList<Trend> artr = new ArrayList<Trend>();
			
			try{
				URL rssUrl = new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=US");
			
				ar.add(rssUrl);
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=AR"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=DE"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=IT"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=AU"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=CO"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=MX"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=FR"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=JP"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=RU"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=TR"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=IN"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=BR"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=ID"));
				ar.add(new URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=NG"));
					    		
				for(int j=0; j<ar.size() ;j++) {
					
					URL rssUrl2 = ar.get(j);
					String urls=rssUrl2.toString();
					
		    		BufferedReader in= new BufferedReader(new InputStreamReader(rssUrl2.openStream()));
		    		String line;
		    		boolean tit = true;
		    		boolean pic = true;
		    		boolean titl = true;
		    		boolean url =true;
		    		int i=0;
		    		
		    		
		    		Trend trend = new Trend();    		
		    		
		    		while((line = in.readLine()) !=null && i<5){
		    			if(line.contains("<title>")) {
		    				trend= new Trend();
		    				trend.country= urls.substring(urls.length()-2, urls.length());
		    				if(trend.country.equals("US")) {
		    					trend.country="/images/eua.png";
		    				}
		    				else if(trend.country.equals("FR")) {
		    					trend.country="/images/france.png";
		    				}
		    				else if(trend.country.equals("CO")) {
		    					trend.country="/images/co.png";
		    				}
		    				else if(trend.country.equals("MX")) {
		    					trend.country="/images/mex.png";
		    				}
		    				else if(trend.country.equals("AR")) {
		    					trend.country="/images/argentina.png";
		    				}
		    				else if(trend.country.equals("DE")) {
		    					trend.country="/images/ger.png";
		    				}
		    				else if(trend.country.equals("IT")) {
		    					trend.country="/images/it.png";
		    				}
		    				else if(trend.country.equals("AU")) {
		    					trend.country="/images/aus.png";
		    				}
		    				else if(trend.country.equals("JP")) {
		    					trend.country="/images/jp.png";
		    				}
		    				else if(trend.country.equals("RU")) {
		    					trend.country="/images/ussr.png";
		    				}
		    				else if(trend.country.equals("TR")) {
		    					trend.country="/images/tu.png";
		    				}
		    				else if(trend.country.equals("IN")) {
		    					trend.country="/images/in.png";
		    				}
		    				else if(trend.country.equals("BR")) {
		    					trend.country="/images/br.png";
		    				}
		    				else if(trend.country.equals("ID")) {
		    					trend.country="/images/id.png";
		    				}
		    				else if(trend.country.equals("NG")) {
		    					trend.country="/images/ng.png";
		    				}
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
				    		temp = temp.replaceAll("â€ž", "„"); 	
				    		temp = temp.replaceAll("â€œ", "''"); 
				    		temp = temp.replaceAll("í£", "ã"); 
				    		temp = temp.replaceAll("â€�", "''"); 				    		
				    		temp = temp.replaceAll("Ã¼", "ü"); 
				    		temp = temp.replaceAll("Ã¶", "ö"); 
				    		temp = temp.replaceAll("Ã¤", "ä"); 
				    		temp = temp.replaceAll("Ã", "à"); 
				    		temp = temp.replaceAll("â€¦", "..."); 
				    		temp = temp.replaceAll("â€”", "(");
				    		temp = temp.replaceAll("â€", ""); 
				    		temp = temp.replaceAll("&"+"amp;" + "#39", " "); 	
				    		temp= temp.replaceAll(" "+";", ""); 
		    				if (!temp.equals("Daily Search Trends")){
		    					if(tit) {
			    					tit=false;
				    				trend.title= temp;
		    					}
		    				}
		    			}		    				
		    			else if(line.contains("<ht:approx_traffic>")) {
		    				if(pic && !tit) {
		    					pic=false;
				    			int firstPos = line.indexOf("<ht:approx_traffic>");
					    		String	temp = line.substring(firstPos);
					    		temp = temp.replace("<ht:approx_traffic>", "");
					    		temp = temp.replace("</ht:approx_traffic>", "");
					    		temp = temp.replace(",", "");
					    		int fPos = temp.indexOf("+");
					    		trend.traffic=Integer.parseInt(temp.substring(0, fPos));
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
					    		temp = temp.replaceAll("â€œ", "''"); 
					    		temp = temp.replaceAll("â€�", "''"); 
					    		temp = temp.replaceAll("â€”", "''");
					    		temp = temp.replaceAll("Ã¼", "ü"); 
					    		temp = temp.replaceAll("â€ž", "„"); 	
					    		temp = temp.replaceAll("Ã¶", "ö"); 
					    		temp = temp.replaceAll("Ã¤", "ä"); 
					    		temp = temp.replaceAll("Ã", "à");
					    		temp = temp.replaceAll("à", "í"); 
					    		temp = temp.replaceAll("â€", ""); 
					    		temp = temp.replaceAll("Â", ""); 
					    		temp = temp.replaceAll("&"+"amp;" + "#39", " "); 	
					    		temp= temp.replaceAll(" "+";", ""); 
					    		if(trend.country == "/images/jp.png" || trend.country == "/images/ussr.png" || trend.country == "/images/tu.png" || trend.country == "/images/in.png") {
					    			
					    			 final Charset charset = StandardCharsets.UTF_8;							    	
							    	 final byte[] encoded = temp.getBytes(charset);
							         final ByteBuffer buf = ByteBuffer.allocate(encoded.length + 1);
							         buf.put(encoded).put(POISON);
							         final String decoded = new String(buf.array(), charset);
							    					        
							        //new String(p.longTitle.getBytes("Windows-1252")decoded.getBytes(),"UTF-8")
					    			// final Charset fromCharset = Charset.forName("windows-1252");
					    			// final Charset toCharset = Charset.forName("UTF-8");
					    			// trend.longTitle = new String(temp.getBytes(fromCharset), toCharset);
							        trend.longTitle = new String (decoded.getBytes(),"UTF-8");						         							       
					    		}
					    		else {
					    			trend.longTitle= temp;
					    		}
		    				}
			    		}
		    			else if(line.contains("<ht:news_item_url>")) {
		    				if(url && !titl && !pic && !tit) {
		    					url=false;
				    			int firstPos = line.indexOf("<ht:news_item_url>");
					    		String	temp = line.substring(firstPos);
					    		temp = temp.replace("<ht:news_item_url>", "");
					    		temp = temp.replace("</ht:news_item_url>", "");
					    		trend.url= temp;
				    			i++;
				    			artr.add(trend);
		    				}
			    		}  
		    			if(!tit && !pic && !titl && !url) {
			    			tit = true;
				    		pic = true;
				    		titl = true;
				    		url =true;
		    			}
		    		}		
		    		//System.out.println(strLineApp2);
		    		in.close();
		    		//return strLineApp2;
				}	
				
				//Sort
				for(int i = 0 ; i < artr.size(); i++)
			    {
					for (int j = i+1 ; j < artr.size(); j++) {
					    Trend p = artr.get(i);
					    Trend next =  artr.get(j);
					    if(p.traffic < next.traffic) {
					        // Swap
					    	Trend temp=artr.get(i);
					    	artr.set(i, artr.get(j));
					    	artr.set(j, temp);		    	
					    }
					}
			    }
								
				String strLineApp="";
				
				for (int i = 0 ; i < 10; i++) {
				    Trend p = artr.get(i);
				  //  if(p.country == "/images/jp.png" || p.country == "/images/ussr.png" ) {
				    	
				    //	 final Charset charset = StandardCharsets.UTF_8;
				    	 
				    	
				   // 	  final byte[] encoded = p.longTitle.getBytes(charset);
				     //     final ByteBuffer buf = ByteBuffer.allocate(encoded.length + 1);
				       //   buf.put(encoded).put(POISON);
				         // final String decoded = new String(buf.array(), charset);
				    					        
				        //new String(p.longTitle.getBytes("Windows-1252"),"UTF-8")
				    //	String test = new String (decoded.getBytes(),"UTF-8");
				    	
				    	
				    //	strLineApp =  strLineApp + test + "****" + p.url + "****"+ p.traffic + "****" + p.country + "****" ;
				    //}
				   // else {
				    	strLineApp =  strLineApp + p.longTitle + "****" + p.url + "****"+ p.traffic + "****" + p.country + "****" ;
				    //}
				}				
				
	    		return strLineApp;
	    	}catch(MalformedURLException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}
	    }
		
}
