<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

.form-container {
	width: 60%;
	margin: 0 auto;
}

.form-row {
	margin-bottom: 15px;
}

.form-row label {
	display: inline-block;
	width: 120px;
	text-align: right;
	margin-right: 10px;
}

.form-row input[type="text"], .form-row input[type="number"], .form-row select,
	.form-row input[type="date"] {
	width: calc(100% - 140px);
}

.button-row {
	margin-top: 20px;
	text-align: right;
}

.submit-btn, .cancel-btn {
	padding: 10px 20px;
	margin-left: 10px;
}

/* Optional: Style for buttons */
.submit-btn {
	background-color: #4CAF50; /* Green */
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.submit-btn:hover {
	background-color: #45a049;
}

.cancel-btn {
	background-color: #f44336; /* Red */
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.mixedelements {
	display: flex;
	flex-direction: row;
	position: relative;
	justify-content: flex-start;
}

.inputBoxt {
	padding: 7px;
	width: 90%;
}

.grps {
	width: 33%;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 15px;
	margin-left: 15px
}

.grp2 {
	width: 50%;
	margin-bottom: 20px;
}

.label1, .label2, .label3 {
	display: block;
	margin-right: 10px;
	margin-bottom: 10px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	font-weight: 600;
	font-size: smaller;
	color: #27333a;
}

.cancel-btn:hover {
	background-color: #da190b;
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
					User vendor = (User) session.getAttribute("admin");
					%>


					<li class="admin0">Welcome <%=vendor.getFirstName()%></li>
					<a href="./logout"><li class="admin0"
						style="color: rgb(110, 110, 248)">Logout</li></a>
				</ul>
			</div>
			<div class="cont-2">
				<div class="home">
					<div class="dashboard">RFP Create</div>
					<div class="Home">Home/RFP/ RFP Create</div>
				</div>
				<div class="rfp">
					<div class="lowerside">
						<form action="./addRFPList" method="post">
							<div class="mixedelements">
								<div class="grps">
									<label for="Vp" class="label1">Item Name<sup
										class="asterisk" style="color: red">*</sup></label> <input id="Vp"
										type="text" class="inputBoxt" name="itemName"
										style="color: #b9b9bd;" required>
								</div>
								<div class="grps">
									<label for="itemdes" class="label2">Item Description<sup
										class="asterisk" style="color: red">*</sup></label> <input type="text"
										class="inputBoxt" name="itemDescription"
										style="color: #b9b9bd;" required>
								</div>
								<div class="grps">
									<label for="qty" class="label3">Quantity<sup
										class="asterisk" style="color: red">*</sup></label> <input
										type="number" class="inputBoxt" name="quantity"
										style="color: #b9b9bd;" required>
								</div>
							</div>
							<div class="mixedelements">
								<div class="grp2">
									<label for="qty" class="label3">Last Date<sup
										class="asterisk" style="color: red">*</sup></label> <input type="date"
										name="lastDate" style="color: #b9b9bd;" required>
								</div>
								<div class="grp2">
									<label for="cost" class="label3">Minimum Price<sup
										class="asterisk" style="color: red">*</sup></label> <input
										type="number" class="inputBoxt" name="minPrice"
										style="color: #b9b9bd;" required>
								</div>
							</div>
							<div class="mixedelements">
								<div class="grp2">
									<label for="qty" class="label3">Maximum Price<sup
										class="asterisk" style="color: red">*</sup></label> <input
										type="number" class="inputBoxt" name="maxPrice"
										style="color: #b9b9bd;" required>
								</div>

								<input name="categories" value="${catId}" type="hidden" />

								<div class="grp2">
									<label for="categories" class="label3">Vendor<sup
										class="asterisk" style="color: red">*</sup></label> <select
										id="categories" class="inputBoxt" name="vendorData" required
										multiple>
										<c:forEach var="Vendor" items="${allVendor}"
											varStatus="status">
											<option value="${Vendor}">${Vendor.firstName}</option>
										</c:forEach>
									</select>
								</div>





							</div>
							<div class="buttoncontainer">
								<button type="submit" class="button-15-submit">Submit</button>
								<a href="./listRFP"><button type="button"
										class="button-15-cancel">Cancel</button></a>
							</div>
						</form>

					</div>

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
