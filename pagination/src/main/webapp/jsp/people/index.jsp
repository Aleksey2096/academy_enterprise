<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>People</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
</head>
<body>
<c:choose>
    <c:when test="${requestScope.people.records.size() > 0}">
        <table>
            <tr>
                <th>&#8470;</th>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th></th>
                <th></th>
            </tr>
            <c:set var="previousRecordsNum" scope="page"
                   value="${(requestScope.people.currentPage-1)*requestScope.people.recordsPerPage}"/>
            <c:forEach var="elem" items="${requestScope.people.records}" varStatus="status">
                <tr>
                    <td>${previousRecordsNum+status.count}</td>
                    <td>${elem.id}</td>
                    <td>${elem.name}</td>
                    <td>${elem.surname}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                            <input type="hidden" name="command" value="get_person_edit_form">
                            <input type="hidden" name="id" value=${elem.id}>
                            <button type="submit">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                            <input type="hidden" name="command" value="delete_person">
                            <input type="hidden" name="id" value=${elem.id}>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <t:serverPagination command="${requestScope.command}"
                            currentPage="${requestScope.people.currentPage}"
                            recordsPerPage="${requestScope.people.recordsPerPage}"
                            pagesNum="${requestScope.people.pagesNum}"/>
    </c:when>
    <c:otherwise>
        <div class="emptyList">
            <h1>No people added yet!</h1>
        </div>
    </c:otherwise>
</c:choose>


<form class="addForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
    <input type="hidden" name="command" value="get_person_create_form">
    <button class="red" type="submit"><i class="icon ion-md-lock"></i>Add new person</button>
</form>


<%--<input type="hidden" name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"/>--%>
</body>
</html>
