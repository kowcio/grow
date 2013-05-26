package grow.daos;

import grow.controllers.Utils;
import grow.entities.User;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


/**
 * Class required to salt passwords
 * @author TalentLab1
 *
 */
public class HashMachine {

	final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
	Utils util = new Utils();
	User us = new User();
	
	/**
	 * Method for hashing (md5) with salt for user password
	 * @return
	 */
	
	public String getMd5SaltPass(String salt , String password){
		salt = salt.substring(2, 4);
		return encoder.encodePassword(password, salt);  
	}
	
	/**
	 * Method for hsahing string with md5.
	 * @return
	 */
	
	public String getMd5Pass( String password){
		return encoder.encodePassword(password, null);  
	}

	/**
	 *  Generate the hash with salt for password when registering a new user.
	 *  http://rtimothy.tumblr.com/post/26527448708/spring-3-1-security-and-salting-passwords
	 */
	public String hashThePass_USE_THIS( String pass){
	    StandardPasswordEncoder encoder = new StandardPasswordEncoder();
	    String ep = encoder.encode(pass);
	    System.out.println("Clear—>"+ pass);
	    System.out.println("Encrypted—>"  + ep);

    return ep;  
	}
}
