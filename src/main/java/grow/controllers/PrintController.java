package grow.controllers;

import grow.daos.GrowDao;
import grow.entities.Grow;
import grow.entities.User;
import grow.pdf.PdfGen;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintController {


	/**
	 * 	MAIN INDEX OF THE SITE 
	 * 
	 * @param user - form from spring security 
	 * @param principal -  form from spring security
	 * @param result 
	 * @param mav 
	 * @return View of the main site.
	 */
	@RequestMapping(value="/print",method= RequestMethod.GET)
	public ModelAndView printChart(
			@ModelAttribute("user") User user,
			@ModelAttribute("grow") Grow grow, 
			Principal principal,
			BindingResult result,
			ModelAndView mav,
			HttpServletRequest request
			)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
		boolean isUserAuth = auth.isAuthenticated();
		
	    	  mav.setViewName("print");
	    	  Grow userGrow = new GrowDao().getGrowByUserName(name);
	    	  //add grow id to session 
	    	  HttpSession session = request.getSession();
	    	  session.setAttribute("growid",userGrow.getId()) ;
	    	  mav.addObject("grow" , userGrow);
	    	  
	    	  
	    	  
	   
	     	return mav;
	} // end main index
	

	
	/**
	Generate a PDF
	 */
	@RequestMapping(value="/printPDF",method= RequestMethod.GET)
	public String qweqwe(
			@ModelAttribute("grow") Grow grow

			
			)
	{
		
PdfGen pg = new PdfGen();
pg.pdfGenJava();

	     	return "print";
	} // end main index
	
	
	
	
	
	
	
	
	
}
