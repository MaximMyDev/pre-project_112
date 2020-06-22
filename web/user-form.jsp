<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 04.06.2020
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>PrePoject 1 - CRUD</title>
</head>

<body>
<header>
    <div>
        <h1>PrePoject 1 - CRUD System (user-form)</h1> </br>
        <ul>
            <li><a href="<%=request.getContextPath()%>/index.jsp" class="nav-link">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/show">Show User</a></li>
        </ul>
    </div>
</header>
<br>
<div>
    <div>
        <div>
            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>

                    <fieldset>
                        <label>User Name</label> <input type="text" value="<c:out value='${user.name}' />" name="name" required="required">
                    </fieldset>

                    <fieldset>
                        <label>User Email</label> <input type="text" value="<c:out value='${user.email}' />" name="email">
                    </fieldset>

                    <fieldset>
                        <label>User Country</label> <input type="text" value="<c:out value='${user.country}' />" name="country">
                    </fieldset>

                    <button type="submit">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>