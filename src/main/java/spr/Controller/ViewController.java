package spr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewController {
	
//	@GetMapping("/")
//	public ModelAndView homePage() {
//	    ModelAndView mav = new ModelAndView("home");
//	    return mav;
//	}
	@GetMapping("/")
	public ModelAndView homePage() {
	    ModelAndView mav = new ModelAndView("template"); // Referencing the template.jsp
	    mav.addObject("contentPage", "homepage.jsp"); // Including homepage.jsp dynamically
	    mav.addObject("pageTitle", "Scholarship Management System"); // Setting the page title
	    return mav;
	}


}