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
                <th>
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=asc&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage}">
                            ∧
                        </a>
                    </span>
                    Id
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=desc&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage}">
                            ∨
                        </a>
                    </span>
                    <form class="searchForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.people.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.people.orderType}">
                        <input type="hidden" name="searchField" value="id">
                        <label class="searchLabel">
                            <input class="searchInput" type="text" name="searchValue">
                        </label>
                        <input type="hidden" name="recordsPerPage" value="${requestScope.people.recordsPerPage}">
                        <input type="hidden" name="currentPage" value="1">
                        <button type="submit">Search</button>
                    </form>
                </th>
                <th>
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=name&orderType=asc&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage}">
                            ∧
                        </a>
                    </span>
                    Name
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=name&orderType=desc&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage}">
                            ∨
                        </a>
                    </span>
                    <form class="searchForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.people.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.people.orderType}">
                        <input type="hidden" name="searchField" value="name">
                        <label class="searchLabel">
                            <input class="searchInput" type="text" name="searchValue">
                        </label>
                        <input type="hidden" name="recordsPerPage" value="${requestScope.people.recordsPerPage}">
                        <input type="hidden" name="currentPage" value="1">
                        <button type="submit">Search</button>
                    </form>
                </th>
                <th>
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=surname&orderType=asc&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage}">
                            ∧
                        </a>
                    </span>
                    Surname
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=surname&orderType=desc&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage}">
                            ∨
                        </a>
                    </span>
                    <form class="searchForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.people.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.people.orderType}">
                        <input type="hidden" name="searchField" value="surname">
                        <label class="searchLabel">
                            <input class="searchInput" type="text" name="searchValue">
                        </label>
                        <input type="hidden" name="recordsPerPage" value="${requestScope.people.recordsPerPage}">
                        <input type="hidden" name="currentPage" value="1">
                        <button type="submit">Search</button>
                    </form>
                </th>
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
                            <input type="hidden" name="previousRequestLink"
                                   value="/dispatcher?${pageContext.request.queryString}"/>
                            <input type="hidden" name="id" value=${elem.id}>
                            <button type="submit">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                            <c:choose>
                                <c:when test="${requestScope.people.records.size() > 1}">
                                    <input type="hidden" name="previousRequestLink"
                                           value="/dispatcher?${pageContext.request.queryString}"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="hidden" name="previousRequestLink"
                                           value="/dispatcher?command=${requestScope.command}&orderField=${requestScope.people.orderField}&orderType=${requestScope.people.orderType}&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}&recordsPerPage=${requestScope.people.recordsPerPage}&currentPage=${requestScope.people.currentPage-1}"/>
                                </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="command" value="delete_person">
                            <input type="hidden" name="id" value=${elem.id}>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <t:serverPagination
                permanentParameters="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=${requestScope.people.orderField}&orderType=${requestScope.people.orderType}&searchField=${requestScope.people.searchField}&searchValue=${requestScope.people.searchValue}"
                currentPage="${requestScope.people.currentPage}"
                recordsPerPage="${requestScope.people.recordsPerPage}"
                pagesNum="${requestScope.people.pagesNum}"/>
    </c:when>
    <c:otherwise>
        <div class="emptyList">
            <h1>No people found! <a href="${pageContext.request.contextPath}/index.jsp">Back</a></h1>
        </div>
    </c:otherwise>
</c:choose>


<form class="addForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
    <input type="hidden" name="command" value="get_person_create_form">
    <input type="hidden" name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"/>
    <button class="red" type="submit"><i class="icon ion-md-lock"></i>Add new person</button>
</form>

</body>
</html>
