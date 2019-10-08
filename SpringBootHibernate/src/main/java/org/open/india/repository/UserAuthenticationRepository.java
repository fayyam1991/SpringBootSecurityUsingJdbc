package org.open.india.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.open.india.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthenticationRepository extends AppRepository {

	@Transactional
	public User getUser(String userName) {
		Session session = null;
		List<User> users= null;
		try {
			session = getCurrentSession();
			//session.beginTransaction();
			String filterQuery = "from User u where name=?1";
			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery(filterQuery);
			query.setParameter(1, userName);
			users = query.list();
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return users.isEmpty()?new User():users.get(0);
	}
}
