package com.springboot.YoutubeWeb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

public class GetPropertyValues {

		String result = "";
		InputStream inputStream;
	 
		public String getPropValues() throws IOException {
	 
			try {
				Properties prop = new Properties();
				String propFileName = "configuration.properties";
	 
				inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	 
				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
	 
				Date time = new Date(System.currentTimeMillis());
	 
				// get the property value and print it out
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pwd = prop.getProperty("pwd");
	 
				result = url + ", " + user + ", " + pwd;
				System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
			return result;
		}
}

