package dao;

import entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mzwart on 8-12-2016.
 */
public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public User getUserByUsername(String username){
		Query query = this.entityManager.createNamedQuery("User.getByUsername");
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		if(users == null || users.isEmpty()){
			logger.warn("None found for username {}", username);
			return null;
		} else if (users.size() > 1){
			logger.error("Multiple users found for username {}", username);
			return null;
		}
		return users.get(0);
	}
}
