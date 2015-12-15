<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.wipro.timetracker.dao.*, com.wipro.timetracker.daoimpl.*, com.wipro.timetracker.model.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View Support</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="css/ts.css">
<script>
$(document).ready(function(){
    $('#compOffDataTable').DataTable();
});
</script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	$(document).ready(function() {
		$('#projectDisplayName').change(function() {
			fillOptions('userNameDisplay', this);
		});
		/*  $('#dd2').change(function() { fillOptions('dd3', this); }); */
	});
	function fillOptions(ddId, callingElement) {
		var dd = $('#' + ddId);
		$.getJSON(
				'GetUsersBasedProjectController?dd=' + ddId + '&val=' + $(callingElement).val(),
				function(opts) {
					$('>option', dd).remove(); // Clean old options first.
					if (opts) {
						$.each(opts, function(key, value) {
							dd.append($('<option/>').val(key).text(value));
						});
					} else {
						dd.append($('<option/>').text("Select Project"));
					}
				});
	}
</script>

</head>
<body>
<% 
List<String> displayProjectList = new ArrayList<String>();
UsersDao userDao = new UsersDaoImpl();
displayProjectList = userDao.getProjectName();
List<CompOff> compOffList = (ArrayList<CompOff>) session.getAttribute("compOffListBasedOnUserId");
%>
<jsp:include page="includes/_header.jsp"></jsp:include><br><br><br>
<jsp:include page="includes/_adminNavigation.jsp"></jsp:include>
<br>
<div id="content">
<%
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "") || 
    	(session.getAttribute("displayName")) == null || (session.getAttribute("displayName") =="")) {
%>
You are not logged in<br/><a href="login.jsp">Please Login</a>
<%} else {%>
<center>
<form method="post" action="AdminViewSupport" autocomplete="off">
	Project : 
	<select id="projectDisplayName" name="projectDisplayName" style="width: 150px;">
		<option selected="selected" value="Select Project">Select Project</option>
			<% 
				if(displayProjectList!=null){
					for(String name : displayProjectList){%>
						<option value="<%= name%>"><%= name%></option>
					<% }
				}
			%>		
	</select>
	Name:
	<select id="userNameDisplay" name="userNameDisplay" style="width: 100px;">
    	<option selected="selected" value="Select User">Select User</option>
    </select>
	<button type="submit" id="showEmployeeSupportDetail">Submit</button>
</form>
</center>
<hr>
<%}%>
</div>

<jsp:include page="includes/_footer.jsp"></jsp:include>
</body>
</html>