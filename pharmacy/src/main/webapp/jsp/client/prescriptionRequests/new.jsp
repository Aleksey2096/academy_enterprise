<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.uploadNewPrescriptionRequestScanPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.uploadPrescriptionRequestScan" bundle="${rb}"/></h2>

    <form method="post" action="${pageContext.request.contextPath}/dispatcher" enctype="multipart/form-data">
        <input type="hidden" name="command" value="save_new_prescription_request">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">


        <div class="user-box">
            <input id="avatarInput" type="file" name="image">
            <label for="avatarInput"><fmt:message key="text.enterScan" bundle="${rb}"/></label>
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