<%@page import="org.apache.tomcat.util.http.Cookies"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String username=null;
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie : cookies ){
			if(cookie.getName().equals("username")){
				username=cookie.getValue();
			}
		}
		
		if(username==null){
			response.sendRedirect("/Home.html");
		}
	%>
	<h1> Hi <%=username %> Welcome. Enjoy Browsing </h1>
	<form action="UserDetailsPageHelper" method="GET">
		<br><br>
		<input type='submit' value='View User details'><br>
	</form>
	
	<form action="logoutHelper" method="GET">
		<br><br>
		<input type='submit' value='logOut'><br>
	</form>

</body>
</html>