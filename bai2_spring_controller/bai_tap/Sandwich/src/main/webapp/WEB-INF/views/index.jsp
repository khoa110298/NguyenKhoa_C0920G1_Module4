<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 1/4/2021
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h1>SandWich Condiments</h1>
  <form action="/save" method="get">
    <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="lettuce">
    <label>Tomato</label>
    <input type="checkbox" name="condiment" value="tomato">
    <label>Mustard</label>
    <input type="checkbox" name="condiment" value="mustard">
    <label>Sprouts</label>
    <input type="checkbox" name="condiment" value="sprouts">

    <input type="submit" value="Submit">
  </form>
  </body>
</html>
