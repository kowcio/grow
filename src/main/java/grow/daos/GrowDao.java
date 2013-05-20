package grow.daos;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


import grow.entities.Grow;
import grow.entities.User;

public class GrowDao {

		/**
	 *Save a Grow class  into the user table
	 *
	 * @param  Grow grow  
	 * @return 
	 */
	
	public String saveGrow(Grow grow){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
	   		Session session = fabrykaHibernejta.getNewSessionAnnotations();
			System.out.println("Saving Record");
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(grow);
			tx.commit();
			System.out.println("Grow id = "+grow.getId()+" added !");
			return "OK";
		} catch (Exception e) {
			System.out.println("Cos sie wysypalo - GrowDAO");
			 e.printStackTrace();
			 return "notOK";
		}

	}   	
	
	
	
	/**
	 * 
	 * @return All grows as list.
	 */
	
	
	@SuppressWarnings("unchecked")
	public List<Grow> getAllGrows(){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		List<Grow> growsList = null;
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			growsList = (List<Grow>)session.createQuery("from Grow").list();
		   	System.out.println("GrowsList count = "+growsList.size());	
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - GrowDAO - getAllGrows");
			 e.printStackTrace();
		}
	   
	   	
	   	return growsList;
	}

	/**
	 * Return Grow by ID.
	 * 
	 * @param growId - Grows ID which we wish to load.
	 * @return	Specified Grow
	 */
	
	
	public Grow getGrowByID(int growId){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		Grow grow = Grow.createGrow();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			
			grow = (Grow) session.get(Grow.class, growId);
			
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getGrowByID");
			 e.printStackTrace();
		}
	   
		System.out.println("Pobrano grow, id = "+growId);
	   	return grow;
	}

/**	Update a Grow object in db.
 * 
 * @param grow Grow which we wish to update. Needs to have a specified ID.
 */

	public void saveOrUpdateGrow(Grow grow){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(grow);
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getGrowByID");
			 e.printStackTrace();
		}
	}


	/**	Delete in db a Grow object by given ID.
	 * 
	 * @param Needs to have a specified ID.
	 */

		public void deleteGrow(int id){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				GrowDao grow = new GrowDao();
				Transaction tx = session.beginTransaction();
		   		System.out.println("Before delete");
		   		session.delete(grow.getGrowByID(id));
		   		System.out.println("After delete");
				tx.commit();

		   	} catch (IllegalArgumentException e) {  
		   		System.out.println(" No grow by that id");
				 e.printStackTrace();
	        }  	catch (Exception e) {
				System.out.println("Cos sie wysypalo - DeleteGrowByID");
			}
		}


		
		/**
		 * Get grow by user name - user id 
		 * 
		 */
	
		
		
		public Grow getGrowByUserName(String uname){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
			Grow grow = Grow.createGrow();
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				Transaction tx = session.beginTransaction();
				
//				List<Grow> growsList = (List<Grow>)session.createSQLQuery("from Grow where user_id =" +
//						"(select id from user where login='"+uname+"')").list();
//			   	System.out.println("GrowsList count = "+growsList.size());	

List<User> userlist =  
(List<User>) session.createQuery
("from User where login='"+uname+"'").list();

User user = userlist.get(0);

List<Grow> growsList = 
(List<Grow>)session.createQuery
("from Grow where user_id ="+user.getId()).list(); 

grow = growsList.get(0);

				tx.commit();
		   	} catch (Exception e) {
				System.out.println("Cos sie wysypalo - getGrowByNameUser");
				 e.printStackTrace();
				 grow = new Grow().setDefaultGrow(grow);
				 
			}
		   
			System.out.println("Pobrano grow, id = ");
		   	return grow;
		}
		
	

}
