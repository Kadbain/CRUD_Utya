<%--
  Created by IntelliJ IDEA.
  User: Ps1X
  Date: 01.07.2017
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>pokazhbl luserov</title>
</head>
<body>
<table border=1>
    <thead>
        <tr>
            <th> ID</th>
            <th> First Name</th>
            <th> Last Name</th>
            <th> D.O.B.</th>
            <th> Email</th>
            <th colspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><a href="UserController?action=edit&id=<c:out value="${user.id}"/> ">Update</a></td>
            <td><a href="UserController?action=delete&id=<c:out value="${user.id}"/> ">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="UserController?action=insert">Add User</a>
</body>
</html>
