package grow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 *  UTILIIES CLASS
 */

public class Utils {

	ResultsList rl = new ResultsList();




/**
 * Method for obtaining the user name from security context - created to use with loggers.
 * [0] =  string is user name											<br />
 * [1] = string value of authentication "true" or "false" 				<br />
 * @return
 */


public List<String> getLoggedUsername(){	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = auth.getName(); //get logged in username
	boolean isUserAuth = auth.isAuthenticated();
	System.out.println(" Username =  "+ name + " Auth="+isUserAuth+"  ");
	String isAuth = "false";
	if (isUserAuth) {
		 isAuth = "true";
	}
	else{
		 isAuth = "false";
	}
	
	
	return rl.makeStringResultList(name, isAuth);
	
}

/**NOTE : Don`t use it, need to use logger directly in the class cause it will point to logger and this method name 
 * always when logging in name method and class, just use the username above for information.
 * 
 * Method to login the edit of a post by certain user.
 * @param logger Logger
 * @param logtext String 
 * logger.info("User --"+name+" "+logtext);
 * 

 */
/*@Deprecated
public void logUserAction(Logger logger,String logtext){

	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = auth.getName(); //get logged in username
	boolean isUserAuth = auth.isAuthenticated();
	
		if (isUserAuth)
				logger.info("User "+name+" "+logtext);
	
	    }
    */
    
/**
 * Method for casting Long to INT
 * @param l long
 * @return int l
 */
public int safeLongToInt(long l) {
    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
        throw new IllegalArgumentException
            (l + " cannot be cast to int without changing its value.");
    }
    return (int) l;
}






//getters and setters


public ResultsList getRl() {
	return rl;
}
public void setRl(ResultsList rl) {
	this.rl = rl;
}






private class ResultsList{
	
	List<String> resList = new ArrayList();
	List<?> genericList= new ArrayList(); // Woooo... maybe some day ... how awesome would be that !
	List<Integer> resIntList= new ArrayList();

	
	//constructor 
	ResultsList(){
	}
	
	/**
	 * Return list containing all the Strings arguments, first argument 
	 * will be first in the list 
	 * @param args
	 * @return String lists with the arguments (results)
	 */
    public List<String> makeStringResultList(String... args) {    
        for (String res : args)  
        	resList.add(res);
        	return resList;  
      }  
    
    public List<Integer> makeIntResultList(int... args) {    
        for (int res : args)  
        	resIntList.add(res);
        	return resIntList;  
      }

    //setters getters
	public List<String> getResList() {
		return resList;
	}

	public void setResList(List<String> resList) {
		this.resList = resList;
	}

	public List<Integer> getResIntList() {
		return resIntList;
	}

	public void setResIntList(List<Integer> resIntList) {
		this.resIntList = resIntList;
	}  

	
	
}




}
