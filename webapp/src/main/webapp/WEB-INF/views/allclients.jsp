<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>List of Clients</h2>
<table>
    <tr>
        <td>NAME</td>
        <td>Email</td>
        <td>CardNumber</td>
        <td></td>
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