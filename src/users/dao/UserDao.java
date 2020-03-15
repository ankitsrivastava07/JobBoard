package users.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.DBConnectionService;
import users.dto.UserDto;
import users.entities.UserEntity;

public class UserDao {

	public void create(UserDto userDto) {
		UserEntity user = new UserEntity();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setGender("Male");
		user.setPassword(userDto.getPassword());
		Session s = DBConnectionService.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
	}
	public boolean isEmailAlreadyExists(String email) {

		Session s = DBConnectionService.getSession();
		Transaction tx = s.beginTransaction();
		try {
			SQLQuery query = s.createSQLQuery("select id from users where email=:email");

			query = query.setParameter("email", email);
			query.getSingleResult();
			tx.commit();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	public boolean authenticate(UserDto userDto) {
		Session session = DBConnectionService.openSession();
		String email = userDto.getEmail();
		String password = userDto.getPassword();

		try {
			Query query = session.createSQLQuery("from users where email=:email and password=:password");
			query.setParameter("email", email);
			query.setParameter("password", password);

			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
