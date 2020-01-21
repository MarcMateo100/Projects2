package com.springboot.YoutubeWeb;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.freaknet.gtrends.api.exceptions.GoogleAuthenticatorException;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsClientException;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException;

public class SearchGoogle { 
	
	public static void main(String[] args) {
		
		HttpClient httpClient = HttpClients.createDefault();
		
		GoogleAuthenticator gaut = new GoogleAuthenticator("","",httpClient);
		
		try {
			if(gaut.authenticate()) {
				
				GoogleTrendsClient gtc = new GoogleTrendsClient(gaut,httpClient);
				
				GoogleTrendsRequest gtr = new GoogleTrendsRequest ("banana");
				
				HttpRequestBase rb = gtr.build();
				
					         
		        /* The default request downloads a CSV available in content */
		        GoogleTrendsCsvParser csvParser = new GoogleTrendsCsvParser(gtc.execute(gtr));
		
		        String section = csvParser.getSectionAsString("Top searches for", true);
		        System.out.println("AAAA"+section);

				
			}
			else {
				System.out.println("Not authenticated");
			}
		}catch (GoogleAuthenticatorException ex) {
			System.out.println("Not authenticated 1" + ex.getMessage());
		    }   catch (GoogleTrendsRequestException ex) {
		    	System.out.println("Not authenticated 2");
		    }
		catch (GoogleTrendsClientException ex) {
			System.out.println("Not authenticated 3");
	    }
		catch (ConfigurationException ex) {
			System.out.println("Not authenticated 3");
		}
			
}
}
