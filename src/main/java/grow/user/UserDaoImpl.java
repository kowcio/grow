package grow.user;

import grow.entities.User;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class UserDaoImpl extends AbstractHibernateDao implements UserDao {

    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

    public User findById(Long id) {
        return (User) get(id);
    }

    public User findByUsername(String username) {
        return (User) criteria().add(
                Restrictions.eq("username", username)
        ).uniqueResult();
    }

    public List<?> findByEmail(String email) {
        return query("from User u where u.email = :email")
                .setParameter("email", email)
                .list();
    }

    public List<?> findAll() {
        return all();
    }

    public void save(User user) {
    	currentSession().beginTransaction();
        currentSession().saveOrUpdate(user);
        currentSession().getTransaction().commit();
    }

    public void delete(User user) {
        currentSession().delete(user);
    }

	@Override
	public List<?> loadAll() {
		return null;
	}

	@Override
	public Object findById(Serializable id) {
		return null;
	}

	@Override
	public void save(Object entity) {
		
	}

	@Override
	public void remove(Object entity) {
		
	}


}