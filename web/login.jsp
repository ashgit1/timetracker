<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to TS</title>
<link rel="stylesheet" type="text/css" href="css/ts.css">
</head>
<body>
<jsp:include page="includes/_header.jsp"></jsp:include><br><br><br>
<jsp:include page="includes/_navigation.jsp"></jsp:include>
<center><br><br>
<div id="loginDiv">
<form method="post" action="LoginController" autocomplete="off">
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">TS Login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="userName" placeholder="username" /></td>
                        
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" placeholder="password" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
<%
    if ((session.getAttribute("invalidUser") != null) && (session.getAttribute("invalidUser") != "")) {
%>
<font color="red">Invalid credentials. Please try again.</font>
<%} else {
	session.setAttribute("invalidUser", null);
	session.invalidate();
}%>
</div>
</center>
<jsp:include page="includes/_footer.jsp"></jsp:include>
</body>
</html>