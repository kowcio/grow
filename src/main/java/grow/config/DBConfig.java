package grow.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;

import grow.entities.Post;
import grow.entities.User;
import grow.daos.HashMachine;
import grow.daos.HibGetDBSession;
import grow.daos.PostDAO;
import grow.daos.UserDAO;
/**
 * Class to configure database with basic new data
 * @author TalentLab1
 * 
 *
 */

public class DBConfig implements ServletContextListener {


	String hibfile = "hibernate.cfg.xml"; 
	String hibfilecr8 = "hibernatecr8.cfg.xml";
	/**
	 * Method runned when app is initialized, check 
	 * if (db connect = ok) 									<br />
	 *		 	{		if {check records > 0 } don`t add		<br />
	 * 					else add records						<br />
	 *  		}												<br />
	 *  else    { connect with db with IFEXISTS=FALSE -auto create db<br />
	 *  		if {check records > 0 } don`t add				<br />
	 * 					else add								<br />
	 *  		}												<br />
	 * configured in package db.Config as servlet listener and in web.xml				<br />
	 * 
	 */
	/*
	 * The PostConstruct annotation is used on a method that needs to be executed after dependency injection
	 *  is done to perform any initialization. This method MUST be invoked before the class is put into service.
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
	System.out.println("" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ \n" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ \n" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ " +
			"\n http://forum.springsource.org/archive/index.php/t-29874.html" );
	  
		boolean noDB = false;
		//get basic sessionFact only if db is created 
		HibGetDBSession hibs = new HibGetDBSession();
		SessionFactory sf1 = hibs.getAnnotatedSessionFactorysWithSpecificHibCfgXmlFile(hibfile);
		
        //Get errors if session can actualy get something.
	    
	        PostDAO postdao = new PostDAO();
	        int postNo = 1;
	        
	        try {
				postNo = postdao.getAllPosts().size();
				if (postNo ==0 || postNo==3 ){						//if db is empty add initial posts
					System.out.print("0 posts.");
        			saveInitialDBData(sf1);
				}
			} catch (Exception e) {					//for checking when null while getting posts
				//e.printStackTrace()	;				
				noDB=true; 							//there is no db specified
				System.out.print("No database or session creating error.");
			}

	        /*if database does not exists */
		        
	        if (noDB){
	        			System.out.println(" NO DATABASE or sth like that ... creating new one.");
	        			//create db while trying to connect
	        			SessionFactory sf = hibs.getAnnotatedSessionFactorysWithSpecificHibCfgXmlFile(hibfilecr8);
	        			//add initial posts
	        			saveInitialDBData(sf);
				}//end if database none exist
	 }
	
	
	
	// METHODS 
	
	/**
	 * Save initials posts , users to the database while creating it or inspecting if there is not enough information
	 * inside it			<br />
	 * @param sf - Session Factory for creating sessions inside methods and DAOs.
	 */
	
	public String saveInitialDBData( SessionFactory sf){
			saveSingleInitialPosts(sf);
			saveSingleInitialAdminUser(sf);
	return "OK";
	}
	
	
	
	/**
	 * Savs the initial Posts
	 * @param sf - Session Factory
	 * @return "ok"
	 */
	
	public String saveSingleInitialPosts( SessionFactory sf){
		
    	try {
			System.out.println ("Adding default posts.");
    		PostDAO pdao = new PostDAO();
			Post post1 = Post.getNewPost("Default Title 1", "Default Value 1");
			pdao.savePost(post1,sf.openSession());	
			Post post2 = Post.getNewPost("Default Title 2", "Default Value 2");
			pdao.savePost(post2,sf.openSession());	
			Post post3 = Post.getNewPost("Default Title 3", "Default Value 3");
			pdao.savePost(post3,sf.openSession());
		} catch (Exception e) {
			//e.printStackTrace();
			return "Could not add initial posts - blog.config.DBConfig error.";
		}
	return "OK";
	}
	
	
   	
	/**
	 * Savs the initial Users
	 * @param sf - Session Factory
	 * @return "ok"
	 */
	
	public String saveSingleInitialAdminUser( SessionFactory sf){
		
    	try {
    		System.out.println ("Adding default posts.");
    		UserDAO pdao = new UserDAO();
			HashMachine hm = new HashMachine();

    		User us1 = new User().getCustomUser(0, "admin", hm.hashThePass_USE_THIS("admin"), 666, 1);
    		pdao.saveUser(us1);
    		User us2 = new User().getCustomUser(0, "qwe", hm.hashThePass_USE_THIS("qwe"), 666, 1);
    		pdao.saveUser(us2);
    		User us3 = new User().getCustomUser(0, "asd", hm.hashThePass_USE_THIS("asd"), 0, 1);
    		pdao.saveUser(us3);
    		
		} catch (Exception e) {
			//e.printStackTrace();
			return "Could not add initial users - blog.config.DBConfig error.";
		}
	return "OK";
	}
	
	
	
	


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public String getHibfile() {
		return hibfile;
	}


/**
 * set the hibernate file for DB	<br />
 * hibernate.cfg.xml				<br />
 * testhibernate.cfg.xml			<br />
 * @param hibfile
 */
	public void setHibfile(String hibfile) {
		this.hibfile = hibfile;
	}

	

	
}
