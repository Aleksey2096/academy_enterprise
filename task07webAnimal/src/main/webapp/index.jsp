<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Index page</title>
</head>
<body>

<jsp:forward page="/dispatcher">
    <jsp:param name="command" value="read_animals"/>
</jsp:forward>

</body>
</html>
