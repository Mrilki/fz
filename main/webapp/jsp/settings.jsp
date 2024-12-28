<%--
  Created by IntelliJ IDEA.
  User: kim85
  Date: 14.12.2024
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: ${cookie.get("color").value}">Hello!</h1>
<div>
  <form action="/settings" method="post">
    <select size="3" name="color">
      <option value="red">Red</option>
      <option value="green">Green</option>
      <option value="black">Black</option>
      <option value="blue">Blue</option>
    </select>
    <input type="submit" value="Save color">
  </form>
</div>
</body>
</html>
