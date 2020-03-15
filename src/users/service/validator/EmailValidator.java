package users.service.validator;

import common.Validator;
import users.dao.UserDao;

public class EmailValidator implements Validator{
	private UserDao userDao;
	public EmailValidator(){
		userDao = new UserDao();
	}
	public void validate(Object object) {
		String email = (String)object;
		if(userDao.isEmailAlreadyExists(email)) {
		  throw new EmailAlreadyExistsException("Email already exist");
		}
	}
	
	static class EmailAlreadyExistsException extends RuntimeException{
		public EmailAlreadyExistsException(String message){
			super(message);
		}
	}
	
}
