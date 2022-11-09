<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 2022-11-09
  Time: PM 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="getParamByArgName" >
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="no request">
</form>
<hr/>
<form action="getParamByRequest" >
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="request">
</form>
</body>
</html>
