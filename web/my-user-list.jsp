<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 16.06.2020
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Show All User</title>
</head>
<body>
<h1>PrePoject 1 - CRUD System (user-list)</h1> </br>

<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${allUser}" var="users">
    <tr>
        <td><c:out value="${users.id}" /></td>

        <td><c:out value="${users.name}" /></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
