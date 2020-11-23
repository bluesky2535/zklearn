<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 2020/11/22
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginController/login" method="post">
    用户名：<input type="text" name="userName"> <br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
