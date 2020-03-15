package users.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.dto.UserDto;
import users.service.UserServiceImpl;

@WebServlet("/login1")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserServiceImpl userService = new UserServiceImpl();
		UserDto userDto = new UserDto();
		response.setStatus(HttpServletResponse.SC_CREATED);
		userDto.setEmail(email);
		userDto.setPassword(password);
		
		  if (userService.authenticate(userDto)) { 
			  HttpSession session =request.getSession(true);
			  session.setAttribute("email",email); 
			  RequestDispatcher rd = request.getRequestDispatcher("users/welcome.jsp");
			  rd.forward(request, response);

		  } 
		  else {
			  response.getWriter().print("<h3>"+"Invalid Username Or Password"+"<h3>");
		  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");  
		  rd.include(request, response);	  
		  }
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		 RequestDispatcher rd=request.getRequestDispatcher("users/login.jsp");
		 rd.include(request, response);
	}
	
}
