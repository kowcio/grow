package grow.daos;

import grow.entities.User;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDAO {

		/**
	 *Save a User  class  into the user  table
	 *
	 * @param  User 
	 * @return 
	 */
	
	public String saveUser(User User){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
	   		Session session = fabrykaHibernejta.getNewSessionAnnotations();
	   		Transaction tx = session.beginTransaction();
			User.toString();
			session.save(User);
			tx.commit();
			return "OK";
		} catch (Exception e) {
			System.out.println("Cos sie wysypalo - FigureBoxDAO");
			 e.printStackTrace();
			 return "notOK";
		}
	}   	
	
	
	
	/**
	 * 
	 * @return All Users as list.
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		List<User> UsersList = null;
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			UsersList = (List<User>)session.createQuery("from User").list();
		   	System.out.println("UsersList count = "+UsersList.size());
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - UserDAO - getAllUsers");
			 e.printStackTrace();
		}
	   	return UsersList;
	}

	/**
	 * Return User by ID.
	 * 
	 * @param UserId - Users ID which we wish to load.
	 * @return	Specified User
	 */
	
	
	public User getUserByID(Integer UserId){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		User User =new User();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			User = (User) session.get(User.class, UserId);
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getUserByID");
			 e.printStackTrace();
		}
	 	System.out.println("Pobrano User, id = "+UserId);
	   	return User;
	}

/**	Update in db a User object.
 * 
 * @param User User which we wish to update. Needs to have a specified ID.
 */

	public void updateUser(User User){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(User);
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getUserByID");
			 e.printStackTrace();
		}
		System.out.println("Update User = "+User.toString());
	}



	
	/**	Get user object by name
	 * 
	 * @return User by his name...
	 */
	@SuppressWarnings("rawtypes")
	public User getUserByString(String login){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		User user =new User();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			System.out.println(" Login to get = " + login);
			String sql = "FROM User WHERE login = '"+login+"'";
			
			List<User> results = session.createQuery(sql).list();
			user = (User) results.get(0);
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getUserByStringName");
			 e.printStackTrace();
		}
	   	return user;
	}
	

}
