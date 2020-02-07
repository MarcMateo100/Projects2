/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.springboot.YoutubeWeb;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import java.sql.*;

/**
 * Prints a list of videos based on a search term.
 *
 * @author Jeremy Walker
 */
public class SearchYoutube {

  /** Global instance properties filename. */
  private static String PROPERTIES_FILENAME = "youtube.properties";

  /** Global instance of the HTTP transport. */
  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

  /** Global instance of the JSON factory. */
  private static final JsonFactory JSON_FACTORY = new JacksonFactory();

  /** Global instance of the max number of videos we want returned (50 = upper limit per page). */
  private static final long NUMBER_OF_VIDEOS_RETURNED = 5;

  /** Global instance of Youtube object to make all API requests. */
  private static YouTube youtube;


  /**
   * Initializes YouTube object to search for videos on YouTube (Youtube.Search.List). The program
   * then prints the names and thumbnails of each of the videos (only first 50 videos).
   *
   * @param args command line args.
   */
  public static  List<SearchResult>  search() {
    // Read the developer key from youtube.properties
    Properties properties = new Properties();
    List<SearchResult> searchResultList = null;
    try {
      InputStream in = SearchYoutube.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
      properties.load(in);

    } catch (IOException e) {
      System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
          + " : " + e.getMessage());
      System.exit(1);
    }

    try {
      /*
       * The YouTube object is used to make all API requests. The last argument is required, but
       * because we don't need anything initialized when the HttpRequest is initialized, we override
       * the interface and provide a no-op function.
       */
      youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
        public void initialize(HttpRequest request) throws IOException {}
      }).setApplicationName("youtube-cmdline-search-sample").build();

      // Get query term from user.
     // String queryTerm = getInputQuery();

      YouTube.Search.List search = youtube.search().list("id,snippet");
      /*
       * It is important to set your API key from the Google Developer Console for
       * non-authenticated requests (found under the Credentials tab at this link:
       * console.developers.google.com/). This is good practice and increased your quota.
       */
      String apiKey = properties.getProperty("youtube.apikey");
      search.setKey(apiKey);
      search.setQ("trailer");
      /*
       * We are only searching for videos (not playlists or channels). If we were searching for
       * more, we would add them as a string like this: "video,playlist,channel".
       */
      search.setType("video");
      search.setOrder("viewCount");
      DateTime dt=DateTime.parseRfc3339("2018-01-01T00:00:00-00:00");
      search.setPublishedAfter(dt);
     // search.setLocation("41.3887901,2.1589899");
      //search.setLocation("139.6917100,35.68950002");
      //SEVILLAsearch.setLocation("37.3754865,-6.0250983");
      //search.setLocation("43.4628005,-7.062646");
      //search.setLocationRadius("100km");
      //search.setRelevanceLanguage("es");
      //search.setRegionCode("ES");
      
      /*
       * This method reduces the info returned to only the fields we need and makes calls more
       * efficient.
       */
      search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
      search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
      SearchListResponse searchResponse = search.execute();

      searchResultList = searchResponse.getItems();
      
    //Create URLs      
      for (int i=0; i<NUMBER_OF_VIDEOS_RETURNED; i++) {
    	  
    	  SearchResult result= searchResultList.get(i);
            
    	  ResourceId id1=result.getId();
      
    	  id1.setVideoId(" https://www.youtube.com/watch?v=" + result.getId().getVideoId());
          
    	  result.setId(id1);
       
    	  searchResultList.get(i).setId(id1);
      }
      //End

      if (searchResultList != null) {
       // prettyPrint(searchResultList.iterator(), "trailer");
      }
    } catch (GoogleJsonResponseException e) {
      System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
          + e.getDetails().getMessage());
    } catch (IOException e) {
      System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
    } catch (Throwable t) {
      t.printStackTrace();
    }
    
    return searchResultList;
  }
  
   
  public List<String> select(String query){
	  
	  List<String> list = new ArrayList<String>();
	  ResultSet rs= null;
		
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
				connection = DriverManager.getConnection("jdbc:postgresql://database-1.cvprxg28jof0.eu-west-3.rds.amazonaws.com:5432/postgres", "postgres",
				"PostgresAdmin");
				
				System.out.println("PostgreSQL Connected!" + connection);
				
		} catch (SQLException e) {
				
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				//return null;			
		}
	  
	  //Execute Select
	  try {
			
			Statement sql = connection.createStatement();
			String queryI = query; 
						
				if (connection != null) {			
					System.out.println("Successfully selected" + queryI);
					rs = sql.executeQuery(queryI);
					while (rs.next()) {
						 String em = rs.getString("url");
						 list.add(em);
						 list.add("****");
						 String em2 = rs.getString("title");
						 list.add(em2);
						 list.add("****");
						 String em3 = rs.getString("viewsCount");
						 list.add(em3);	
						 list.add("****");
					}
					sql.close();
			    	System.out.println("Successfully selected");				
				} 
			}catch (SQLException e) {
					System.out.println("Got an exception! "); 
		            System.out.println(e.getMessage());
			}
			     
	  
	  return list;
	  
  }

  
  public List<String> selectVideos2018() {
	
	return select("SELECT * FROM YOUTUBE2018");
}  
  
  public List<String> index2019() {

	 return select("SELECT * FROM YOUTUBE7");		
}  
  
  public List<String> index20192() {

	 return select("SELECT * FROM YOUTUBE30");						
}  
  
 public List<String> index20193() {

	return select("SELECT * FROM YOUTUBE24");						
}   
  
 public List<String> selectVideos2019() {

	 return select("SELECT * FROM YOUTUBE2019");				
}  
  
public List<String> music2019() {

	 return select("SELECT * FROM MUSIC2019");		
}

public List<String> music2018() {

	 return select("SELECT * FROM MUSIC2018");		
}

public List<String> music2017() {

	 return select("SELECT * FROM MUSIC2017");		
}

public List<String> youtube2017() {

	 return select("SELECT * FROM YOUTUBE2017");		
}

public List<String> alltimes() {

	 return select("SELECT * FROM ALLTRAILER");		
}

public List<String> alltimesmusic() {

	 return select("SELECT * FROM ALLMUSIC");		
}

public String mostViewed() {

	return WPgetSourceCode.getWP();		
}

public String getGoogleTrends() {

	return RSSReadTest.getGoogleTrends();		
}

public String getTwitterTrends() {

	return TwitterC.getTwitterTrends();		
}

public String mostViewed2() {

	return WPgetSourceCode.getWP2();		
}

public String mostViewed3() {

	return WPgetSourceCode.getWP3();		
}

public String mostViewed4() {

	return WPgetSourceCode.getWP4();		
}

public String mostViewed5() {

	return WPgetSourceCode.getWP5();		
}
  
}