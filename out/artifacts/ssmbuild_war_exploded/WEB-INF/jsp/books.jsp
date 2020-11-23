<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>书籍展示</title>
</head>
<body>
<c:forEach var="book" items="${list}">
    ${book.id}
    ${book.name}
    ${book.author}
</c:forEach>
</body>
</html>
