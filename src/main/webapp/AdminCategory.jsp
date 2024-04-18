<%@page import="com.model.User"%>
<%@page import="com.model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

.home2 {
	padding-bottom: 10px;
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

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: black;
	color: white;
}

.add-category-button {
	background-color: green;
	color: white;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
}
.pageButton{
display:flex;
flex-direction: row;
    justify-content: center;
}
.pButton{
padding:10px;
marging:10px;
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
					<div class="dashboard">Categories</div>
					<div class="Home">Home/Categories</div>
				</div>
				<div class="rfp">

					<div class="home2">
						<p>Categories</p>
						<a href="./showCatPage" class="add-category-button">+ Add
							Category</a>
					</div>



					<table>
						<thead>
							<tr>
								<th>S.No.</th>
								<th>Categories Name</th>
								<th>Status</th>
								<th>Action</th>

								<!-- Add more table headers as needed -->
							</tr>
						</thead>

						<tbody>

							<c:set var="endInd" value="${(currInd+1)*5}" />
							<c:forEach var="cat" items="${cat}" begin="${currInd*5}"
								end="${endInd - 1}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${cat.categoryName}</td>
									<td><span
										style="background-color: ${cat.status ? 'green' : 'red'}; border-radius: 50px; padding: 5px;color: white; font-style: italic;">
											${cat.status ? 'Active' : 'Inactive'} </span></td>
									<td><a href="./changeCatSts?catId=${cat.categoriesId}"
										style="color: ${cat.status ? 'red' : 'green'}; font-style: italic;">
											${cat.status ? 'Deactivate' : 'Activate'} </a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				<!--	<div class="pageButton">
						<c:set var="itemsPerPage" value="5" />
						<c:set var="totalPages" value="${cat.size()/ 5+1 }" />

						<c:forEach var="pageIndex" begin="1" end="${totalPages}">
							<a href="#"><button class="pButton" >${pageIndex}</button></a>
						</c:forEach>
					</div>   -->


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
