package nl.cto.dao;

import nl.cto.entities.CtoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mzwart on 8-12-2016.
 */
@Repository
public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	private EntityManager entityManager;

	@PersistenceContext(unitName="CRApplicationPU", type= PersistenceContextType.EXTENDED)
	public void setEntityManager(EntityManager entityManager) {
		System.out.println("Setting Entity Manager :" + entityManager);
		this.entityManager = entityManager;
	}

	public CtoUser getUserByUsername(String username){
		Query query = this.entityManager.createNamedQuery("CtoUser.getByUsername");
		query.setParameter("username", username);
		List<CtoUser> ctoUsers = query.getResultList();
		if(ctoUsers == null || ctoUsers.isEmpty()){
			logger.warn("None found for username {}", username);
			return null;
		} else if (ctoUsers.size() > 1){
			logger.error("Multiple ctoUsers found for username {}", username);
			return null;
		}
		return ctoUsers.get(0);
	}
}
