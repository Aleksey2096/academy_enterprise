<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.pharmacistEditProducerPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.editProducer" bundle="${rb}"/></h2>

    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="save_updated_producer">
        <input type="hidden" name="producer_id" value="${requestScope.producer.id}">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">


        <div class="user-box">
            <input id="companyNameInput" type="text" name="companyName" value="${requestScope.producer.companyName}">
            <label for="companyNameInput"><fmt:message key="text.editCompanyName" bundle="${rb}"/></label>
        </div>
        <div class="user-box">
            <select id="countrySelect" name="country">
                <c:forEach items="${requestScope.countries}" var="countryElem">
                    <c:choose>
                        <c:when test="${countryElem eq requestScope.producer.country}">
                            <option value="${countryElem}" selected>${countryElem}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${countryElem}">${countryElem}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <label for="countrySelect"><fmt:message key="text.selectCountry" bundle="${rb}"/></label>
        </div>
        <div class="user-box">
            <fmt:formatDate var="parsedCreationDate" value="${requestScope.producer.creationDate}"
                            pattern="yyyy-MM-dd"/>
            <input id="creationDateInput" type="date" name="creationDate" value="${parsedCreationDate}">
            <label for="creationDateInput"><fmt:message key="text.editCreationDate" bundle="${rb}"/></label>
        </div>


        <a class="leftButton" href="#" onclick="this.closest('form').submit();return false;">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <fmt:message key="text.save" bundle="${rb}"/>
        </a>
        <a class="rightButton" href="${pageContext.request.contextPath}${requestScope.previousRequestLink}">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <fmt:message key="text.cancel" bundle="${rb}"/>
        </a>

    </form>

</div>

</body>
</html>