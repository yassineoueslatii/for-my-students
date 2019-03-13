package com.yassine.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {
	@RequestMapping(value="/commandev")
	public String indexPage() {
		return "commande";
	}
	


}
