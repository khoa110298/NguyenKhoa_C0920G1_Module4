<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 1/5/2021
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>email</title>
</head>
<body>
<h1>Settings</h1>
<form:form method="post" action="email" modelAttribute="email">
Langguege:
<form:select path="languege" items="${language}"/><br><br>
Page Size: Show
<form:select path="page" items="${page}"/> emails per page<br><br>
    Spams Filter: 
    <form:radiobutton path="spams" value="true" label="Enable spamsfilter"/><br><br>
    Signature:
    <form:input type="text" path="signature"/><br><br>
    <form:button type="submit">update</form:button>
    <form:button>cancle</form:button>
</form:form>

</body>
</html>
