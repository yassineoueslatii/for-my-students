package com.yassine.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
				
		return "login/login";
	}
	@RequestMapping(value="/failedlogin")
	public String failed() {
		return "login/login";
	}
	@RequestMapping(value="/home")
	public String homee() {
		return "article/article";
	}
	@RequestMapping(value="/403/")
	public String dined() {
		return "errors/403";
	}
	@RequestMapping(value="/logout")
	public String dinedd() {
		return "login/login";
	}
	
	
	 
	    @RequestMapping(value = "/username", method = RequestMethod.GET)
	    @ResponseBody
	    public String currentUserName(Authentication authentication) {
	    	
	        return authentication.getName();
	    
	}
	
}
