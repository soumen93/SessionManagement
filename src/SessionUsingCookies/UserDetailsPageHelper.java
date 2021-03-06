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

@WebServlet("/UserDetailsPageHelper")
public class UserDetailsPageHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDetailsPageHelper() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		String username=null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("username")) {
				username=cookie.getValue();
			}
		}
		if(username!=null) {
			response.sendRedirect("Userdetails.jsp");
		}else {
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/Home.html");
			PrintWriter out=response.getWriter();
			out.println("<font colur='red'>Either username or password id incorrect </font>");
			requestDispatcher.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
