<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆界面</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
    	<br>
    	<div align="center">
	    	<tr>
	    		<td>用户名:</td>
	    		<td>
	    			<input class="userinput" type="text" name="username">
	    		</td>
	    	</tr>
    	</div>
    	<br>
    	<div align="center">
	    	<tr>
	    		<td>登录密码：</td>
	    		<td>
	    			<input class="userinput" type="password" name="password">
	    		</td>
	    	</tr>
    	</div>
    	<br>
    	<div align="center">
    		<span><input class="btn" type="submit" name="login" value="登陆"></span>
    		&nbsp;&nbsp;
    		<span><input class="btn" type="reset" name="reset" value="重置"></span>
    	</div>
    </form>
  </body>
</html>
