package grow.controllers;


import grow.daos.GrowDao;
import grow.daos.PostDAO;
import grow.daos.UserDAO;
import grow.entities.Grow;
import grow.entities.Post;
import grow.entities.User;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Main controller.
 * @author TalentLab1
 *
 */

@Controller
public class MainController {

	//test 4 nte template
	
	@RequestMapping(value="/index2",method= RequestMethod.GET)
	public ModelAndView indexWiqwethoutLogin(
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
		
	      if (isUserAuth == true ){
	    	  
	    	  mav.setViewName("index2");
	    	  Grow userGrow = new GrowDao().getGrowByUserName(name);
	    	  //add grow id to session 
	    	  HttpSession session = request.getSession();
	    	  session.setAttribute("growid",userGrow.getId()) ;
	      	  mav.addObject("grow" , userGrow);
	      }
	      else {
	    	  Grow gr_basic = Grow.createGrow();
	    	  mav.addObject("grow" , gr_basic);
				System.out.println(" LOADING INDEX  - submitted an INVALID username");
			      mav.setViewName("index2");
	     }
	     	return mav;
	} // end main index
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ADDING / SAVING THE GROW 
	 */
	
	@RequestMapping(value="/growadd",method= RequestMethod.POST)
	public ModelAndView postAddGETForm(
			@ModelAttribute("grow") @Valid Grow grow, 
			BindingResult result,
			ModelAndView mav,
			HttpServletRequest request,
			GrowDao gdao 
			) {
	    try {
			Authentication a = SecurityContextHolder.getContext().getAuthentication();
			UserDetails currentUserDetails = (UserDetails) a.getPrincipal();
			UserDAO udao = new UserDAO();
			User user = udao.getUserByString(	currentUserDetails.getUsername()	);
			grow.setUser_id(user.getId());
			System.out.println("user id =  "+ user.getId()); 
			grow.setGrow_id((int) Math.random());
			System.out.println(" ==  > "+grow.toString() );
			//retrieve grow id 
			HttpSession session = request.getSession();
			int growid = (Integer) session.getAttribute("growid") 	;
			grow.setId(growid);
			gdao.saveOrUpdateGrow(grow);
			mav.setViewName("redirect:/");
		} catch (Exception e) {
			//catch the values from req and make a printable 
			mav.addObject("mainGrow", grow);
			mav.setViewName("print");
			
					
			
			
		}
		
		
		return mav;
	}
	
	
	
	
/**
 * Intercept URL for loggin part in spring security		<br /> 
 * value={"/login","/logout","/loginFAIL"}				<br />
 * basic url after login is the login requested 		<br />
 * @param mav
 * @return
 */
	@RequestMapping(value={"/login","/logout","/loginFAIL"},method= RequestMethod.GET)
	public ModelAndView indexWithLoginFormn(ModelAndView mav) 
	{	//maybe add a msg for each url 
		 Grow gr_basic = Grow.createGrow();
   	  mav.addObject("grow" , gr_basic);
		mav.setViewName("index2");
		return mav;
	}

	
	/**
	 * 	MAIN INDEX OF THE SITE 
	 * 
	 * @param user - form from spring security 
	 * @param principal -  form from spring security
	 * @param result 
	 * @param mav 
	 * @return View of the main site.
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public ModelAndView indexWithoutLogin(
			@ModelAttribute("user") User user,
			@ModelAttribute("grow") Grow grow, 
			Principal principal,
			BindingResult result,
			ModelAndView mav,
			HttpServletRequest request
			)
	{
			
		String name = "no name";
		boolean isUserAuth;
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			name = auth.getName();
			isUserAuth = auth.isAuthenticated();
		} catch (Exception e) {
			isUserAuth = false;
			System.out.println("/ main ctrl no auth for user"+e.getCause() );
		}
		
	     
		
		if (isUserAuth == true ){
	    	  
	    	  mav.setViewName("index2");
	    	  Grow userGrow = new GrowDao().getGrowByUserName(name);
	    	  //add grow id to session 
	    	  HttpSession session = request.getSession();
	    	  session.setAttribute("growid",userGrow.getId()) ;
	    	  mav.addObject("grow" , userGrow);
	      }
	      else {
				System.out.println(" LOADING INDEX  - submitted an INVALID username");
			      mav.setViewName("index2");
	     }
	     	return mav;
	} // end main index
	

	
	
		
	
	/**
	 * Add posts list  "PostsList" to the given ModelAndView object and returns it.
	 * 
	 * @param mav
	 * @return mav   mav.addObject("PostsList" , pl );
	 */
	private static ModelAndView addPostsList(ModelAndView mav){
		List<Post> pl = new PostDAO().getAllPosts();
		if (pl  == null)				mav.addObject("postEMPTY" , "postListIsNull");
		else 							mav.addObject("PostsList" , pl );
		return mav;
	}
	
	
	
	
	

	}
	
	
