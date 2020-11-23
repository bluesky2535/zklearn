<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 2020/11/23
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUploadController/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
