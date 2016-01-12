<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.wipro.timetracker.dao.*, com.wipro.timetracker.daoimpl.*, com.wipro.timetracker.model.*, 
				 java.util.*, java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TDS</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript" src="js/ts.js"></script>
<link rel="stylesheet" type="text/css" href="css/ts.css">

<script>
  $(function() {
	    $( "#startDate" ).datepicker({
	      dateFormat: 'yy-mm-dd',	
	      changeMonth: true,
	      changeYear: true
	    });
	    $( "#endDate" ).datepicker({
	    	  dateFormat: 'yy-mm-dd',
		      changeMonth: true,
		      changeYear: true
		    });
	  });
</script>
</head>
<body>
<% 
UsersDao userDao = new UsersDaoImpl();
List<CompOff> compOffForEffortsList = (ArrayList<CompOff>) session.getAttribute("displayCompOffForEfforts");
String emptyCompOffForEffortsList = (String) session.getAttribute("displayCompOffForEffortsEmpty");
String userName = (String) session.getAttribute("userName");
String startDate = (String) session.getAttribute("startDate");
String endDate = (String) session.getAttribute("endDate");
StringBuffer taskDescription = new StringBuffer();
int totalTaskTime=0, totalCompOffTime=0;
String day1, day2, day3, day4, day5, day6, day7;
DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
%>
<jsp:include page="includes/_header.jsp"></jsp:include><br><br><br>
<jsp:include page="includes/_navigation.jsp"></jsp:include><br>

<div id="content">
<%
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "") || 
    	(session.getAttribute("displayName")) == null || (session.getAttribute("displayName") =="")) {
%>
You are not logged in<br/><a href="login.jsp">Please Login</a>
<%} else {
%>
<!-- Add Efforts Main Content -->
<center>

<form method="post" action="EffortsController" autocomplete="off">	
<p>
	Start Week Date: <input type="text" id="startDate" name="startDate">
	End Week Date: <input type="text" id="endDate" name="endDate">
   <button type="submit" id="showEfforts" value="Add Efforts">Add Efforts</button>
</p>
</form>
</center>
<hr>

<%
if(startDate!=null && endDate!=null){%>
<center>
	<font size="4"><%= startDate%> to <%= endDate%></font>
<br><br>
<%}%>

<% 
if(compOffForEffortsList!=null){

for(CompOff obj : compOffForEffortsList){
	if(obj.getTaskDesc()!="" && obj.getCompOffUtilized()==0){
		taskDescription.append(obj.getActionDate() + ": " + obj.getTaskDesc());
		taskDescription.append("\n");
	}else if(obj.getTaskDesc()!="" && obj.getCompOffUtilized()==9){
		taskDescription.append(obj.getActionDate() + ": " + "Comp Off Utilized");
		taskDescription.append("\n");
	}
	totalTaskTime += obj.getTimeTaken();
	totalCompOffTime += obj.getCompOffUtilized();

}%>
	<br><br>
	Total Task Time: 
	<input type="text" name="totalTaskTime" id="totalTaskTime" value="<%= totalTaskTime%>" size="2" readonly/>
	Total CompOff Utilized: 
	<input type="text" name="totalCompOffUtilized" id="totalCompOffUtilized" value="<%= totalCompOffTime %>" size="2" readonly>
	<br><br>
	Task Description : <br><br>
	<textarea name="taskDesc" rows="10" cols="50" readonly><%= taskDescription %></textarea>
</center>
<%} else if(emptyCompOffForEffortsList!=null){%>
	<font color="red">No Records Found ! No Weekend Support. Only Weekdays Entry.</font>
<%}
%>
<!-- Add Efforts Main Content Finish -->	
<%}
%>
</div>
<jsp:include page="includes/_footer.jsp"></jsp:include>
	

</body>
</html>