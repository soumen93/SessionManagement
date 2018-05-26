package SessionUsingCookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutHelper
 */
@WebServlet("/logoutHelper")
public class logoutHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public logoutHelper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		Cookie currentCookie = null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("username")) {
				currentCookie=cookie;
			}
		}
		
		if(currentCookie!=null) {
			currentCookie.setMaxAge(0);
			response.addCookie(currentCookie);
		}
		
		//response.sendRedirect("Home.html");
		
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/Home.html");
		PrintWriter out=response.getWriter();
		out.println("You sucessfully logged out");
		
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
