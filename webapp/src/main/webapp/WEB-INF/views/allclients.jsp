<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>Name</td>
                    <td>Email</td>
                    <td>CardNumber</td>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${clientEntities}" var="clientEntity">
                    <tr>

                        <td><span>${clientEntity.name}</span></td>
                        <td><span>${clientEntity.email}</span></td>
                        <td><span>${clientEntity.cardNumber}</span></td>
                        <td>
                            <button type="button" onclick="javascript:location.href='<c:url
                                    value='/edit-${clientEntity.name}-clientEntity'/>'"
                                    class="btn btn-success custom-width">Edit
                            </button>
                            <button type="button" onclick="javascript:location.href='<c:url
                                    value='/delete-${clientEntity.name}-clientEntity'/>'"
                                    class="btn btn-danger custom-width">Remove
                            </button>
                        </td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <button type="button" onclick="javascript:location.href='<c:url
                    value='/new'/>'"
                    class="btn btn-success custom-width">Add New
            </button>
        </div>
    </div>
</div>