<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hotel Guests</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Clients</h2>
	<table>
		<tr>
			<td>NAME</td><td>Email</td><td>CardNumber</td><td></td>
		</tr>
		<c:forEach items="${clientEntities}" var="clientEntity">
			<tr>
			<td>${clientEntity.name}</td>
			<td>${clientEntity.email}</td>
			<td>${clientEntity.cardNumber}</td>
			<td><a href="<c:url value='/edit-${clientEntity.name}-clientEntity' />">edit</a></td>
			<td><a href="<c:url value='/delete-${clientEntity.name}-clientEntity' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Client</a>
</body>
</html>