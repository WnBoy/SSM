<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/7
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
</head>
<body>

<script type="text/javascript">
    $(function () {
        //删除操作
        $(".delete").click(function () {
            var href = $(this).attr("href");
            var text = $(this).parent().parent().find("td:eq(1)").text();
            if (confirm("确定要删除【" + text + "】吗？")) {
                $("#deleteForm").attr("action", href).submit();
           }
            return false;
        });
    });

</script>

<%--为删除操作专门写的form表单--%>
<form id="deleteForm" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<c:if test="${ empty requestScope.emps}">
    没有员工数据
</c:if>
<c:if test="${not empty requestScope.emps}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender==1?'Male':'Female'}</td>
                <td>${emp.department.departmentName}</td>
                <td><a href="emp/${emp.id}">Edit</a></td>
                <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="emp">添加员工</a>


</body>
</html>
