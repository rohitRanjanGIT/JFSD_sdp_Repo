package spr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewController {
	
    @GetMapping("/")
    public ModelAndView homePage() {
        // Creating a ModelAndView object
        ModelAndView mav = new ModelAndView();
        // Setting the view name to the JSP file "home.jsp"
        mav.setViewName("homepage");
        return mav;
    }


}