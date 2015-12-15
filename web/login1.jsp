<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
/* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
@import url(http://weloveiconfonts.com/api/?family=entypo);
@import url(http://fonts.googleapis.com/css?family=Roboto);
/* zocial */
[class*="entypo-"]:before {
	font-family: 'entypo', sans-serif;
}
*,*:before,*:after {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}
h2 {
	color: rgba(255, 255, 255, .8);
	margin-left: 12px;
}
body {
	background: #FFFFFF;
	font-family: 'Roboto', sans-serif;
}
form {
	position: relative;
	margin: 50px auto;
	width: 380px;
	height: auto;
}
input {
	padding: 16px;
	border-radius: 7px;
	border: 0px;
	background: rgba(255, 255, 255, .2);
	display: block;
	margin: 15px;
	width: 300px;
	color: white;
	font-size: 18px;
	height: 54px;
}
input:focus {
	outline-color: rgba(0, 0, 0, 0);
	background: rgba(255, 255, 255, .95);
	color: #e74c3c;
}
button {
	float: right;
	height: 121px;
	width: 50px;
	border: 0px;
	background: #e74c3c;
	border-radius: 7px;
	padding: 10px;
	color: white;
	font-size: 22px;
}
.inputUserIcon {
	position: absolute;
	top: 68px;
	right: 80px;
	color: white;
}
.inputPassIcon {
	position: absolute;
	top: 136px;
	right: 80px;
	color: white;
}
input::-webkit-input-placeholder {
	color: white;
}
input:focus::-webkit-input-placeholder {
	color: #e74c3c;
}

</style>
<link rel="stylesheet" type="text/css" href="css/ts.css">
<script src="js/prefixfree.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
</head>

<body>
<jsp:include page="includes/_header.jsp"></jsp:include><br><br><br>
<jsp:include page="includes/_navigation.jsp"></jsp:include>
<center><br><br>
<div id="loginDiv" style="background: #272125; width:450px; height:250px;">
	<form action="" autocomplete="off">
		<h2>
			<span class="entypo-login"></span> Login
		</h2>
		<button class="submit">
			<span class="entypo-lock"></span>
		</button>
		<span class="entypo-user inputUserIcon"></span> 
			<input type="text" class="user" placeholder="ursername" /> 
		<span class="entypo-key inputPassIcon"></span> 
			<input type="password" class="pass" placeholder="password" />
	</form>
</div>
</center>	
<jsp:include page="includes/_footer.jsp"></jsp:include>
</body>
</html>
