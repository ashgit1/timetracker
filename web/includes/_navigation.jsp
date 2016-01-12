<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
    border-right:1px solid #bbb;
}

li:last-child {
    border-right: none;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>
</head>
<body>

	<ul>
		<li><a class="active" href="/timetracker/login.jsp">Home</a></li>
		<li><a href="/timetracker/weekend_support.jsp">Add Support</a></li>
		<li><a href="/timetracker/view_support.jsp">View Support</a></li>
		<li><a href="/timetracker/add_efforts.jsp">Add Efforts</a></li>
		<li><a href="#contact">View Efforts</a></li>
		<li><a href="#contact">CO DashBoard</a></li>
		<ul style="float: right; list-style-type: none;">
			<li><a href="/timetracker/logout.jsp">Logout</a></li>
		</ul>
	</ul>

</body>
</html>