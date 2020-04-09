<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/6
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>


<a href="testRedirect">testRedirect</a>
<br><br>
<a href="testForward">testForward</a>
<br><br>

<!--
    模拟修改操作
    1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
    2. 密码不能被修改.
    3. 表单回显, 模拟操作直接在表单填写对应的属性值
-->
<form action="testModelAttribute" method="Post">
    <input type="hidden" name="id" value="1"/>
    username: <input type="text" name="username" value="Tom"/>
    <br>
    email: <input type="text" name="email" value="tom@atguigu.com"/>
    <br>
    age: <input type="text" name="age" value="12"/>
    <br>
    <input type="submit" value="Submit"/>
</form>
<br><br>


<a href="testSessionAttributes">testSessionAttributes</a>
<br>

<%--put请求--%>
<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="TestRest PUT"/>
</form>
<br><br>
<%--delete请求--%>
<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="TestRest DELETE"/>
</form>
<br><br>
<%--post请求--%>
<form action="testRest" method="post">
    <input type="submit" value="TestRest POST"/>
</form>
<br><br>
<%--get请求--%>
<a href="testRest/1">Test Rest Get</a>
<br><br>
<br>
<br>

<a href="testModelMap">testModelMap</a>
<br>
<br>
<a href="testModel">testModel</a>
<br>
<br>
<a href="testMap">testMap</a>
<br>
<br>

<a href="testModelAndView">testModelAndView</a>


<br>
<br>
<form action="testModelAttribute" method="post">
    username：<input type="text" name="username"><br>
    password：<input type="password" name="password"><br>
    sex：<input type="text" name="sex"><br>
    email：<input type="text" name="email"><br>
    age：<input type="text" name="age"><br>
    city：<input type="text" name="address.city"><br>
    province：<input type="text" name="address.province"><br>
    <input type="submit">
</form>

<hr>

<a href="helloworld"> Hello world </a>
<br>
<a href="testPathVariable/5">测试testPathVariable</a>
<br>
<a href="testRequestParam?name=miaomiao&age=18">测试testRequestParam</a>

testCookieValue
<br>
<a href="testCookieValue">测试testCookieValue</a>


</body>
</html>
