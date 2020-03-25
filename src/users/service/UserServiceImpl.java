package users.service;

import java.util.List;

import users.dao.UserDao;
import users.dto.UserDto;
import users.entities.CountryEntity;
import users.service.validator.UserValidatorService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private UserValidatorService userValidatorService;
	public UserServiceImpl() {
		userDao = new UserDao();
		userValidatorService = new UserValidatorService();
	}
	public void create(UserDto userDto) {
		userValidatorService.validateCreateUser(userDto);
		userDao.create(userDto);
	}

	public boolean authenticate(UserDto userDto) {
		return userDao.authenticate(userDto);
	}
	
	public List<CountryEntity> getAllCountries(){
		return userDao.getAllCountries();
	}
}
