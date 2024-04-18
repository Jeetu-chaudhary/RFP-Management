<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RFP System</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-color: #f4f8f9;
}

.topC {
	border-radus: 5px;
	width: 50%;
	align-items: center;
}

.container {
	background-color: #fff;
	padding: 30px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.upperside {
	background-color: #cee3fd;
	padding-bottom: 3px;
	height: 100vdh;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.h1 {
	font-size: 16px;
	color: #6a9ef8;
	padding-top: 25px;
	padding-left: 25px;
	padding-right: 134px;
}

.h2 {
	font-size: 14px;
	color: #6a9ef8;
	margin-top: 5px;
	padding-bottom: 20px;
	margin-left: 26px;
}

.lowerside {
	margin-left: 5px;
}

.label1 {
	padding-right: 305px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	font-weight: 600;
}

.label2 {
	padding-right: 280px;
	font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
	font-weight: 600;
	margin-left: 2px;
}

.bottomtext {
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-size: 11px;
	font-weight: 300;
}

.bottomcontainer {
	margin-top: 40px;
	margin-left: 139px;
}

.b1 {
	margin-top: 20px;
	margin-left: 20px;
}

.b2 {
	margin-top: 22px;
	margin-left: 20px;
}

.b2text {
	margin-left: 10px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-weight: 400;
	font-size: 12px;
}

h1 {
	font-size: 20px;
	margin-bottom: 10px;
}

p {
	font-size: 16px;
	color: #888;
}

.form-group {
	margin-bottom: 15px;
	width: 45%;
}

.Names {
	display: flex;
	justify-content: space-between;
}

label {
	display: block;
	margin-bottom: 5px;
	font-size: 13px;
	text-align: left;
}

input {
	width: 91.5%;
	padding: 10px 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 13px;
}

.form-group button {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

.button-15 {
	background-color: #3d8ef8;
	border: 1px solid #0077CC;
	border-radius: 4px;
	box-sizing: border-box;
	color: #FFFFFF;
	cursor: pointer;
	direction: ltr;
	font-family: "SF Pro Text", "SF Pro Icons", "AOS Icons",
		"Helvetica Neue", Helvetica, Arial, sans-serif;
	letter-spacing: -.022em;
	line-height: 1.47059;
	position: relative;
	right: 35%;
	overflow: visible;
	width: 30%;
	margin-left: 0;
	text-align: center;
	vertical-align: baseline;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
	white-space: nowrap;
}

.styOption {
	width: 100%; /* Set width to 30% */
	font-size: 15px; /* Increase font size */
	padding: 8px; /* Add padding */
}

a {
	display: block;
	margin-top: 10px;
	color: #888;
	text-decoration: none;
}

a:hover {
	color: #4CAF50;
}

.form-group2 {
	width: 100%;
	display: flex;
	flex-direction: column;
	margin-bottom: 15px;
}

input[type="email" i] {
	width: 96%;
}
</style>
</head>
<body>
	<div class="topC">
		<div class=upperside>
			<h1 class="h1">Welcome to RFP System!</h1>
			<p class="h2">Sign in to continue</p>
		</div>

		<div class="container">

			<div class="lowerside">
				<form action="./addVendor" method="post"
					onsubmit="return validateForm()">

					<div class="Names">
						<div class="form-group">
							<label for="firstName">First Name:</label> <input type="text"
								id="firstName" name="firstName" placeholder="Enter First Name"
								required class="half-width">
						</div>
						<div class="form-group">
							<label for="lastName">Last Name:</label> <input type="text"
								id="lastName" name="lastName" placeholder="Enter Last Name"
								required class="half-width">
						</div>
					</div>
					<div class="Names">
						<div class="form-group2">
							<label for="email">Email:</label> <input type="email" id="email"
								name="email" placeholder="Enter Email" required>
						</div>
					</div>
					<div class="Names">
						<div class="form-group">
							<label for="password">Password:</label> <input type="password"
								id="password" name="password" placeholder="Enter Password"
								required>
						</div>
						<div class="form-group">
							<label for="confirmPassword">Confirm Password:</label> <input
								type="password" id="confirmPassword" name="confirmPassword"
								placeholder="Confirm Password" required>
						</div>
					</div>
					<div class="Names">
						<div class="form-group">
							<label for="revenue">Revenue (last 3 years in lakhs):</label> <input
								type="number" id="revenue" name="revenue"
								placeholder="Enter Revenue" required>
						</div>
						<div class="form-group">
							<label for="numEmployees">Number of Employees:</label> <input
								type="number" id="numEmployees" name="numEmployees"
								placeholder="Enter Number of Employees" required>
						</div>
					</div>
					<div class="Names">
						<div class="form-group">
							<label for="gstNo">GST Number:</label> <input type="text"
								id="gstNo" name="gstNo" placeholder="Enter GST Number" required>
						</div>
						<div class="form-group">
							<label for="panNo">PAN Number:</label> <input type="text"
								id="panNo" name="panNo" placeholder="Enter PAN Number" required>
						</div>
					</div>
					<div class="Names">
						<div class="form-group">
							<label for="phone">Phone Number:</label> <input type="text"
								id="phone" name="phone" placeholder="Enter Phone Number"
								required>
						</div>
						<div class="form-group">
							<label for="categories">Categories:</label> 
							<select
								class="styOption" id="categories" name="categories" required multiple>
								<option value="${allcat}">All Categories </option>
								<c:forEach var="allcat" items="${allcat}" varStatus="status">
									<c:choose>
										<c:when test="${allcat.status eq true}">
											<option class="" value="${allcat}">${allcat.categoryName}</option>
										</c:when>
										<c:otherwise>
											<!-- Do nothing or display an alternative option/message -->
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<input class="button-15" type="submit" value="Register">
					</div>
				</form>
			</div>
		</div>

		<div class="bottomcontainer">
			<a href="#" class="b2text"><i class="fa fa-copyright"></i>
				Copyright RFP <i class="fa fa-heart" style="color: red;"></i> system
			</a>
		</div>
	</div>


	<script>
		function validateForm() {
			var password = document.getElementById("password").value;
			var confirmPassword = document.getElementById("confirmPassword").value;

			// Check if passwords match
			if (password != confirmPassword) {
				alert("Passwords do not match.");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>