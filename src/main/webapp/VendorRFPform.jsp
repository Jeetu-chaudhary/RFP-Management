<%@page import="com.model.User"%>
<%@page import="com.model.VendorRegister"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RFP System</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.cdnfonts.com/css/mistral" rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
}

.container {
	height: 99.3vh;
	width: 99.7vw;
	display: flex;
	flex-direction: row;
}

.container1 {
	height: 110%;
	width: 20%;
	background-color: #27333a;
}

.cont-1 {
	width: 80vw;
	height: 15%;
	display: flex;
	justify-content: end;
	margin-right: 12px;
}

.cont-2 {
	height: 84%;
	width: 80vw;
	background-color: #f4f8f9;
}

.velocity {
	text-align: center;
	padding-top: 20px;
	height: 13vh;
	font-size: 40px;
	font-family: 'Mistral';
	font-weight: 400;
	color: white;
	width: 100%;
}

.form-group {
	margin-bottom: 15px;
}

.label1 {
	padding-right: 305px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	font-weight: 600;
	color: #27333a;
}

.inputBox {
	width: 40%;
	border: 1px solid #ccc;
	border-radius: 3px;
	padding: 8px 10px;
	margin-right: 250px;
}

.label2 {
	margin-right: 310px;
	font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
	font-weight: 600;
	margin-left: 2px;
	color: #27333a;
}

.label3 {
	margin-right: 350px;
	font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
	font-weight: 600;
	margin-left: 2px;
	color: #27333a;
}

.label4 {
	margin-right: 350px;
	font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
	font-weight: 600;
	color: #27333a;
}

.inputBoxb1 {
	width: 80%;
	margin-left: 3px;
	border: 1px solid #ccc;
	border-radius: 3px;
	padding: 8px;
}

.inputBoxb2 {
	width: 80%;
	border: 1px solid #ccc;
	border-radius: 3px;
	padding: 8px 10px;
}

.buttoncontainer {
	align-items: flex-end;
	margin-top: 100px;
	margin-left: 543px;
}

.button-15-submit {
	background-color: #3d8ef8;
	border: 1px solid #61a3f9;
	border-radius: 4px;
	box-sizing: border-box;
	color: #FFFFFF;
	cursor: pointer;
	direction: ltr;
	font-family: "SF Pro Text", "SF Pro Icons", "AOS Icons",
		"Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 15px;
	font-weight: 300;
	letter-spacing: -.022em;
	line-height: 1.47059;
	min-width: 30px;
	overflow: visible;
	padding: 4px 8px;
	margin-right: 10px;
	margin-left: 50%;
	text-align: center;
	vertical-align: baseline;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
	white-space: nowrap;
}

.button-15-cancel {
	background-color: #7c8a96;
	border: 1px solid #95a0a9;
	border-radius: 4px;
	box-sizing: border-box;
	color: #FFFFFF;
	cursor: pointer;
	direction: ltr;
	font-family: "SF Pro Text", "SF Pro Icons", "AOS Icons",
		"Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 15px;
	font-weight: 300;
	letter-spacing: -.022em;
	line-height: 1.47059;
	min-width: 30px;
	overflow: visible;
	padding: 4px 8px;
	margin-right: 17px;
	text-align: center;
	vertical-align: baseline;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
	white-space: nowrap;
}

.mixedelements {
	display: flex;
	flex-direction: row;
	position: relative;
	justify-content: space-between;
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
	color: #566872;
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
	flex-direction: row;
	justify-content: space-between;
	color: rgb(117, 117, 117);
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.rfp {
	margin-left: 15px;
	background-color: white;

	padding-left: 20px;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 10px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	color: rgb(184, 184, 184);
}

.rfp2 {
	background-color: white;
	font-size: smaller;
	position: absolute;
	width: 76%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="container1">
			<div class="velocity">Velocity</div>
			<ul class="list">
				<a href="./vendorWelcomePage"><li class="li1">Dashboard</li></a>

				<a href="./vendorRFP">
					<li class="li1"><i class="fa fa-desktop"></i> RFP For Quotes</li>
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
					<a href="./logout"><li class="admin0"
						style="color: rgb(110, 110, 248)">Logout</li></a>
				</ul>
			</div>
			<div class="cont-2">
				<div class="home">
					<div class="dashboard">RFP Create</div>
					<div class="Home">Home / RFP / quotes Create</div>
				</div>
				<div class="rfp">
					<div class="lowerside">
						<form action="./addVendorQuote?rfpId=${name}&vendorid=${id}"
							method="post">
							<div class="form-group">
								<label for="Vp" class="label1">Vendor Price <sup
										class="asterisk" style="color: red">*</sup></label> <input
									type="number" class="inputBox" name="vendorPrice"
									style="color: #b9b9bd;" required>
							</div>
							<div class="form-group">
								<label for="itemdes" class="label2">Item Description <sup
										class="asterisk" style="color: red">*</sup></label> <input
									type="text" class="inputBox" name="itemDes"
									style="color: #b9b9bd;" required>
							</div>
							<div class="mixedelements">
								<div class="form-group">
									<label for="qty" class="label3">Quantity <sup
										class="asterisk" style="color: red">*</sup></label> <input
										type="number" class="inputBoxb1" name="quantity"
										style="color: #b9b9bd;" required>
								</div>
								<div class="form-group">
									<label for="cost" class="label4">Total Cost <sup
										class="asterisk" style="color: red">*</sup></label> <input
										type="number" class="inputBoxb2" name="totalCost"
										style="color: #b9b9bd;" required>
								</div>
							</div>

							<div class="buttoncontainer">
								<button type="submit" class="button-15-submit">Submit</button>
								<a href="./vendorRFP" class="button-15-cancel">Cancel</a>
							</div>
						</form>

					</div>
				</div>
				<div class="home rfp2">
					<p>
						2024 <i class="fa fa-copyright"></i> Copyright
					</p>
					<p>support Email: support@velsof.com</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>