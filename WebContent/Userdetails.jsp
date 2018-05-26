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
		Cookie cookies[]=request.getCookies();
		String username=null;
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("username")){
				username=cookie.getValue();
				break;
			}
				
		}
		
		if(username==null){
			response.sendRedirect("Home.html");
		}
	%>
	<h1>Hi <%=username %> you details is here:<h1><br>
	<p1>Name: <%=username%></p1><br>
	<p2>Work on: SAP Labs</p2>
	
	<form action="logoutHelper" method="GET">
		<input type='submit' value='logout'>
	</form>
	
</body>
</html>