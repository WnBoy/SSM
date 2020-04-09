<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/9
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fmt:message key="username"></fmt:message>
<br><br>
<a href="i18n2">i18n2 Page</a>
<br><br>
<a href="i18n1?locale=zh_CN">中文</a>
<a href="i18n1?locale=en_US">英文</a>

</body>
</html>
