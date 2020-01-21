package com.springboot.YoutubeWeb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.freaknet.gtrends.api.GoogleConfigurator;
//import org.freaknet.gtrends.api.GoogleTrendsRequest;
import org.freaknet.gtrends.api.GoogleUtils;
import org.freaknet.gtrends.api.exceptions.GoogleAuthenticatorException;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsClientException;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException;

public class GoogleTrendsClient {
	
	 private final GoogleAuthenticator authenticator;
	  private final HttpClient client;

	  /**
	   *
	   * @param authenticator
	   * @param client
	   */
	  public GoogleTrendsClient(GoogleAuthenticator authenticator, HttpClient client) {
	    this.authenticator = authenticator;
	    this.client = client;
	  }

	  /**
	   * Execute the request.
	   *
	   * @param request
	   * @return content The content of the response
	   * @throws GoogleTrendsClientException
	   */
	  public String execute(GoogleTrendsRequest request) throws GoogleTrendsClientException {
	    String html = null;
	    try {
	      if (!authenticator.isLoggedIn()) {
	        authenticator.authenticate();
	      }
	      Logger.getLogger(GoogleConfigurator.getLoggerPrefix()).log(Level.FINE, "Query: {0}", request.build().toString());

	      HttpRequestBase httpRequest = request.build();
	      HttpResponse response = client.execute(httpRequest);
	      html = GoogleUtils.toString(response.getEntity().getContent());
	      httpRequest.releaseConnection();

	      Pattern p = Pattern.compile(GoogleConfigurator.getConfiguration().getString("google.trends.client.reError"), Pattern.CASE_INSENSITIVE);
	      Matcher matcher = p.matcher(html);
	      if (matcher.find()) {
	        throw new GoogleTrendsClientException("*** You are running too fast man! Looks like you reached your quota limit. Wait a while and slow it down with the '-S' option! *** ");
	      }
	    } catch (GoogleAuthenticatorException ex) {
	      throw new GoogleTrendsClientException(ex);
	    } catch (ClientProtocolException ex) {
	      throw new GoogleTrendsClientException(ex);
	    } catch (IOException ex) {
	      throw new GoogleTrendsClientException(ex);
	    } catch (ConfigurationException ex) {
	      throw new GoogleTrendsClientException(ex);
	    } catch (GoogleTrendsRequestException ex) {
	      throw new GoogleTrendsClientException(ex);
	    }

	    return html;
	  }

}
