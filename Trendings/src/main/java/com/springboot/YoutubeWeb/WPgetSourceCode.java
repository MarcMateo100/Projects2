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
			 
			 while ((txt = bs2.readLine()) != null) {
				 String tx ="#comments"+'"'+ " class=\"lnk\" title=\"" + numComments[0];
				 int intIndex = txt.indexOf(tx);
				 if(intIndex>0){
					 int intIndex2 = txt.indexOf("href");
					 int beg=intIndex2+6;
					 int end= 0;
					 if (txt.length()>100){
			    	   end=intIndex2+100;
					 }else {
					   end=intIndex2+70; 
					 }
					 String txt2 = txt.substring(beg,end);
					 intIndex = txt2.indexOf("#comments");
					 String txt3 = "https://www.eldiario.es/" + txt2.substring(0,intIndex);	
					 return txt3;
					//System.out.println(txt3);
				 }
				 
			 }
		return null;	 
			 
		}catch(MalformedURLException ioe) {
			//System.out.println(ioe);
			return null;
		}catch(IOException ioe) {
    		//System.out.println(ioe);
    		return null;
    	}

}
	 //public static void main(String[] args) {
	 public static String getWP4()  {
		
		try {
			URL url = new URL("https://www.elperiodico.com/es/lo-mas-comentado/");
			BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
			String txt;
			while ((txt = bs.readLine()) != null) {
				//let's search comments number-comments
			      int intIndex = txt.indexOf("<span class=\"numpos\">1</span>");
			      if (intIndex>0){
			    	  
			    	  while ((txt = bs.readLine()) != null) {
			    		  intIndex = txt.indexOf("<a href=\"");
					    	if (intIndex>0){
					    	  int beg=intIndex+9;
					    	  int end=intIndex+150;
							  String txt2 = txt.substring(beg,end);
							  intIndex = txt2.indexOf("title=");				  
							  String txt3 = txt2.substring(0,intIndex-2);
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
				 while ((txt = bs2.readLine()) != null) {
					 String tx ="span title=\"Comentarios"+'"'+">" + numComments[0];
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
}
