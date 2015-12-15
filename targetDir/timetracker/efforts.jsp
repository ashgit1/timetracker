<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weekly Efforts</title>
</head>
<body>
<%
    if ((session.getAttribute("displayName") == null) || (session.getAttribute("displayName") == "")) {
%>
You are not logged in<br/>
<a href="login.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("displayName")%>
<%-- userName <%=session.getAttribute("userName")%> --%>
<a href="logout.jsp">Log out</a>
<%
    }
%>
</body>
</html>