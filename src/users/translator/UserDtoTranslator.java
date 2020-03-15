package users.translator;

import javax.servlet.http.HttpServletRequest;

import users.dto.UserDto;

public class UserDtoTranslator {
	public UserDto translateUserRequestToDto(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Long mobile = Long.parseLong(request.getParameter("mobile"));
		String location = request.getParameter("location");
		String resume = request.getParameter("resume");
		UserDto userDto = new UserDto();
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setEmail(email);
		userDto.setPassword(password);
		return userDto;
	}
}
