package com.springboot.YoutubeWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.services.youtube.model.SearchResult;

@Controller
public class YoutubeWebController {
	
	private SearchYoutube search = new SearchYoutube();
	
	 @GetMapping("/2019")
	    public String youtube2019(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "youtube2019";
	    }
	 
	 @GetMapping("/2018")
	    public String youtube2018(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	      	        		
	    model.addAttribute("name", search.selectVideos());
	        
	    return "youtube2018";
	    }
	 
	  @GetMapping("/greeting")
	    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "greeting";
	    }
	  


}
