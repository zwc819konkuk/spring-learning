<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 2022-11-11
  Time: PM 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    requestScope:msg:${requestScope.msg},uname:${requestScope.users[0].uname}<br/>
    sessionScope:msg:${sessionScope.msg},uname:${sessionScope.users[0].uname}<br/>
    applicationScope:msg:${applicationScope.msg},uname:${applicationScope.users[0].uname}<br/>
</body>
</html>
