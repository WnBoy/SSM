<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/10
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="testList">
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <c:forEach items="${requestScope.items}" var="item" varStatus="s">
        <tr>
            <td><input type="text" name="items[${s.index}].id" value="${item.id}"></td>
            <td><input type="text" name="items[${s.index}].name" value="${item.name}"></td>
            <td><input type="text" name="items[${s.index}].price" value="${item.price}"></td>
        </tr>
    </c:forEach>
</table>
    <input type="submit">
</form>
</body>
</html>
