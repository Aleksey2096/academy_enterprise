<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>New person</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formStyle.css">
</head>
<body>
<div class="login-box">
    <h2>Add person</h2>

    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="save_new_person">

        <div class="user-box">
            <input id="nameInput" type="text" name="name">
            <label for="nameInput">Enter name</label>
        </div>
        <div class="user-box">
            <input id="surnameInput" type="text" name="surname">
            <label for="surnameInput">Enter surname</label>
        </div>
        <a class="leftButton" href="#" onclick="this.closest('form').submit();return false;">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Save
        </a>
        <a class="rightButton" href="${pageContext.request.contextPath}/index.jsp">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Cancel
        </a>

    </form>

</div>
</body>
</html>
