package grow.config;

import grow.daos.PostDAO;
import grow.entities.Grow;
import grow.entities.Post;
import grow.entities.User;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Class to configure database with basic new data
 * @author TalentLab1
 * 
 *
 */

public class DBConfig {


	/**
	 * Method runned when app is initialized, check 
	 * if (db connect = ok) 									<br />
	 *		 	{		if {check records > 0 } nie dodawaj		<br />
	 * 					else dodaj rekordy						<br />
	 *  		}												<br />
	 *  else    { polacz sie z baza z opcja IFEXISTS=FALSE - automatycznie tworzy baze<br />
	 *  		if {check records > 0 } nie dodawaj				<br />
	 * 					else dodaj rekordy						<br />
	 *  		}												<br />
	 * configured in dispatcher servlet as a bean				<br />
	 * 
	 */
	/*
	 * The PostConstruct annotation is used on a method that needs to be executed after dependency injection
	 *  is done to perform any initialization. This method MUST be invoked before the class is put into service.
	 *  Wniosek - init method to cos innego niz ostConstruct, do post cosntructa trzeba sie odwalac albo go wstrzyknac.
	 */
	//@PostConstruct
	public static void init(){
		
	System.out.println("" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ \n" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ \n" +
			"############   CREATING DATABASE FOR THE INITIAL RUN   ############ " +
			"\n http://forum.springsource.org/archive/index.php/t-29874.html" +
			"\n" );
	
	  
		 boolean noDB = false;
		 //dwa dbloki - brak pomylek z nazwa zmnienncyh
		 if (noDB==false){
		 	//default try to connect todefault database 
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Post.class);
			configuration.addAnnotatedClass(Grow.class);
			configuration.addAnnotatedClass(User.class);
			configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
						configuration.getProperties()).buildServiceRegistry();
	        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        sessionFactory.openSession();
		 
        //try to get any entities cause the db will be created by hibernate
	        
	        PostDAO postdao = new PostDAO();
	        int postNo = 1;
	        try {
				postNo = postdao.getAllPosts().size();
			} catch (Exception e) {
				e.printStackTrace();
				//for checking when null while getting posts
				noDB=true; 
			}
	        
	        if ( postNo == 0 || noDB==true ) {
	        	System.out.println("0 pos w bazie trzeba jakies dodac");
	        	Post post1 = Post.getNewPost("Default Title 1", "Default Value 1");
	        	postdao.savePost(post1);	
	        	Post post2 = Post.getNewPost("Default Title 2", "Default Value 2");
	        	postdao.savePost(post2);	
	        	Post post3 = Post.getNewPost("Default Title 3", "Default Value 3");
	        	postdao.savePost(post3);
	        }else
	        {
	        	System.out.println("Istnieje "+postNo+ " posw bazie");
	        }
	        
	        
	 }//end if noDB == false	
				
	        	
	        if (noDB){
	        			System.out.println(" NO DATABASE or sth like that ... creating new one.");
	        			Configuration configuration = new Configuration();
	        			configuration.addAnnotatedClass(Post.class);
	        			configuration.addAnnotatedClass(Grow.class);
	        			configuration.addAnnotatedClass(User.class);
	        			configuration.configure("hibernatecr8.cfg.xml");
	        	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	        						configuration.getProperties()).buildServiceRegistry();
	        	        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        	        sessionFactory.openSession();				
					
				        
						
				        //adding posts to newly created db
				        
				        PostDAO postdao = new PostDAO();
				   
				        	System.out.println("No posts in DB. need to add some");
				        	Post post1 = Post.getNewPost("Default Title 1", "Default Value 1");
				        	postdao.savePost(post1);	
				        	Post post2 = Post.getNewPost("Default Title 2", "Default Value 2");
				        	postdao.savePost(post2);	
				        	Post post3 = Post.getNewPost("Default Title 3", "Default Value 3");
				        	postdao.savePost(post3);
				     
				        
					
			
			}//end if database none exist
	        
	        
	        
	
	        
	 }//end main
	
	

}
