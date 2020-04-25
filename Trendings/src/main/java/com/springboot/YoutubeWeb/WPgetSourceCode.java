package com.springboot.YoutubeWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class WPgetSourceCode {
	
	  //public static void main(String[] args) {
	 public static String getWP()  {
	
			try {
				URL url = new URL("https://www.marca.com/");
				int[] numComments = new int[200] ;
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
				String txt;
				int i=0;
				while ((txt = bs.readLine()) != null) {
					//let's search comments number-comments
				      int intIndex = txt.indexOf("number-comments");
				      if (intIndex>0){
				    	  int beg=intIndex+17;
				    	  int end=intIndex+23;
						  String txt2 = txt.substring(beg,end);
						  intIndex = txt2.indexOf("<");
						  String txt3 = txt2.substring(0,intIndex);
						  numComments[i]=Integer.parseInt(txt3);
						  i++;						  
				      }
				}
				 Arrays.sort(numComments);
				 int temp;
				 int SIZE = numComments.length;
				 for (int j = 0; j < SIZE/2; j++)
				   {
				      temp = numComments[j];
				      numComments[j] = numComments[SIZE-1 - j];
				      numComments[SIZE-1 - j] = temp;
				   }
				 BufferedReader bs2 = new BufferedReader(new InputStreamReader(url.openStream()));
				 while ((txt = bs2.readLine()) != null) {
					 String tx ="number-comments"+'"'+">" + numComments[0];
					 int intIndex = txt.indexOf(tx);
					 if(intIndex>0){
						 int intIndex2 = txt.indexOf("href");
						 int beg=intIndex2+6;
				    	 int end=intIndex2+156;
						 String txt2 = txt.substring(beg,end);
						 intIndex = txt2.indexOf("html");
						 String txt3 = txt2.substring(0,intIndex+4);	
						 return txt3;
					 }			 
				 }
			return null;	 
				 
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}
	
 }
	 
	public static String getWP2()  {
	//	public static void main(String[] args) {
			
			try {
				URL url = new URL("https://as.com/");
				int[] numComments = new int[200] ;
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
				String txt;
				int i=0;
				while ((txt = bs.readLine()) != null) {
					//let's search comments number-comments
				      int intIndex = txt.indexOf('"'+"comment-n");
				      if (intIndex>0){
				    	  int beg=intIndex+12;
				    	  int end=intIndex+16;
						  String txt2 = txt.substring(beg,end);
						  intIndex = txt2.indexOf("<");
						  String txt3 = txt2.substring(0,intIndex);
						  numComments[i]=Integer.parseInt(txt3);
						  i++;						  
				      }
				}	
				 Arrays.sort(numComments);	
				 int temp;
				 int SIZE = numComments.length;

				 for (int j = 0; j < SIZE/2; j++)
				   {
				      temp = numComments[j];
				      numComments[j] = numComments[SIZE-1 - j];
				      numComments[SIZE-1 - j] = temp;
				   } 
				 BufferedReader bs2 = new BufferedReader(new InputStreamReader(url.openStream()));
				 int u=0;
				 String txt4=null;
				 String txt5=null;
				 while ((txt = bs2.readLine()) != null) {			 			
					 if(u==0) {
						 txt5=txt4;
						 txt4=txt;
						 u++;
					 }
					 else if(u==1) {
						 txt5=txt4;
						 txt4=txt;
						 u++;
					}
					 else if(u==2) {
						 txt5=txt4;
						 txt4=txt;
						 u=0;
					}			 
					 String tx ='"'+"comment-n"+'"'+">" + numComments[0];
					 int intIndex = txt.indexOf(tx);
					 if(intIndex>0){ 
						 int intIndex2 = txt5.indexOf("href");
						 int beg=intIndex2+6;
				    	 int end=intIndex2+156;
						 String txt2 = txt5.substring(beg,end);
						 intIndex = txt2.indexOf("html");
						 String txt3 = txt2.substring(0,intIndex+4);	
						 return txt3;
						 //System.out.println(txt3);
					 }					 
				 }
			return null;	 				 
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}
	 }
	
	// public static void main(String[] args) {
	 public static String getWPTitles()  {
		 		 
		 String txt2="";
	
			try {				
				URL url = new URL("https://elpais.com/");
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
	            boolean flag=true;
	            String txt;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("NewsArticle\",\"headline");
				      if (intIndex>0){
								 String tx ="url";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("url");
									 int beg=intIndex+25;
							    	 int end=intIndex3-3; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€œ", "\"");
									 txt3 = txt3.replaceAll("í³", "ó"); 
									 txt3 = txt3.replaceAll("íº", "ú"); 
									 txt3 = txt3.replaceAll("â€�", "\"");									 
									 txt3 = txt3.replaceAll("Â", "");
									 txt2= "https://elpais.com/" + "*****" + txt3 + "*****" + "<a href=\"https://elpais.com/\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"https://elpais.com\"><img id=\"elpais\" src=\"images/elpais.png\" style=\"width:90px;height:20px;\"></img></a>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }			 	  
				      }
				}
				
				url = new URL("https://www.elmundo.es/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2 class=");
				      if (intIndex>0){
								 String tx ="headline\">";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("/h2>");
									 int beg=intIndex2+10;
							    	 int end=intIndex3-1; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt2= txt2 + "*****" + "https://www.elmundo.es/" + "*****" + txt3 + "*****" + "<a href=\"https://elmundo.com/\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"https://elmundo.com\"><img id=\"elmundo\" src=\"images/elmundo.png\" style=\"width:90px;height:18px;\"></img></a>";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}
				
				url = new URL("https://www.abc.es/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h3 class=");
				      if (intIndex>0){
								// String tx ="\"  >";
				    	         txt= txt.substring(intIndex, txt.length());
								 int intIndex2 = txt.indexOf("html\" title=\"");
								 //int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){									 
									 int intIndex3 = txt.indexOf("  >");
									 int beg=intIndex2+13;
							    	 int end=intIndex3-1; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("í³", "ó"); 	
									 txt3 = txt3.replaceAll("íº", "ú");
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("Â", "");
									 txt2= txt2 + "*****" + "https://www.abc.es/" + "*****" + txt3 + "*****" + "<a href=\"https://abc.es/\" data-toggle=\"tooltip\\\" data-placement=\"top\" title=\"https://abc.es\"><img id=\"abc\" src=\"images/abc.png\" style=\"width:90px;height:20px;\"></img></a>";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}
				
				url = new URL("https://www.milenio.com/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2");
				      if (intIndex>0){
								 //String tx ="\">";
								 int intIndex2 = txt.indexOf("title>");
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("</h2>");
									 int beg=intIndex2+6;
							    	 int end=intIndex3; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt2= txt2 + "*****" + "https://www.milenio.com/" + "*****" + txt3 + "*****" + "<a href=\"https://www.milenio.com/\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"https://www.jornada.com.mx/ultimas\"><img id=\"milenio\" src=\"images/milenio.png\" style=\"width:90px;height:20px;\"></img></a>";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}
				url = new URL("https://www.elcomercio.com/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("class=\"title page-link\"");
				      if (intIndex>0){
								 //String tx ="html\">"
								 int intIndex2 = txt.indexOf("html\">", txt.indexOf("html\">") + 1);
								 //int intIndex2 = txt.indexOf("html\">");
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("</a><div");
									 int beg=intIndex2+6;
							    	 int end=intIndex3; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€˜", "'");	
									 txt3 = txt3.replaceAll("Â", "");
									 txt3 = txt3.replaceAll("â€™", "'"); 										
									 txt2= txt2 + "*****" + "https://www.elcomercio.com/" + "*****" + txt3 + "*****" + "<img id=\"elcomercio\" src=\"images/elcomercio.png\" style=\"width:90px;height:20px;\"></img>";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}
				
				/*url = new URL("https://elcomercio.pe/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("</h3><h2 ");
				      txt= txt.substring(intIndex,txt.length());
				      if (intIndex>0){
								 //String tx ="\">";
								 int intIndex2 = txt.indexOf("/\">");
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("</a></h2>");
									 int beg=intIndex2+7;
							    	 int end=intIndex3; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt2= txt2 + "*****" + "https://elcomercio.pe/" + "*****" + txt3 + "*****" + "title";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}*/
				
				url = new URL("https://www.lavanguardia.com/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
					//let's search comments number-comments
				      int intIndex = txt.indexOf("<h1 class");
				      if (intIndex>0){
							 while ((txt = bs.readLine()) != null && flag) {
								 String tx ="\">";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("</a>");
									 int beg=intIndex2+1;
							    	 int end=intIndex3;
									 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 	
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 
									 txt3 = txt3.replaceAll("íº", "ú"); 
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€œ", "''");
									 txt3 = txt3.replaceAll("â€�", "''");
									 txt3 = txt3.replaceAll("í³", "ó");
									 txt2= txt2 + "*****" + "https://www.lavanguardia.com/" + "*****" + txt3 + "*****" + "<img id=\"lavanguardia\" src=\"images/lavan.png\" style=\"width:90px;height:18px;\"></img>";
									 //System.out.println(txt2);
									 flag=false;
								 }			 
							 }		  
				      }      
				}
				
				url = new URL("https://www.eldiario.es/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("bkn headline typ-1");
				      if (intIndex>0){
				    	  while ((txt = bs.readLine()) != null && flag) {
								 String tx ="title=";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("\">");
									 int beg=intIndex2+7;
							    	 int end=intIndex3; 
							    	 String txt3= txt.substring(beg,end);
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("&aacute;", "á");
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&iacute;", "í"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt2= txt2 + "*****" + "https://www.eldiario.es/" + "*****" + txt3 + "*****" + "<img id=\"eldiario\" src=\"images/eldiario.png\" style=\"width:90px;height:20px;\"></img>";
									 System.out.println(txt2);
									 //return txt2;
									 flag=false;
								 }		
				    	  }
				      } 
				}
				url = new URL("https://www.elperiodico.com/es/");
				flag=true;
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2 class=");
				      if (intIndex>0){
				    	  while ((txt = bs.readLine()) != null && flag) {
								 String tx ="title=";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("\">");
									 int beg=intIndex2+7;
							    	 int end=intIndex3; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("í³", "ó"); 	
									 txt3 = txt3.replaceAll("íº", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");						
									 txt2= txt2 + "*****" + "https://www.elperiodico.com/es/" + "*****" + txt3 + "*****" + "<img id=\"periodico\" src=\"images/periodico.png\" style=\"width:90px;height:20px;\"></img>";
									 System.out.println(txt2);
									 flag=false;
									return txt2;
								 }		
				    	  }
				      }
				}				
			return null;	
				 
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}	
}
	 
 //public static void main(String[] args) {
 public static String getWPTitlesEnglish()  {
		 
		 String txt2="";
	
			try {
				
				URL url = new URL("https://www.theguardian.com/international");
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
				String txt;
				boolean flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("js-headline-text\">");
				      if (intIndex>0){
								 String tx ="</span></span>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+18;
							    	 int end=intIndex2; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt2= "https://www.theguardian.com/international" + "*****" + txt3 + "*****" + "<img id=\"guardian\" src=\"/images/guardian.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("https://www.wsj.com/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("hp_lead_pos1\">");
				      if (intIndex>0){
								 String tx ="</a>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+14;
							    	 int end=intIndex2; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€™", "\'");
									 txt2= txt2 + "*****" + "https://www.wsj.com/" + "*****" + txt3 + "*****" + "<img id=\"youtube\" src=\"/images/wsj.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("https://www.nytimes.com/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("esl82me0\"><span>");
				      if (intIndex>0){
								 String tx ="</span></h2>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+16;
							    	 int end=intIndex2; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt2= txt2 + "*****" + "https://www.nytimes.com/" + "*****" + txt3 + "*****" + "<img id=\"youtube\" src=\"/images/nyt.png\" style=\"width:90px;height:20px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("http://global.chinadaily.com.cn/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("CT_lunbo_txt2\">");
				      if (intIndex>0){
				    	  while ((txt = bs.readLine()) != null && flag) {
								 String tx ="html\"";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int intIndex3 = txt.indexOf("html\">");
									 tx ="</a></p>";
									 intIndex2 = txt.indexOf(tx);
									 if(intIndex2>0){
										 int beg=intIndex3+6;
								    	 int end=intIndex2; 
								    	 String txt3= txt.substring(beg,end);
								    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
										 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
										 txt3 = txt3.replaceAll("&eacute;", "é"); 	
										 txt3 = txt3.replaceAll("Ã±", "ñ");
										 txt3 = txt3.replaceAll("Ã", "í"); 
										 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
										 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
										 txt3 = txt3.replaceAll("&ntilde;", "ñ");
										 txt3 = txt3.replaceAll("&quot;", "''");
										 txt2= txt2 + "*****" + "http://global.chinadaily.com.cn/" + "*****" + txt3 + "*****" + "<img id=\"youtube\" src=\"/images/chinad.png\" style=\"width:90px;height:20px;\"/></img>";
										 System.out.println(txt2);
										 flag=false;
										 //return txt2;
									 }
								}		
						 }
				      }
				}
				url = new URL("https://timesofindia.indiatimes.com");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf(".jpg\" alt=\"");
				      if (intIndex>0){
				    	  String tx ="\"></a>";
						 int intIndex2 = txt.indexOf(tx);
						 if(intIndex2>0){
							 int beg=intIndex+11;
						   	 int end=intIndex2; 
						   	 String txt3= txt.substring(beg,end);
						   	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
							 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
							 txt3 = txt3.replaceAll("&eacute;", "é"); 	
							 txt3 = txt3.replaceAll("Ã±", "ñ");
							 txt3 = txt3.replaceAll("Ã", "í"); 
							 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
							 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
							 txt3 = txt3.replaceAll("&ntilde;", "ñ");
							 txt3 = txt3.replaceAll("&quot;", "''");
							 txt2= txt2 + "*****" + "https://timesofindia.indiatimes.com" + "*****" + txt3 + "*****" + "<img id=\"india\" src=\"/images/thimesI.png\" style=\"width:90px;height:20px;\"/></img>";
							 System.out.println(txt2);
							 flag=false;
							 //return txt2;
						 }	
				      }
				}
				url = new URL("https://www.smh.com.au/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h3 class=");	     
				      if (intIndex>0){
				    	  		 txt= txt.substring(intIndex,txt.length());
								 String tx ="</a></h3>";
								 int intIndex2 = txt.indexOf(tx);
								 int intIndex3 = txt.indexOf("html\">");
								 if(intIndex2>0){
									 int beg=intIndex3+6;
							    	 int end=intIndex2; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt2= txt2 + "*****" + "https://www.smh.com.au/" + "*****" + txt3 + "*****" + "<img id=\"youtube\" src=\"/images/tsmh.png\" style=\"width:90px;height:20px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("http://www.asahi.com/ajw/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("EnTopHeadline\">");
				      if (intIndex>0){
								 int intIndex2 = txt.indexOf("</span>");
								 if(intIndex2>0){
									 int beg=intIndex+15;
							    	 int end=intIndex2; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt2= txt2 + "*****" + "http://www.asahi.com/ajw//" + "*****" + txt3 + "*****" + "<img id=\"youtube\" src=\"/images/asahi.png\" style=\"width:90px;height:20px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}	
				url = new URL("https://www.dawn.com/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2 data-layout=");
				      if (intIndex>0){
				    	  intIndex = txt.indexOf("'>", txt.indexOf("'>") + 1);
							 int beg=intIndex+2;
						   	 int end=txt.length(); 
						   	 String txt3= txt.substring(beg,end);
						   	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
							 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
							 txt3 = txt3.replaceAll("&eacute;", "é"); 	
							 txt3 = txt3.replaceAll("Ã±", "ñ");
							 txt3 = txt3.replaceAll("Ã", "í"); 
							 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
							 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
							 txt3 = txt3.replaceAll("&ntilde;", "ñ");
							 txt3 = txt3.replaceAll("&quot;", "''");
							 txt3 = txt3.replaceAll("â€˜", "'");
							 txt3 = txt3.replaceAll("â€™", "'");
							 txt2= txt2 + "*****" + "https://www.dawn.com/" + "*****" + txt3 + "*****" + "<img id=\"dawn\" src=\"/images/dawn.png\" style=\"width:80px;height:25px;\"/></img>";
							 System.out.println(txt2);
							 flag=false;
							 return txt2;
				      }
				}
				//Zaman (Turkey)
			return null;	
				 
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}	
}
 
 //public static void main(String[] args) {
public static String getWPTitlesFrench()  {
		 
		 String txt2="";
	
			try {
				
				URL url = new URL("https://www.lemonde.fr");
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
				String txt;
				boolean flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("\"article__title-label\">");
				      if (intIndex>0){
								 String tx ="</span> </h1>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+23;
							    	 int end=intIndex2; 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt2= "https://www.lemonde.fr/" + "*****" + txt3 + "*****" + "<img id=\"lemonde\" src=\"/images/lemonde.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("https://www.lefigaro.fr/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h1 class");
				      if (intIndex>0){
								 String tx ="</h1></a>";
								 int intIndex2 = txt.indexOf(tx);
								 txt= txt.substring(intIndex, intIndex2);
								 tx ="\">";
								 int intIndex3 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex3+2;
							    	 int end=txt.length(); 
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("Â", "");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt2= txt2 + "*****" + "https://www.lefigaro.fr/" + "*****" + txt3 + "*****" + "<img id=\"lefigaro\" src=\"/images/lefigaro.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
								 }		
				      }
				}
				url = new URL("http://www.leparisien.fr/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2 class=\"story-headline\">");
				      if (intIndex>0){
								 String tx ="</h2><span";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+27;
							    	 int end=intIndex2;
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("í§", "ç");									 
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("Â", "");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt2= txt2 + "*****" + "http://www.leparisien.fr/" + "*****" + txt3 + "*****" + "<img id=\"parisien\" src=\"/images/parisien.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("http://www.francesoir.fr/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2>");
				      if (intIndex>0){
								 String tx ="</h2></a>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+4;
							    	 int end=intIndex2;
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt3 = txt3.replaceAll("í‰", "E");
									 txt3 = txt3.replaceAll("â€", "...");
									 txt2= txt2 + "*****" + "http://www.francesoir.fr/" + "*****" + txt3 + "*****" + "<img id=\"francese\" src=\"/images/francese.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("https://www.liberation.fr/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h2>");
				      if (intIndex>0){
								 String tx ="</h2>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+4;
							    	 int end=intIndex2;
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("í©", "ê");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt3 = txt3.replaceAll("Â´", "");
									 txt2= txt2 + "*****" + "https://www.liberation.fr/" + "*****" + txt3 + "*****" + "<img id=\"liberation\" src=\"/images/liberation.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 //return txt2;
								 }		
				      }
				}
				url = new URL("http://aujourdhui.ma/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h4>");
				      if (intIndex>0){
								 String tx ="</a></h4>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 tx ="bookmark\">";
									 int intIndex3 = txt.indexOf(tx);
									 int beg=intIndex3+10;
							    	 int end=intIndex2;
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt2= txt2 + "*****" + "http://aujourdhui.ma/" + "*****" + txt3 + "*****" + "<img id=\"auj\" src=\"/images/auj.png\" style=\"width:90px;height:20px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;								
								 }		
				      }
				}
				url = new URL("http://www.liberte-algerie.com/");
				bs = new BufferedReader(new InputStreamReader(url.openStream()));
				flag=true;
				while ((txt = bs.readLine()) != null && flag) {
				      int intIndex = txt.indexOf("<h1>");
				      if (intIndex>0){
								 String tx ="</h1>";
								 int intIndex2 = txt.indexOf(tx);
								 if(intIndex2>0){
									 int beg=intIndex+4;
							    	 int end=intIndex2;
							    	 String txt3= txt.substring(beg,end);
							    	 txt3 = txt3.replaceAll("Ã¡", "á"); 	
									 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
									 txt3 = txt3.replaceAll("&eacute;", "é"); 	
									 txt3 = txt3.replaceAll("Ã±", "ñ");
									 txt3 = txt3.replaceAll("Ã", "í"); 
									 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
									 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
									 txt3 = txt3.replaceAll("&ntilde;", "ñ");
									 txt3 = txt3.replaceAll("&quot;", "''");
									 txt3 = txt3.replaceAll("â€˜", "'");
									 txt3 = txt3.replaceAll("â€™", "'");
									 txt3 = txt3.replaceAll("í©", "é");
									 txt3 = txt3.replaceAll("í¨", "è");
									 txt3 = txt3.replaceAll("í´", "ô");
									 txt3 = txt3.replaceAll("â€œ", "''");	
									 txt3 = txt3.replaceAll("íª", "ê");
									 txt2= txt2 + "*****" + "http://www.liberte-algerie.com/" + "*****" + txt3 + "*****" + "<img id=\"liberte\" src=\"/images/liberte.png\" style=\"width:90px;height:17px;\"/></img>";
									 System.out.println(txt2);
									 flag=false;
									 return txt2;
								 }		
				      }
				}

			return null;	
				 
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}	
}
	 
	 
	
	//public static void main(String[] args) {
	public static String getWPTotal(){
		try {
			URL url = new URL("https://www.eldiario.es/");
			int[] numComments = new int[200] ;
			BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
			String txt;
			int i=0;
			while ((txt = bs.readLine()) != null) {
				//let's search comments number-comments
			      int intIndex = txt.indexOf("#comments");
			      if (intIndex>0){
			    	  int beg=intIndex+30;
			    	  int end=intIndex+35;
					  String txt2 = txt.substring(beg,end);
					  intIndex = txt2.indexOf(" c");
					  String txt3 = txt2.substring(0,intIndex);
					  numComments[i]=Integer.parseInt(txt3);
					  i++;						  
			      }
			}
			 Arrays.sort(numComments);	 		
			 int temp;
			 int SIZE = numComments.length;
			 for (int j = 0; j < SIZE/2; j++)
			 {
			  temp = numComments[j];
			  numComments[j] = numComments[SIZE-1 - j];
			  numComments[SIZE-1 - j] = temp;
			 }	 
			 BufferedReader bs2 = new BufferedReader(new InputStreamReader(url.openStream()));
			 String txt3="";
			 while ((txt = bs2.readLine()) != null) { 
				 int intIndex2 = txt.indexOf("html\" title");
				 if(intIndex2>0){
					 int beg2=intIndex2+7;
					 String txt22 = txt.substring(beg2,txt.length());
					 intIndex2 = txt22.indexOf(">");
					 if(intIndex2>0){
						 txt3 = txt22.substring(6,intIndex2);	
						 txt3 = txt3.replaceAll("&aacute;", "á"); 	
						 txt3 = txt3.replaceAll("&Aacute;", "Á"); 	
						 txt3 = txt3.replaceAll("&eacute;", "é"); 	
						 txt3 = txt3.replaceAll("&iacute;", "í"); 	
						 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
						 txt3 = txt3.replaceAll("&uacute;", "ú"); 	
						 txt3 = txt3.replaceAll("&ntilde;", "ñ");
						 txt3 = txt3.replaceAll("í±", "ñ");
						 txt3 = txt3.replaceAll("&quot;", "''");
					 }
				 }
				 String tx ="#comments"+'"'+ " class=\"lnk\" title=\"" + numComments[0];
				 int intIndex = txt.indexOf(tx);
				 if(intIndex>0){
					 intIndex = txt.indexOf("href");
					 int beg=intIndex+6;
					 int end= 0;
					 String txt2 = txt.substring(beg,txt.length());
					 intIndex = txt2.indexOf("#comments");
					 txt3 = "https://www.eldiario.es/" + txt2.substring(0,intIndex) + "*****" + txt3 + "*****"  + numComments[0] ;						
					//Next
					 try {
							url = new URL("https://www.elmundo.es/");
							numComments = new int[200] ;
							bs = new BufferedReader(new InputStreamReader(url.openStream()));
							i=0;
							while ((txt = bs.readLine()) != null) {
								//let's search comments number-comments
							      intIndex = txt.indexOf("ue-c-cover-content__comments");
							      if (intIndex>0){
							    	  beg=intIndex+56;
							    	  end=intIndex+65;
									  txt2 = txt.substring(beg,end);
									  intIndex = txt2.indexOf("<s");
									  String txt33 = txt2.substring(0,intIndex);
									  numComments[i]=Integer.parseInt(txt33);
									  i++;						  
							      }
							}				
							 Arrays.sort(numComments);			 			
							 int temp2;
							 SIZE = numComments.length;
							 for (int j = 0; j < SIZE/2; j++)
							   {
							      temp2 = numComments[j];
							      numComments[j] = numComments[SIZE-1 - j];
							      numComments[SIZE-1 - j] = temp2;
							   }
							 String txt22="";
							 bs2 = new BufferedReader(new InputStreamReader(url.openStream())); 											
							 while ((txt = bs2.readLine()) != null) {
								 //first fetch name
								 intIndex2 = txt.indexOf("h2 class="+'"'+"ue-c-cover-content__headline");
								 if(intIndex2>0){
									 int beg2=intIndex2+40;
									 int intIndex3 = txt.indexOf("</h2></a></header>");
									 txt22 = txt.substring(beg2,intIndex3);
									 txt22 = txt22.replaceAll("&aacute;", "á"); 
									 txt22 = txt22.replaceAll("&Aacute;", "Á"); 	
									 txt22 = txt22.replaceAll("&eacute;", "é"); 	
									 txt22 = txt22.replaceAll("&iacute;", "í"); 	
									 txt22 = txt22.replaceAll("&oacute;", "ó"); 	
									 txt22 = txt22.replaceAll("&uacute;", "ú"); 	
									 txt22 = txt22.replaceAll("&ntilde;", "ñ");
									 txt22 = txt22.replaceAll("í±", "ñ");
									 txt22 = txt22.replaceAll("&quot;", "''");
								 }
								 //second comments
								  tx ="span title="+'"'+ "Comentarios"+'"'+">" + numComments[0];
								  intIndex = txt.indexOf(tx);
								  if(intIndex>0){
									 intIndex2 = txt.indexOf("href");
									 beg=intIndex2+6;
								   	 end=intIndex2+156;
									 txt2 = txt.substring(beg,end);
									 intIndex = txt2.indexOf("html");
									 txt3 = txt3 + "*****" + txt2.substring(0,intIndex+4);									
								     txt3 = txt3 + "*****" + txt22 + "*****" + numComments[0];
									    // System.out.println(txt3);								
								    	//Next
								    	 url = new URL("https://www.elperiodico.com/es/lo-mas-comentado/");
											bs = new BufferedReader(new InputStreamReader(url.openStream()));
											while ((txt = bs.readLine()) != null) {
												//let's search comments number-comments
												intIndex = txt.indexOf("<span class=\"numpos\">1</span>");
											      if (intIndex>0){
											    	  while ((txt = bs.readLine()) != null) {
											    		  intIndex = txt.indexOf("<a href=\"");
													    	if (intIndex>0){
													    	  beg=intIndex+9;
															  txt2 = txt.substring(beg,txt.length());
															  intIndex2 = txt2.indexOf("title=");
															  txt3 = txt3 + "*****" + txt2.substring(0,intIndex2-2);
															  int intIndex3 = txt2.indexOf('"'+">");	
															  String tempo= txt2.substring(intIndex3+2,txt2.length()-4);
															  tempo = tempo.replaceAll("&aacute;", "á"); 	
															  tempo = tempo.replaceAll("&Aacute;", "Á"); 
															  tempo = tempo.replaceAll("&eacute;", "é"); 	
															  tempo = tempo.replaceAll("&iacute;", "í"); 	
															  tempo = tempo.replaceAll("&oacute;", "ó"); 
															  tempo = tempo.replaceAll("&quot;", "''");
															  tempo = tempo.replaceAll("Ã³", "ó");
															  tempo = tempo.replaceAll("Ã", "í"); 
															  tempo = tempo.replaceAll("&ntilde;", "ñ");
															  tempo = tempo.replaceAll("í±", "ñ");
															  txt3 = txt3 + "*****" + tempo;
															  txt3 = txt3 + "*****most commented";
															  //System.out.println(txt3);
															  return txt3;
											    		  }
											    	  }
											      }
											}		
									 }
								 
							 }
						return null;					 
						}catch(MalformedURLException ioe) {
							System.out.println(ioe);
						return null;
						}catch(IOException ioe) {
				    		System.out.println(ioe);
				    	return null;
				    	}	
				 }			 
			 }
		return null;	 	 
		}catch(MalformedURLException ioe) {
			System.out.println(ioe);
		return null;
		}catch(IOException ioe) {
    		System.out.println(ioe);
    	return null;
    	}	
	}
	
	//public static void main(String[] args) {
	public static String getWP3()  {
		
		try {
			URL url = new URL("https://www.eldiario.es/");
			int[] numComments = new int[200] ;
			BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
			String txt;
			int i=0;
			while ((txt = bs.readLine()) != null) {
				//let's search comments number-comments
			      int intIndex = txt.indexOf("#comments");
			      if (intIndex>0){
			    	  int beg=intIndex+30;
			    	  int end=intIndex+35;
					  String txt2 = txt.substring(beg,end);
					  intIndex = txt2.indexOf(" c");
					  String txt3 = txt2.substring(0,intIndex);
					  numComments[i]=Integer.parseInt(txt3);
					  i++;						  
			      }
			}
			
			 Arrays.sort(numComments);	 		
			 int temp;
			 int SIZE = numComments.length;

			 for (int j = 0; j < SIZE/2; j++)
			   {
			      temp = numComments[j];
			      numComments[j] = numComments[SIZE-1 - j];
			      numComments[SIZE-1 - j] = temp;
			   }
			 
			 BufferedReader bs2 = new BufferedReader(new InputStreamReader(url.openStream()));
			 String txt3="";
			 
			 while ((txt = bs2.readLine()) != null) {
				 
				 int intIndex2 = txt.indexOf("html\" title");
				 if(intIndex2>0){
					 int beg2=intIndex2+7;
					 String txt22 = txt.substring(beg2,txt.length());
					 intIndex2 = txt22.indexOf(">");
					 if(intIndex2>0){
						 txt3 = txt22.substring(6,intIndex2);	
						 txt3 = txt3.replaceAll("&aacute;", "á"); 	
						 txt3 = txt3.replaceAll("&eacute;", "é"); 	
						 txt3 = txt3.replaceAll("&iacute;", "í"); 	
						 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
						 txt3 = txt3.replaceAll("&uacute;", "ú"); 			    	
					 }
				 }
				 String tx ="#comments"+'"'+ " class=\"lnk\" title=\"" + numComments[0];
				 int intIndex = txt.indexOf(tx);
				 if(intIndex>0){
					 intIndex = txt.indexOf("href");
					 int beg=intIndex+6;
					 int end= 0;
					 if (txt.length()>120){
			    	   end=intIndex+120;
					 }else {
					   end=intIndex+70; 
					 }
					 String txt2 = txt.substring(beg,end);
					 intIndex = txt2.indexOf("#comments");
					 txt3 = txt3 + "*****https://www.eldiario.es/" + txt2.substring(0,intIndex) + "*****" + numComments[0] ;						
					 return txt3;
					//System.out.println(txt3);
				 }			 
			 }
		return null;	 
			 
		}catch(MalformedURLException ioe) {
			System.out.println(ioe);
		    return null;
		}catch(IOException ioe) {
    		System.out.println(ioe);
    		return null;
    	}

}
	 //public static void main(String[] args) {
	 public static String getWP4()  {
		
		try {
			URL url = new URL("https://www.elperiodico.com/es/lo-mas-comentado/");
			BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
			String txt;
			String txt3="";
			while ((txt = bs.readLine()) != null) {
				//let's search comments number-comments
				
				 int intIndex2 = txt.indexOf("html\" title");
				 if(intIndex2>0){
					 int beg2=intIndex2+7;
					 String txt22 = txt.substring(beg2,txt.length());
					 intIndex2 = txt22.indexOf(">");
					 if(intIndex2>0){
						 txt3 = txt22.substring(6,intIndex2);	
						 txt3 = txt3.replaceAll("&aacute;", "á"); 	
						 txt3 = txt3.replaceAll("&eacute;", "é"); 	
						 txt3 = txt3.replaceAll("&iacute;", "í"); 	
						 txt3 = txt3.replaceAll("&oacute;", "ó"); 	
						 txt3 = txt3.replaceAll("&uacute;", "ú"); 				    	
					 }
				 }
				
			      int intIndex = txt.indexOf("<span class=\"numpos\">1</span>");
			      if (intIndex>0){
			    	  
			    	  while ((txt = bs.readLine()) != null) {
			    		  intIndex = txt.indexOf("<a href=\"");
					    	if (intIndex>0){
					    	  int beg=intIndex+9;
					    	  int end=intIndex+150;
							  String txt2 = txt.substring(beg,end);
							  intIndex = txt2.indexOf("title=");				  
							  txt3 = txt2.substring(0,intIndex-2);
							 //System.out.println(txt3);
							  return txt3;
			    		  }
			    	  }
			      }
			}		
		return null;	 
			 
		}catch(MalformedURLException ioe) {
			System.out.println(ioe);
			return null;
		}catch(IOException ioe) {
    		System.out.println(ioe);
    	    return null;
    	}
	}

	 //public static void main(String[] args) {
	   public static String getWP5()  {
			try {
				URL url = new URL("https://www.elmundo.es/");
				int[] numComments = new int[200] ;
				BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
				String txt;
				int i=0;
				while ((txt = bs.readLine()) != null) {
					//let's search comments number-comments
				      int intIndex = txt.indexOf("ue-c-cover-content__comments");
				      if (intIndex>0){
				    	  int beg=intIndex+56;
				    	  int end=intIndex+65;
						  String txt2 = txt.substring(beg,end);
						  intIndex = txt2.indexOf("<s");
						  String txt3 = txt2.substring(0,intIndex);
						  numComments[i]=Integer.parseInt(txt3);
						  i++;						  
				      }
				}				
				 Arrays.sort(numComments);			 			
				 int temp;
				 int SIZE = numComments.length;
				 for (int j = 0; j < SIZE/2; j++)
				   {
				      temp = numComments[j];
				      numComments[j] = numComments[SIZE-1 - j];
				      numComments[SIZE-1 - j] = temp;
				   }
				 
				 BufferedReader bs2 = new BufferedReader(new InputStreamReader(url.openStream()));
				 String txt3="";
								
				 while ((txt = bs2.readLine()) != null) {
					 String tx ="span title=\"Comentarios"+'"'+">" + numComments[0];
					 int intIndex = txt.indexOf(tx);
					 if(intIndex>0){
						 int intIndex2 = txt.indexOf("href");
						 int beg=intIndex2+6;
				    	 int end=intIndex2+156;
						 String txt2 = txt.substring(beg,end);
						 intIndex = txt2.indexOf("html");
						 txt3 = txt2.substring(0,intIndex+4);			 
					 }	
					 
					 int intIndex2 = txt.indexOf("ue-c-cover-content__standfirst");
					 if(intIndex2>0){
						 int beg2=intIndex2+7;
						 String txt22 = txt.substring(beg2,txt.length());
						 intIndex2 = txt22.indexOf("</p>");
						 if(intIndex2>0){
							 txt22 = txt22.substring(25,intIndex2);	
							 txt22 = txt22.replaceAll("&aacute;", "á"); 	
							 txt22 = txt22.replaceAll("&eacute;", "é"); 	
							 txt22 = txt22.replaceAll("&iacute;", "í"); 	
							 txt22 = txt22.replaceAll("&oacute;", "ó"); 	
							 txt22 = txt22.replaceAll("&uacute;", "ú"); 	
					    	 txt3 = txt22 + "*****" + txt3 + "*****" + numComments[0];
					    	 System.out.println(txt3);
					    	 return txt3;
						 }
					 }
				 }
			return null;					 
			}catch(MalformedURLException ioe) {
				System.out.println(ioe);
				return null;
			}catch(IOException ioe) {
	    		System.out.println(ioe);
	    		return null;
	    	}	
 }
}
