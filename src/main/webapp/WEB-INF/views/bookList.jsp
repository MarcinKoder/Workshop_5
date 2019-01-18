<%--
  Created by IntelliJ IDEA.
  User: XxX
  Date: 18.01.2019
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book List</title>
</head>
<body>
<h1>Lista ksiazek</h1>
<c:forEach items="${listOfBooks}" var="book">
    Id: ${book.id}<br>
    Isbn: ${book.isbn}<br>
    Title: ${book.title}<br>
    Author: ${book.author}<br>
    Publisher: ${book.publisher}<br>
    Type: ${book.type}<br>
    <hr/>
</c:forEach>
</body>
</html>
