package users.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.DBConnectionService;
import users.dto.UserDto;
import users.entities.CountryEntity;
import users.entities.StateEntity;
import users.entities.UserEntity;

public class UserDao {
	
	public void create(UserDto userDto) {
		UserEntity user = new UserEntity();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setGender(userDto.getGender());
		user.setAddress(userDto.getUserAddressEntity());
		user.setMobile(userDto.getMobile());

		Session s = DBConnectionService.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
	}

	public boolean isEmailAlreadyExists(String email) {
		Session s = DBConnectionService.getSession();
		Transaction tx = s.beginTransaction();
		String hql = "from UserEntity where email=:email";
		Query query = s.createQuery(hql);
		query.setParameter("email",email);
		List results = query.list();
		return results.size()>0;
	}

	public boolean authenticate(UserDto userDto) {

		Session session = DBConnectionService.openSession();

		try {
			Query query = session.createSQLQuery("from UserEntity where email=:email and password=:password");
			query.setParameter("email", userDto.getEmail());
			query.setParameter("password", userDto.getPassword());
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;

		}

	}
	
	public List<CountryEntity> getAllCountries(){
		List<CountryEntity> countries=null;
				try {
		Session session=DBConnectionService.openSession();
		Query query=session.createQuery("from CountryEntity");
		
		 countries=query.list();
		return countries;
				}catch(HibernateException e) {
					System.out.println(e);
				}
				return countries;
	}
}
