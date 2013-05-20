package grow.controllers;


import grow.daos.HibGetDBSession;
import grow.entities.User;
import grow.user.UserDaoImpl;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;



/** 
 * User register Controller.
 * @author TalentLab1
 *
 */

@Controller
public class UserRegisterController {

	
	@RequestMapping(value="/register/reguser", method = RequestMethod.GET)
	public ModelAndView registerUser(
			@ModelAttribute("user") User newuser, 
			BindingResult result, SessionStatus status)
	{
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/register/reguser");
			mav.addObject("user", newuser);
			newuser.toString();
			System.out.println(" /register/reguser controller for url fired ");
			return mav;
}

	
	
	
	//rejestracja usera 
	@RequestMapping(value="/register/reguser", method = RequestMethod.POST)//link url
	public ModelAndView registerUserPOST(
			@ModelAttribute("user") @Valid User newuser, 
			BindingResult result, SessionStatus status
			) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/register/reguser");//odnosnik do jsp, nie musi sie pokrywac z mapowaniem
		
		
		newuser.toString();
		
		
        if (result.hasErrors()){
		System.out.println(" User add errors ");
		
		result.getAllErrors();
			return mav;
		}
		else{
		
			System.out.println(" User = "+newuser.getLogin() + " / "+newuser.getPasswd());
			mav.addObject("user",newuser);
			
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();

			UserDaoImpl udi = new UserDaoImpl(   fabrykaHibernejta.getAnnotationsSessionFactory()	);
			
			try {
				udi.save(newuser);
    			mav.addObject( "allOK"	,	"All ok ! New user \""+newuser.getLogin()+"\" saved !");

			} 
			catch ( ConstraintViolationException e2 ){
				mav.addObject( "allNotOK"	,	"User name taken.");
				System.out.println("getCause = "+e2.getCause());

			}
			catch (Exception e ) {
				String error = " error saving user";
				
				System.out.println("getCause = "+e.getCause());
				System.out.println("getCause = "+e.getMessage());
				
				System.out.println(e);
				mav.addObject("hibError", error);
				mav.addObject( "allNotOK"	,	"Error while persisting to the DB.");
	}
			

		return mav;
		}
		
	}

}
	
	
	
	