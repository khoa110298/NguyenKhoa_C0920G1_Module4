<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 1/5/2021
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>calculate</title>
  </head>
  <body>
  <form action="/calculate" method="post">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <br>
    <input type="submit" value="+" name="calculation">
    <input type="submit" value="-" name="calculation">
    <input type="submit" value="x" name="calculation">
    <input type="submit" value="/" name="calculation">

    <h2>${firstNumber} ${calculation} ${secondNumber} = ${result}</h2>
    <h2 style="color: red">${message}</h2>
  </form>
  </body>
</html>
