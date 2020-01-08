package com.springboot.YoutubeWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Controller
public class YoutubeWebController {
	
	private SearchYoutube search = new SearchYoutube();
	
	@GetMapping("/")
    public String index2019(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", search.index2019());
        model.addAttribute("name2", search.index20192());
        model.addAttribute("name3", search.index20193());
        return "index";
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
	      	        		
	    model.addAttribute("name", search.selectVideos2018());
	        
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
	 
	  
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
	    }
	  


}
