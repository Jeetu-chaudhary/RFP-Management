<%@page import="com.model.User"%>
<%@page import="com.model.VendorRegister"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RFP System</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.container {
	height: 99.3vh;
	width: 99.7vw;
	display: flex;
}

.container1 {
	height: 99.5%;
	width: 20%;
	background-color: rgb(46, 46, 46);
}

.cont-1 {
	width: 80vw;
	height: 15%;
	display: flex;
	justify-content: end;
}

.cont-2 {
	height: 84%;
	width: 80vw;
	background-color: rgb(247, 245, 245);
}

.velocity {
	text-align: center;
	padding-top: 20px;
	height: 13vh;
	font-size: 40px;
	color: white;
	width: 100%;
}

a {
	text-decoration: none;
}

.list {
	padding: 25px;
}

li {
	padding: 15px;
	list-style: none;
	font-size: 15px;
	color: rgb(117, 117, 117);
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

li:hover {
	cursor: pointer;
}

.li1:hover {
	cursor: pointer;
	background-color: rgb(117, 117, 117);
	color: white;
}

.admin {
	display: flex;
	align-items: center;
}

.admin0 {
	font-size: larger;
}

.home {
	padding: 25px;
	display: flex;
	justify-content: space-between;
	color: rgb(117, 117, 117);
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.rfp {
	padding: 25px;
	background-color: white;
	margin: 20px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	color: rgb(184, 184, 184);
	border-radius: 5px;
}

.rfp2 {
	background-color: white;
	font-size: smaller;
	position: absolute;
	width: 76%;
	bottom: 0;
}
</style>
</head>
<body>
	<div class="container">
		<div class="container1">
			<div class="velocity">Velocity</div>
			<ul class="list">
				<li class="li1">Dashboard</li>
				<a href="./vendorRFP">
					<li class="li1">RFP For Quotes</li>
				</a>
			</ul>
		</div>
		<div class="container2">
			<div class="cont-1">
				<ul class="admin">
					<%
					// Retrieve the VendorRegister object from the session
					 session = request.getSession(false); // Get existing session, do not create if it doesn't exist
					User vendor = (User) session.getAttribute("vendor");
					%>

					<ul class="admin">
						<li class="admin0">Welcome <%=vendor.getFirstName()%></li>
					</ul>
					<a href="./logout"><li class="admin0"
						style="color: rgb(110, 110, 248)">Logout</li></a>


				</ul>
			</div>
			<div class="cont-2">
				<div class="home">
					<div class="dashboard">Dashboard</div>
					<div class="Home">Home</div>
				</div>
				<div class="rfp">Welcome to RFP System.</div>
				<div class="home rfp2">
					<p>@2024copyright</p>
					<p>support Email: support@velsof.com</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
