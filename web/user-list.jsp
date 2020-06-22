<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 04.06.2020
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>PrePoject 1 - CRUD</title>
    <style type="text/css">
        TABLE {
            width: 80%;                     /* Ширина таблицы */
            border-collapse: collapse;      /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px;                   /* Поля вокруг содержимого таблицы */
            border: 1px solid black;        /* Параметры рамки */
        }
        /*TH { background: #b0e0e6;            Цвет фона  }*/
    </style>
</head>

<body>

<header>
    <div>
        <h1>PrePoject 1 - CRUD System (user-list)</h1> </br>
        <ul>
            <li><a href="<%=request.getContextPath()%>/index.jsp" class="nav-link">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/new">Add New User</a></li>
        </ul>
    </div>
</header>
<br>

<div>
    <div>
        <h3>List of Users (user-list)</h3>
        <hr>
        <br>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td>
                        <c:out value="${user.id}" />
                    </td>

                    <td>
                        <c:out value="${user.name}" />
                    </td>

                    <td>
                        <c:out value="${user.email}" />
                    </td>

                    <td>
                        <c:out value="${user.country}" />
                    </td>

                    <td>
                        <a href="edit?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>

</html>