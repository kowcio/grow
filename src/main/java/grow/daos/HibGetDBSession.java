package grow.daos;

import grow.entities.Grow;
import grow.entities.Post;
import grow.entities.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * Class retriving different sessions, sessions factories and so on.
 * @author TalentLab1
 *
 */
public class HibGetDBSession{

	private  SessionFactory sessionFactory;
	private  ServiceRegistry serviceRegistry;
	private  Session session;
	
	/**
	 * Get new session based on XML mappings
	 * @return
	 */
    //get session hibernate 
	public Session getNewSessionXML (){
    	Session session = null;
		try {
			try {
				Configuration cfg = new Configuration()
						//.addResource("User.hbm.xml")
						.configure();//auto hibernate.cfg.xml
				serviceRegistry = new ServiceRegistryBuilder().applySettings(
						cfg.getProperties()).buildServiceRegistry();
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object."+ ex);
				throw new ExceptionInInitializerError(" Something went KABOOOM !!!! \n" + ex);
			}
			session = sessionFactory.openSession();
		} catch (Exception e) {
			System.out.println("Error in opening session => "+e.getMessage());
		} 
		System.out.print("\n\n getNewSession getSessFact = zwrocono sesje "+session.toString());
		return session;
	}
	
	
	
	
    /**
     * Get new session based on Anotations configuration
     * @return
     */
	public Session getNewSessionAnnotations(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Post.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Grow.class);

        config.configure("hibernate.cfg.xml");
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("blogSchema.sql");
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
		return session;
	}

	
    /**
     * Get new session factory object based on Annotations configuration
     * @return
     */
	public SessionFactory getAnnotationsSessionFactory(){
		Configuration config = new Configuration();
        //added annotated classes
		config.addAnnotatedClass(Post.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Grow.class);

        config.configure("hibernate.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
      	return sessionFactory;
		
	}
	
	/**
	 * Get a session with a specified hibernate.cfg.xml file
	 * @param hibcfgxmlFile
	 * @return open session
	 */
	
	public Session getNewSessionAnnotationsWithHibernateCfgXmlSession(String hibcfgxmlFile){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Post.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Grow.class);

        config.configure(hibcfgxmlFile);
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("blogSchema.sql");
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
		return session;
	}
	
	
	
	/**
	 * Get a session factory with a specified hibernate.cfg.xml file 				<br />
	 * hib4nodb.cfg.xml - file with ifexists=false and hbm2ddl create  		<br />
	 * will create DB and table for first run if there is no DB.			<br />
	 * 
	 * @param hibcfgxmlFile
	 * @return open session
	 */
	
	public SessionFactory getAnnotatedSessionFactorysWithSpecificHibCfgXmlFile(String hibcfgxmlFile){
		Configuration config = new Configuration();
		config.addAnnotatedClass(Post.class);
		config.addAnnotatedClass(User.class);
        config.configure(hibcfgxmlFile);
		SchemaExport schema = new SchemaExport(config);
        schema.setOutputFile("blogSchema.sql");//saved in eclipse main folder
        //schema.create(true, false);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	
	
	
	

	//setters getter
	public SessionFactory getSessionFactory() {		return sessionFactory;	}
	public void setSessionFactory(SessionFactory sessionFactory) {		this.sessionFactory = sessionFactory;	}
	public ServiceRegistry getServiceRegistry() {		return serviceRegistry;	}
	public void setServiceRegistry(ServiceRegistry serviceRegistry) {		this.serviceRegistry = serviceRegistry;	}
	public Session getSession() {		return session;	}
	public void setSession(Session session) {		this.session = session;	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	

