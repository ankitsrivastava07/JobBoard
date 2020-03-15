package users.service;

import users.dto.UserDto;

public interface UserService {
	void create(UserDto userDto);
	
	boolean authenticate(UserDto userDto);
}
