package users.service.validator;

import users.dto.UserDto;

public class UserValidatorService {
	private EmailValidator emailValidator;
	private UserNameValidator userNameValidator;
	public UserValidatorService() {
		emailValidator = new EmailValidator();	
		userNameValidator = new UserNameValidator();
	}
	public void validateCreateUser(UserDto userDto) {
		emailValidator.validate(userDto.getEmail());
		//userNameValidator.validate(userDto.getLastName());
	}
	public void validateUpdateUser(UserDto userDto) {
		emailValidator.validate(userDto.getEmail());
		//userNameValidator.validate(userDto.getLastName());
	}
	
	public void validateDeleteUser(UserDto userDto) {
		emailValidator.validate(userDto.getEmail());
		//userNameValidator.validate(userDto.getLastName());
	}
}
