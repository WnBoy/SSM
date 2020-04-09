<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/6
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

username:<fmt:message key="username"></fmt:message>
password:<fmt:message key="password"></fmt:message>
<br>
<br>

${sessionScope.user}
<br>
<br>
${requestScope.user}
<br>
${requestScope.names}
<br>
<br>
${requestScope.time}
<br>
<br>
hello world 请求成功
</body>
</html>
