<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/10
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="testParameter" method="post">
    性别选择：
    <input type="radio" name="sex" value="nan">男
    <input type="radio" name="sex" value="nv" checked="checked"/>女<br/>
    选择技术：
    <input type="checkbox" name="tec" value="java" />JAVA
    <input type="checkbox" name="tec" value="heml"/>HTML
    <input type="checkbox" name="tec" value="css"/>CSS<br/>
    <select name="country">
        <option value="non">选择国家</option>
        <option value="cn" selected="selected">中国</option>
        <option value="us">美国</option>
        <option value="ff">法国</option>
    </select><br/>
    <input type="submit">
</form>


</body>
</html>
