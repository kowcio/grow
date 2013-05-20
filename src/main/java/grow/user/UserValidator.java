package grow.user;

import grow.daos.HibGetDBSession;
import grow.entities.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 * class validating the input for user class objects
 * @author TalentLab1
 *
 */
public class UserValidator {

	
	
	
	
	@SuppressWarnings("unused")
	public static boolean checkIfUserExistInDB(User user){
		
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
        Session session = fabrykaHibernejta.getNewSessionAnnotations();
		try {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add( Restrictions.like("login", user.getLogin()) );
			criteria.add( Restrictions.like("passwd", user.getPasswd()) );
			List result = criteria.list();
			if (  criteria.list().get(0) != null){
				System.out.println("User exists pass and login match. ");
				return true;
			}
			else {
				
				return false;
			}
		}	catch (Exception e) {
			System.out.println(" Log / Pass validation error ");
			System.out.println("Error = "+e.getMessage());
			return false;

		}
		
		
	}
	
	
	

}
