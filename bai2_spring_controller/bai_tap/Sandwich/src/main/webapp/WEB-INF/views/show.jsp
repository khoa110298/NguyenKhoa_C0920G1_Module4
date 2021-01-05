<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 1/5/2021
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h3>Sandwich condiment:</h3>
<c:forEach var="condiment" items="${condiments}">
    <h3> ${condiment}</h3>
</c:forEach>
</body>
</html>
