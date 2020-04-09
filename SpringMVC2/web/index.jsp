<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/7
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>

  </head>
  <body>


<a href="emps">获取所有的员工列表</a><br><br>

<br>

<script type="text/javascript">
  $(function () {
      $("a").click(function () {
          var url = this.href;
          var data={};
          $.post(url,data,function (data) {
            $.each(data,function (i,e) {
               console.log(e.id+","+e.lastName+","+e.email+","+e.gender);
            });
          },"json");
          return false;
      });
  });

</script>

<%--测试文件上传--%>
<form action="testFileUpload" method="post" enctype="multipart/form-data">
  file：<input type="file" name="file"><br>
  desc:<input type="text" name="desc">
  <input type="submit">
</form>

<br><br>
<%--测试json--%>
<a href="testJson">testJson</a>
<br><br>

<%--测试HttpMessageConverte--%>
<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
  file：<input type="file" name="file"><br>
  desc:<input type="text" name="desc">
  <input type="submit">
</form>
<br><br>

  <a href="testResponseEntity">testResponseEntity</a>
<br><br>

<!--
		关于国际化:
		1. 在页面上能够根据浏览器语言设置的情况对文本(不是内容), 时间, 数值进行本地化处理
		2. 可以在 bean 中获取国际化资源文件 Locale 对应的消息
		3. 可以通过超链接切换 Locale, 而不再依赖于浏览器的语言设置情况

		解决:
		1. 使用 JSTL 的 fmt 标签
		2. 在 bean 中注入 ResourceBundleMessageSource 的示例, 使用其对应的 getMessage 方法即可
		3. 配置 LocalResolver 和 LocaleChangeInterceptor
	-->

<a href="i18n1">i18n1 Page</a>
<br><br>
<%--测试ExceptionHandlerExceptionResolver--%>
  <a href="testExceptionHandlerExceptionResolver?id=10">testExceptionHandlerExceptionResolver</a>


  </body>
</html>
