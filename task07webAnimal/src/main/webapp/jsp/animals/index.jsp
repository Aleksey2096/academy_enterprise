<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Animals</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<c:choose>
    <c:when test="${requestScope.animals.size() > 0}">
        <table>
            <tr>
                <th>&#8470;</th>
                <th>Name</th>
                <th>Weight</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="elem" items="${requestScope.animals}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${elem.name}</td>
                    <td>${elem.weight}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                            <input type="hidden" name="command" value="get_animal_edit_form">
                            <input type="hidden" name="id" value=${elem.id}>
                            <button type="submit">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                            <input type="hidden" name="command" value="delete_animal">
                            <input type="hidden" name="id" value=${elem.id}>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <div class="emptyList">
            <h1>No animals added yet!</h1>
        </div>
    </c:otherwise>
</c:choose>
<form class="addForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
    <input type="hidden" name="command" value="get_animal_create_form">
    <button class="red" type="submit"><i class="icon ion-md-lock"></i>Add new animal</button>
</form>
</body>
</html>
