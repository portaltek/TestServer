package org.portalapps.webapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Transactional("secEntityTransactionManager")
public class AdminController {
	@RequestMapping(value="/main")
	public String main(){		
		return "admin/main";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}	
	

}
