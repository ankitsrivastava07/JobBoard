package users.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.dao.StateDao;
import users.entities.StateEntity;

@WebServlet("/state-list")
public class StateServlet extends HttpServlet {
	private StateDao stateDao=null;
	
	public void init() {
		stateDao = new StateDao();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("country_id== "+request.getParameter("country"));
		long country_id=Long.parseLong(request.getParameter("country"));
		
		PrintWriter writer = response.getWriter();
		List<StateEntity> states = stateDao.getAllStates(country_id);
		request.setAttribute("states",states);
		
		Gson gson = new Gson();
		String statesString = gson.toJson(states);
		writer.println(statesString);
	}
}
