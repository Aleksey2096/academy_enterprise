<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.pharmacistAddMedicinePage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.addMedicine" bundle="${rb}"/></h2>

    <form method="post" action="${pageContext.request.contextPath}/dispatcher" enctype="multipart/form-data">
        <input type="hidden" name="command" value="save_new_medicine">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">


        <div class="user-box">
            <input id="titleInput" type="text" name="title">
            <label for="titleInput"><fmt:message key="text.enterTitle" bundle="${rb}"/></label>
        </div>

        <c:set var="booleanList" value="${['true','false']}"/>
        <div class="user-box">
            <select id="isNonprescriptionSelect" name="is_nonprescription">
                <c:forEach items="${booleanList}" var="booleanElem">
                    <option value="${booleanElem}">${booleanElem}</option>
                </c:forEach>
            </select>
            <label for="isNonprescriptionSelect"><fmt:message key="text.selectIsNonprescription"
                                                              bundle="${rb}"/></label>
        </div>


        <div class="user-box">
            <select id="producerSelect" name="producer_id">
                <c:forEach items="${requestScope.producers}" var="producerElem">
                    <option value="${producerElem.id}">${producerElem.companyName}</option>
                </c:forEach>
            </select>
            <label for="producerSelect"><fmt:message key="text.selectProducer" bundle="${rb}"/></label>
        </div>
        <div class="user-box">
            <input id="approvalDateInput" type="date" name="approval_date">
            <label for="approvalDateInput"><fmt:message key="text.enterApprovalDate" bundle="${rb}"/></label>
        </div>
        <div class="user-box">
            <input id="medicineImageInput" type="file" name="image">
            <label for="medicineImageInput"><fmt:message key="text.enterMedicineImage" bundle="${rb}"/></label>
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