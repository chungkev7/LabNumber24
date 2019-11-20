<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Welcome to GC Coffee</h1>

	<a class = "btn btn-primary" href="register">Register</a>
	
	<table class="table">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<tr>
		<c:forEach var="p" items="${productsList}">
				<tr>
					<td>${p.name}</td>
					<td>${p.quantity} lb. ${p.description}</td>
					<td>$${p.price}</td>
				</tr>
		</c:forEach>
		</tr>
	</table>
	
		<form action = "search-name">
		<input type = "text" name = "name" value = "${name}" placeholder = "Search by name">
		<input type = "submit" value = "Search">
		<c:if test="${not empty name}">
			<a href = "/" class = "btn btn-primary">Clear</a>
		</c:if>
		</form>

	</div>
</body>
</html>