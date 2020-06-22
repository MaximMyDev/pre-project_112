<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 04.06.2020
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>PrePoject 1 - CRUD <!--$Title$--></title>
  </head>

  <header>
    <div>
      <h1>PrePoject 1 - CRUD System (index)</h1> </br>
    </div>
    <ul>
      <li><a href="<%=request.getContextPath()%>/new" class="nav-link">Add New</a></li>
      <li><a href="<%=request.getContextPath()%>/show" class="nav-link">Show Users</a></li>
    </ul>
    <br>
  </header>

  </body>

</html>