<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 16.06.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add User</title>
    <style type="text/css">
        TABLE {
            width: 80%;                     /* Ширина таблицы */
            border-collapse: collapse;      /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px;                   /* Поля вокруг содержимого таблицы */
            border: 0px solid black;        /* Параметры рамки */
        }
    </style>
</head>
<body>


<h1>PrePoject 1 - CRUD System (user-new)</h1> </br>

<form action="addnew" method="post">
    <table>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>

    <label>Name:</label>

    <label><input type="text" value="<c:out value='${user.name}' />" name="name" required="required"></label>

    <label><button type="submit">Add User</button></label>
</form>

</body>
</html>
