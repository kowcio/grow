package grow.user;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;

public abstract class AbstractHibernateDao {

    private final Class<?> entityClass;
    private final SessionFactory sessionFactory;

    public AbstractHibernateDao(
            Class<?> entityClass,
            SessionFactory sessionFactory) {
//!- fajne testowanie>
        Assert.assertNotNull(entityClass);
        Assert.assertNotNull(sessionFactory);

        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    protected Criteria criteria() {
        return currentSession().createCriteria(entityClass);
    }

    protected Query query(String hql) {
        return currentSession().createQuery(hql);
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected List<?> all() {
        return criteria().list();
    }

    protected Object get(Serializable id) {
        return currentSession().get(entityClass, id);
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }
}