package com.springboot.YoutubeWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Controller
public class YoutubeWebController {
	
	private SearchYoutube search = new SearchYoutube();
	
	 @ResponseBody
	 @RequestMapping(value = "/getDateAndTime")
	 public String getDateAndTime(@RequestParam int name) {
		 String a = search.getGoogleTrends(name);   
		 return a;
    }
	 
	@ResponseBody
	@RequestMapping(value = "/twitter1h")
	public List<String>  twitter1h(@RequestParam int name) {   
		List<String> Test= search.getTwitterTrendDash1h();
		return Test;
    }
	 
	@ResponseBody
	@RequestMapping(value = "/twitter")
	public List<String>  twitter(@RequestParam int name) {   
		List<String> Test= search.getTwitterTrendDash();
		return Test;
    }
	
	@GetMapping("/")
    public String index2019(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", search.getGoogleTrends(1));    
		model.addAttribute("name2", search.getTwitterTrendDash());     
		model.addAttribute("name3", search.index2019()); 
		model.addAttribute("name4", search.mostViewedTotal()); 
		model.addAttribute("name5", search.index2019());
	    model.addAttribute("name6", search.index20192());
	    model.addAttribute("name7", search.index20193());
        return "index";
    }
	
	@GetMapping("/youtube")
    public String youtube(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", search.index2019());
        model.addAttribute("name2", search.index20192());
        model.addAttribute("name3", search.index20193());
        return "youtube";
    }
	
	 @GetMapping("/2019")
	    public String youtube2019(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", search.selectVideos2019());
	        return "youtube2019";
	    }
	 
	 @GetMapping("/2018")
	    public String youtube2018(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	      	        		
	    model.addAttribute("name", search.selectVideos2018());
	        
	    return "youtube2018";
	    }
	 
	 @GetMapping("/2017")
	    public String youtube2017(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	      	        		
	    model.addAttribute("name", search.youtube2017());
	        
	    return "youtube2017";
	    }
	 
	  @GetMapping("/music")
	    public String music2019(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", search.music2019());
	        return "music2019";
	    }
	  
	  @GetMapping("/music2018")
	    public String music2018(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", search.music2018());
	        return "music2018";
	    }
	  
	  @GetMapping("/music2017")
	    public String music2017(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", search.music2017());
	        return "music2017";
	    }
	  
	  @GetMapping("/alltimesmusic")
	    public String alltimesmusic(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", search.alltimesmusic());
	        return "alltimesmusic";
	    }
	  
	  @GetMapping("/alltimes")
	    public String alltimes(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", search.alltimes());
	        return "alltimes";
	    }
	  
	  @GetMapping("/storyofrock")
	    public String storyofrock(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	      	        			        
	    return "storyofrock";
	    }
	  
	  @GetMapping("/mostViewed")
	    public String mostviewed(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		  model.addAttribute("name", search.mostViewed());       
		  model.addAttribute("name2", search.mostViewed2());   
	    return "mostViewed";
	    }
	  
	  @GetMapping("/mostViewedNews")
	    public String mostviewedNews(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		  model.addAttribute("name", search.mostViewed3());       
		  model.addAttribute("name2", search.mostViewed4());   
		  model.addAttribute("name3", search.mostViewed5()); 
	    return "mostViewedNews";
	    }
	  
	  @GetMapping("/googleTrends")
	    public String googleTrends(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		  model.addAttribute("name", search.getGoogleTrends());         
	    return "googleTrends";
	    }
	  
	  @GetMapping("/twitter")
	    public String twitter(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		  model.addAttribute("name", search.getTwitterTrends());       
	    return "twitter";
	    }
	 
	 
	  
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
	    }
	  


}
