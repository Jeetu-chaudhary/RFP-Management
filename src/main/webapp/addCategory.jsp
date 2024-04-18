<%@page import="com.model.User"%>
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

a {
	text-decoration: none;
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
body {
	font-family: Arial, sans-serif;
}



label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], select {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top:10%;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
.button{
 padding:8px 15px;
 margin:10px;
}

</style>
</head>
<body>
	<div class="container">
		<div class="container1">
			<div class="velocity">Velocity</div>
			<ul class="list">
				<a href="./adminWelcomePage"><li class="li1">Dashboard</li></a>
				<a href="./listVendor">
					<li class="li1">Vendors</li>
				</a>
				<a href="./listRFP"><li class="li1">RFP Lists</li></a>
				<a href="./listAdminQuote"><li class="li1">RFP Quotes</li></a>
				<a href="./listCategories"><li class="li1">Categories</li></a>
			</ul>
		</div>
		<div class="container2">
			<div class="cont-1">
				<ul class="admin">
					                  <%
					// Retrieve the VendorRegister object from the session
					 session = request.getSession(false); // Get existing session, do not create if it doesn't exist
					User vendor = (					User) session.getAttribute("admin");
					%>

					
						<li class="admin0">Welcome <%=vendor.getFirstName()%></li>
					<a href="./logout"><li class="admin0"
						style="color: rgb(110, 110, 248)">Logout</li></a>
				</ul>
			</div>
			<div class="cont-2">
				<div class="home">
					<div class="dashboard">Dashboard</div>
					<div class="Home">Home</div>
				</div>
				<div class="rfp">
					
					<form action="./addCategory" method="post">
						<label for="categoryName">Category Name:</label> <input
							type="text" id="categoryName" name="categoryName" required>

						<label for="status">Status:</label> <select id="status"
							name="status">
							<option value="active">Active</option>
							<option value="inactive">Inactive</option>
						</select> <input type="submit" value="Submit" >
						<a href="./listCategories"><button type="button" class="button">Cancel</button></a>
					</form>
				</div>
				<div class="home rfp2">
					<p>@2024copyright</p>
					<p>support Email: support@velsof.com</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>






