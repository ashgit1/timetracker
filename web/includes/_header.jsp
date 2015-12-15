
<div class="fixedheader">

<div style="text-align:center">
<font size="5">Time Tracker</font>
<%
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "") || 
    	(session.getAttribute("displayName")) == null || (session.getAttribute("displayName") =="")) {
%>
<!-- You are not logged in<br/><a href="login.jsp">Please Login</a> -->
<%} else {
%>
<span style="float:right">Welcome <%=session.getAttribute("displayName")%></span>
<% } %>
</div>

</div>
