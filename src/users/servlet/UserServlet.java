package users.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.ExceptionHandler;
import users.dto.UserDto;
import users.service.UserService;
import users.service.UserServiceImpl;
import users.translator.UserDtoTranslator;

@WebServlet("/create-user")
public class UserServlet extends HttpServlet {
	private UserService userService;
	private ExceptionHandler exceptionHandler;
	private UserDtoTranslator userDtoTranslator;
	public UserServlet() {
		userService = new UserServiceImpl();
		exceptionHandler = new ExceptionHandler();
		userDtoTranslator = new UserDtoTranslator();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		UserDto userDto = userDtoTranslator.translateUserRequestToDto(request);
		try {
			userService.create(userDto);
			response.setStatus(201);
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			writer.append(gson.toJson(userDto));
		} catch (Exception e) {
			exceptionHandler.handleException(e, request, response);
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/users/register.jsp");
		rd.include(request, response);
	}
}
