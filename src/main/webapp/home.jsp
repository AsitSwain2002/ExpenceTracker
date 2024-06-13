<%@page import="com.Dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/home.css">
<title>Home</title>
</head>
<body>
	<header>
		<nav></nav>
	</header>
	<main>
		<div class="mainBox">
			<div class="inBox">
				<div class="moneyBox">
					<%
					HttpSession session1 = request.getSession();
					User user = (User) session1.getAttribute("user");
					%>
					<div class="money">
						Price:<%=user.getMoney()%></div>
				</div>
				<div class="headingBox">
					<div class="subBox1">Date</div>
					<div class="subBox2">Expences</div>
					<div class="subBox3">Price</div>
				</div>
				<c:forEach var="users" items="${expenceList }">
					<div class="contentBox">
						<div class="subBox4">${users.getDate()}</div>
						<div class="subBox5">${users.getExpence()}</div>
						<div class="subBox6">-${users.getPrice()}</div>
					</div>
				</c:forEach>
			</div>
			<div class="submit">
				<a href="addmoney.jsp"><button class="subBtn">Add
						Details</button></a>
			</div>
		</div>
	</main>
</body>
</html>