<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.wipro.timetracker.dao.*, com.wipro.timetracker.daoimpl.*, com.wipro.timetracker.model.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Support</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">

<script>
$(document).ready(function(){
    $('#compOffDataTable').DataTable();
});
</script>

</head>
<body>

<%
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "") || 
    	(session.getAttribute("displayName")) == null || (session.getAttribute("displayName") =="")) {
%>
You are not logged in<br/><a href="login.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("displayName")%>
<%-- userName <%=session.getAttribute("userName")%> --%>
<a href="logout.jsp">Log out</a>
<hr>
<!-- TSD View Support form -->
<%
String userName = (String)session.getAttribute("userName");
CompOff compModel = new CompOff();
CompOffDao compDao = new CompOffDaoImpl();
int userId = compDao.getUserID(userName);
List<CompOff> compOffList = compDao.getAllCompOff(userId);
%>


	<TABLE BORDER="1" id="compOffDataTable">
		<!-- <caption><font size="5px" color="#1E90FF">Release Daily Status Build Summary</font></caption> -->
		<thead>
			<TR class="noExl">
				<TH>ACTION DATE</TH>
				<TH>TYPE</TH>
				<TH>TYPE DETAIL</TH>
				<TH>TASK TYPE</TH>
				<TH>TIME TAKEN</TH>
				<TH>TASK DESCRIPTION</TH>
				<TH>COMP OFF UTILIZED</TH>
			</TR>
		</thead>
		
		<%
			for (int i=0; i<compOffList.size(); i++) {
		%>
		<TR>
			<TD><%= compOffList.get(i).getActionDate()%></TD>
			<TD><%= compOffList.get(i).getType()%></TD>
			<TD><%= compOffList.get(i).getTypeDetail()%></TD>
			<TD><%= compOffList.get(i).getTaskType()%></TD>
			<TD><%= compOffList.get(i).getTimeTaken()%></TD>
			<TD><%= compOffList.get(i).getTaskDesc()%></TD>
			<TD><%= compOffList.get(i).getCompOffUtilized()%></TD>
		</TR>
		<%} %>
	
		
	</TABLE>
	
	<!-- TSD View Support form End-->

<%
    }
%>

</body>
</html>