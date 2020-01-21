package com.springboot.YoutubeWeb;

import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.DataConfiguration;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.freaknet.gtrends.api.GoogleConfigurator;
import org.freaknet.gtrends.api.GoogleUtils;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException;

public class GoogleTrendsRequest {
	
	private URIBuilder builder;

	  private static final String OPT_CMPT = "cmpt";
	  private static final String OPT_CONTENT = "content";
	  private static final String OPT_DATE = "date";
	  private static final String OPT_EXPORT = "export";
	  private static final String OPT_GEO = "geo";
	  private static final String OPT_HL = "hl";
	  private static final String OPT_Q = "q";

	  // TODO - move in config.properties
	  // Default parameters for download
	  private final String _cmpt = "q";
	  private final String _content = "1";
	  private final String _export = "1";

	  // Parameters that can be set from the client
	  private String _geo = null;
	  private String _date = null;
	  String _hl = "en-US";
	  private String _q = null;

	  private final String[][] _optsMatrix = {
	    {OPT_CMPT, _cmpt},
	    {OPT_CONTENT, _content},
	    {OPT_EXPORT, _export},
	    {OPT_HL, _hl}};

	  /**
	   *
	   * @param q
	   * @throws org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException
	   */
	  public GoogleTrendsRequest(String q) throws GoogleTrendsRequestException {
	    _q = q;
	  }

	  /**
	   * Build the <code>HttpRequestBase</code> with the provided parameters.
	   *
	   * @return the built request
	   * @throws org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException
	   */
	  public HttpRequestBase build() throws GoogleTrendsRequestException {
	    HttpRequestBase request = null;
	    try {
	      DataConfiguration config = GoogleConfigurator.getConfiguration();
	      builder = new URIBuilder(config.getString("google.trends.url"));
	      setupDefaultsParameters();
	      builder.setParameter(OPT_Q, _q);
	      
	      if (_geo != null){
	        builder.setParameter(OPT_GEO, _geo);
	      }

	      /* Google Trends does not support spaces encoded as '+' hence we need to 
	       * replace all '+' with '%20'. This implementation can be improved: only
	       * '+' in the query parameter should be replaced. However I did not figure
	       * out how to make it in a cleaner way, probably URIBuilder should be 
	       * replaced with something custom
	       */
	      String uriString = builder.build().toString(); //.replaceAll("\\+","%20");
	      request = new HttpGet(uriString);
	      GoogleUtils.setupHttpRequestDefaults(request);
	    } catch (URISyntaxException ex) {
	      throw new GoogleTrendsRequestException(ex);
	    } catch (ConfigurationException ex) {
	      throw new GoogleTrendsRequestException(ex);
	    }

	    return request;
	  }

	  /**
	   * Set a parameter value.
	   *
	   * @param name
	   * @param value
	   */
	  public void setParam(String name, String value) {
	    if (value == null) {
	      return;
	    }
	    builder.setParameter(name, value);
	  }

	  /**
	   * Get a parameter value.
	   *
	   * @param name
	   * @return value
	   */
	  public String getParam(String name) {
	    String value = null;
	    Iterator<NameValuePair> i = builder.getQueryParams().iterator();
	    while (i.hasNext()) {
	      NameValuePair nameValuePair = i.next();
	      if (nameValuePair.getName().equals(name)) {
	        value = nameValuePair.getValue();
	        break;
	      }
	    }
	    return value;
	  }

	  /**
	   * Get the request parameters.
	   *
	   * @return the request parameters
	   */
	  public List<NameValuePair> getQueryParams() {
	    return builder.getQueryParams();
	  }

	  /**
	   * Set the request parameters.
	   *
	   * @param params the request parameters
	   */
	  public void setQueryParams(List<NameValuePair> params) {
	    Iterator<NameValuePair> i = params.iterator();
	    while (i.hasNext()) {
	      NameValuePair p = i.next();
	      builder.setParameter(p.getName(), p.getValue());
	    }
	  }

	  public String getQ(){
	    return _q;
	  }
	  
	  public String getDate() {
	    return _date;
	  }

	  public void setDate(String date) {
	    _date = date;
	  }

	  public String getGeo() {
	    return _geo;
	  }

	  public void setGeo(String geo) {
	    _geo = geo;
	  }

	  private void setupDefaultsParameters() {
	    for (String[] pair : _optsMatrix) {
	      builder.setParameter(pair[0], pair[1]);
	    }
	  }

}
