<%--
  Created by IntelliJ IDEA.
  User: Ps1X
  Date: 01.07.2017
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="UserController" name="fromAddUser">
    User ID: <input type="text" readonly="readonly" name="id"
                    value="<c:out value="${user.id}" />" /> <br />
    First name: <input type="text" name="firstName"
                       value="<c:out value="${user.firstName}" />" /> <br />
    Last name: <input type="text" name="lastName"
                      value="<c:out value="${user.lastName}" />" /> <br />
    DOB: <input type="text" name="dob"
                value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br />
    Email: <input type="text" name="email"
                  value="<c:out value="${user.email}" />" /> <br />
    <input type="submit" value="Submit" />
</form>
</body>
</html>
