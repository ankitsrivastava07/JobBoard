package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ExceptionHandler {
	public void handleException(Exception ex, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setStatus(400);
		PrintWriter writer = response.getWriter();
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(ex.getMessage());
		Gson gson = new Gson();
		writer.append(gson.toJson(errorDetails));
	}
}   
