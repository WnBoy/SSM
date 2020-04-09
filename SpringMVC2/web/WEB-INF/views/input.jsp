<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/7
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--
		1. WHY 使用 form 标签呢 ?
		可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
		2. 注意:
		可以通过 modelAttribute 属性指定绑定的模型属性,
		若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
		如果该属性值也不存在，则会发生错误。
	-->
<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
    <!-- path 属性对应 html 表单标签的 name 属性值 -->

    <c:if test="${empty requestScope.employee.id}">
        <%--id为空说明是添加操作--%>
        LastName:LastName:<form:input path="lastName"/>
        <form:errors path="lastName"></form:errors>
    </c:if>
    <c:if test="${not empty requestScope.employee.id}">
        <form:hidden path="id"/>
        <input type="hidden"name="_method" value="PUT">
        <%-- 对于 _method 不能使用 form:hidden 标签,
        因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
        <%--form:hidden path="_method" value="PUT"/>--%>
    </c:if>
    <br>
    Email:<form:input path="email"/>
    <form:errors path="email"></form:errors>
    <br>
    <%
        Map<String,String>map=new HashMap<String,String>();
        map.put("1","Male");
        map.put("0","Female");
        request.setAttribute("genders",map);
    %>
    Gender:
    <br>
    <form:radiobuttons path="gender" items="${requestScope.genders}" delimiter="<br>"/>
    <br>
    Department:<form:select path="department.id" items="${departments}"
                            itemLabel="departmentName" itemValue="id"/>
    <br>
    Birth: <form:input path="birth"/>
    <form:errors path="birth"></form:errors>
    <br>
    Salary: <form:input path="salary"/>
    <form:errors path="salary"></form:errors>
    <br>
    <input type="submit">
</form:form>

</body>
</html>
