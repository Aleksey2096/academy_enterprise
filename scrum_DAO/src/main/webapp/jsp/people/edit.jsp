<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit person</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<form class="editForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
    <input type="hidden" name="command" value="update">
    <input type="hidden" name="personId" value=${requestScope.person.id}>

    <div class="segment">
        <h1>Edit person</h1>
    </div>

    <label for="nameInput">
        <input id="nameInput" type="text" name="name" value=${requestScope.person.name}>
    </label>
    <label for="surnameInput">
        <input id="surnameInput" type="text" name="surname" value=${requestScope.person.surname}>
    </label>

    <button class="red" type="submit"><i class="icon ion-md-lock"></i>Save</button>
</form>
</body>
</html>