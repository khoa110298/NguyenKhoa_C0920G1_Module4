<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 1/4/2021
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>The World Clock</title>
  </head>
  <body>
  <h2>Current Local Times Around the World</h2>
  <span>Current time in ${city}: <strong>${date}</strong></span>
  <form id="locale" action="worldclock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()">
      <option value="Asia/Ho_Chi_Minh" >Ho Chi Minh</option>
<%--      <option value="Asia/Ho_Chi_Minh" selected>Ho Chi Minh</option>--%>
      <option value="Singapore" ${city == 'Singapore' ? 'selected':''}>Singapore</option>
      <option value="Hong_Kong" ${city == 'Hong_Kong' ? 'selected':''}>Hong Kong</option>
      <option value="Asia/Tokyo" ${city == 'Asia/Tokyo' ? 'selected':''}>Tokyo</option>
      <option value="Asia/Seoul" ${city == 'Asia/Seoul' ? 'selected':''}>Seoul</option>
      <option value="Europe/London" ${city == 'Europe/London' ? 'selected':''}>London</option>
      <option value="Europe/Madrid" ${city == 'Europe/Madrid' ? 'selected':''}>Madrid</option>
      <option value="America/New_York" ${city == 'America/New_York' ? 'selected':''}>New York</option>
      <option value="Australia/Sydney" ${city == 'Australia/Sydney' ? 'selected':''}>Sydney</option>
      <option value="Argentina/Buenos_Aires" ${city == 'Argentina/Buenos_Aires' ? 'selected':''}>Buenos Aires</option>
    </select>
  </form>
  </body>
</html>
