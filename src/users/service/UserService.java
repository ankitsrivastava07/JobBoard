package users.service;

import java.util.List;

import users.dto.UserDto;
import users.entities.CountryEntity;
import users.entities.StateEntity;

public interface UserService {
	void create(UserDto userDto);
	
	boolean authenticate(UserDto userDto);
	
	List<CountryEntity> getAllCountries();
	
}
