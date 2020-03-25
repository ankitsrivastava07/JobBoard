package common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import common.DBConnectionService;
import users.entities.StateEntity;

public class StateDao {
public List<StateEntity> getAllStates(long country_id){
		
		Session session=DBConnectionService.openSession();
		Query query=session.createQuery("from StateEntity where country_id=:country_id");
		
		query.setParameter("country_id", country_id);
	
		List<StateEntity> states=query.list();
		
		return states;
	}	
}
