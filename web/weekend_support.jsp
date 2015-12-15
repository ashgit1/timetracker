<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TDS</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<!-- cdn for modernizr, if you haven't included it already -->
<script
	src="http://cdn.jsdelivr.net/webshim/1.12.4/extras/modernizr-custom.js"></script>
<!-- polyfiller file to detect and load polyfills -->
<script src="http://cdn.jsdelivr.net/webshim/1.12.4/polyfiller.js"></script>
<script type="text/javascript" src="js/ts.js"></script>
<link rel="stylesheet" type="text/css" href="css/ts.css">

</head>
<body onload="defaul()">

<jsp:include page="includes/_header.jsp"></jsp:include><br><br><br>
<jsp:include page="includes/_navigation.jsp"></jsp:include>
<div id="content">
<%
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "") || 
    	(session.getAttribute("displayName")) == null || (session.getAttribute("displayName") =="")) {
%>
You are not logged in<br/><a href="login.jsp">Please Login</a>
<%} else {
%>
<%--
Welcome <%=session.getAttribute("displayName")%>
 userName <%=session.getAttribute("userName")%> 
<a href="logout.jsp">Log out</a>
--%>

<!-- TSD Support form -->
<div class="form-style-5">

		<H1 align="center">
			<span class="number">TS</span>TSD-IDC
		</H1>
		<form name="support" action="WeekendSupportController" method="post">

			<fieldset>
				<legend>
					<span class="number">1</span>Support Info
				</legend>
				<input type="text" name="name" value="<%= session.getAttribute("userName") %>" readonly id="name"><br>
				<input type="date" name="date" placeholder="YYYY-MM-DD"> 
				<label for="plan">Type:</label> 
				<select id="plan" name="plan" onchange="configureDropDownLists(this,document.getElementById('detail'))">
					<option value="">Select</option>
					<option value="oncall">on call</option>
					<option value="project">project</option>
					<option value="compoff">comp-off</option>
				</select> 
				<label for="detail">Details:</label> 
				<select id="detail" name="detail" onChange="changetextbox()">
					<option value="Weekend support">Weekend support</option>
					<option value="Public Holiday Support-on-call">PublicHoliday Support-on-call</option>
					<option value="Comp-off availed">Comp-off availed</option>
				</select>
			</fieldset>

			<fieldset id="effort">
				<legend>
					<span class="number">2</span>Additional hours logged
				</legend>
				<input type="button" value="Add efforts" id="btnAdd" /><br><br><br>
				<div id="fooBar"></div>
			</fieldset>
			
			<fieldset id="comp">
				<legend>
					<span class="number">3</span>comp-off hours utilized
				</legend>
				<input type="number" name="compoff" value="9" readonly placeholder="0-24" id="compoff">
			</fieldset>

			<input type="submit" value="Apply" id="submit" />

		</form>
	</div>
<!-- TSD Support form Ends -->
<%
    }
%>
</div>
<jsp:include page="includes/_footer.jsp"></jsp:include>
	
</body>
</html>