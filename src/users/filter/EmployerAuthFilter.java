package users.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({ "/jobs/*" })
public class EmployerAuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("userId"))
				&& Objects.nonNull(session.getAttribute("role"))
				&& session.getAttribute("role").toString().equalsIgnoreCase("EMPLOYER")) {
			chain.doFilter(req, response);
		} else {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/employer/login1");
		}
	}

}
