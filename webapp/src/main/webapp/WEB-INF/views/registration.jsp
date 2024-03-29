<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

	.error {
		color: #ff0000;
	}
</style>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="clientEntity">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>


			<tr>
				<td><label for="password">Password: </label> </td>
				<td><form:password path="password" id="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
	    
			<tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="cardNumber">CardNumber: </label> </td>
				<td><form:input path="cardNumber" id="cardNumber"/></td>
				<td><form:errors path="cardNumber" cssClass="error"/></td>
		    </tr>

	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/' />">List of All Clients</a>