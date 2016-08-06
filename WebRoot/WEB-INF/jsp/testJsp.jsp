<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'testJsp.jsp' starting page</title>
  </head>
  
  <body>
    <form action="/SimpleLogin/servlet/testRegisterServlet" method="post">
    	<td class="td1">登陆账号：</td>
		<td>
	  		<input class="userinput" type="text" name="username">
	  	</td>
	  	<%--文本会在br标签处换行 --%>
	  	<br></br>
	  	<div>
	  		<input class="btn" type="submit" name="submit" value="提交">
	  	</div>		
    </form>
  </body>
</html>

	  				