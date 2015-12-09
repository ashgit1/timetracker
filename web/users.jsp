<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TimeTracker</title>
<!-- jTable Metro styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<!-- User Defined Jtable js file -->
<script src="js/UserJTableJs.js" type="text/javascript"></script>

</head>
<body>

<div class="filtering">
    <form>
        Name: <input type="text" name="userName" id="userName" />
        Project: 
        <select id="projectID" name="projectID">
            <option selected="selected" value="0">All Project</option>
            <option value="1001">TSD-Middleware</option>
            <option value="1002">TSD-Release</option>
            <option value="1003">TSD-System Administration</option>
        </select>
        <button type="submit" id="LoadRecordsButton">Load records</button>
    </form>
</div>
 
<div style="text-align: center;">
		<h4>User DashBoard</h4>
		<div id="UserTableContainer"></div>
</div>

</body>
</html>