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


@WebServlet("/loginHelper")
public class loginHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username="soumen";
	private String password="soumen123";

    public loginHelper() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameEntered=request.getParameter("username");
		String passwordEntered=request.getParameter("password");
		
		if(username.equals(usernameEntered) && password.equals(passwordEntered)) {
			Cookie cookie=new Cookie("username", username);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			response.sendRedirect("loginSucess.jsp");
		}else {
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/Home.html");
			PrintWriter out=response.getWriter();
			out.println("<font color=red> Please check your credentials. Either username or password is wrong </font>");
			
			requestDispatcher.include(request, response);
		}
	}

}
