package users.translator;

import javax.servlet.http.HttpServletRequest;

import users.dto.UserDto;
import users.entities.CountryEntity;
import users.entities.StateEntity;
import users.entities.UserAddressEntity;

public class UserDtoTranslator {
	
	public UserDto translateUserRequestToDto(HttpServletRequest request) {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String countryName = request.getParameter("country");

		String stateName = request.getParameter("state");

		Long mobile = Long.parseLong(request.getParameter("mobile"));
		
		String gender = request.getParameter("gender");
		
		UserDto userDto = new UserDto();
		StateEntity state = new StateEntity();
		UserAddressEntity userAddressEntity = new UserAddressEntity();

		state.setName(stateName);
		CountryEntity country = new CountryEntity();
		country.setName(countryName);
		
		userDto.setUserAddressEntity(userAddressEntity);
		
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setMobile(mobile);
		userDto.setGender(gender);
		return userDto;
	}
}
