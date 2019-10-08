package org.open.india.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class AppRepository {

	@Autowired
	private EntityManager entityManager;

	public <T> void save(T obj) {
		Session session = null;
		try {
			session = getCurrentSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<?> clazz) {
		List<T> result = null;
		Session session = null;
		try {
			session = getCurrentSession();
			session.beginTransaction();
			String filter = "from " + clazz.getSimpleName();
			result = session.createQuery(filter).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, int id) {
		T result = null;
		Session session = null;
		try {
			session = getCurrentSession();
			session.beginTransaction();
			String filter = "from " + clazz.getSimpleName() + " c where id=?1";
			Query<T> filterQuery = session.createQuery(filter);
			filterQuery.setParameter(1, id);
			List<T> list = filterQuery.list();
			if (!list.isEmpty())
				result = list.get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	protected Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

}
