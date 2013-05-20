package grow.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

/**
 * User Entity class with fields : <br />
 * id, login, passwd, userType, enabled
 * 
 * @author TalentLab1
 *
 */
@Component
//@Scope("session")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private Long id;
	
	@Length(min=3, max=10, message="Login requires 3-10 characters")
	@Pattern(regexp="^[A-Za-z0-9_-]{3,15}$",message="Username must match : A-Za-z, 0-9, _, -, 3-15 chars")
	@Column(unique=true)//check if this or manually handle checking uniqueness in the db
	private String login;
	
	//@Length(min=3, max=10, message="Password requires 3-10 characters")
	@Column
    private String passwd;
	@Column
	//@Size(min=0,max=666,message="0-normal user, 1-mod , 666 - admin")
	private int userType ;
	@Column
    //@Size(min=0,max=2,message="User enabled status from, 0-not activated, 1-mail sended, 2-active")
	private int enabled ;
    
    
	//constructors
    /**
     * Basic constructor with default values.
     * 	 * id = 0 ; <br />
	 * login ="Anonymous"
	 * passwd =""
	 * usertype=0
     */
	public User (){
		id = (long) 0;
		login = "";
		passwd= "";
		userType=0;
		enabled=0;
	}
	/**
	 * Return new User object with default values	: <br />
	 * id = 0 ; <br />
	 * login ="Anonymous"
	 * passwd =""
	 * usertype=0
	 * @return
	 */
	public User getNewBlankUser(){
		return new User();
	}
	
	
	//methods 
	
	/**
	 * Return string info about user - fields provided etc
	 */
	@Override
	public String toString() {
		String str ="User [id=" + id + ", login=" + login + ", passwd=" + passwd
				+ ", userType=" + userType + ", enabled=" + enabled + "]";
		System.out.println("Str = "+str);
		return str;
	}
	
	
	
    //getters setters 

    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
    
    
    
    
     


}