<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ShowCalendar.js" charset="GBK"></script>
    <style>
    	body{
    		background-color:#32a8cf;
    		margin:Opx;
    		overflow:hidden;
    		font-size:14px;
    		color:#FFFFFF;
    	}
    	#main{
    		margin-left:50px;
    		margin-right:30px;
    	}
    	#notice{
    		width:70%;
    		line-height:25px;
    	}
    	#formtable{
    		font-size:15px;
    	}
    	.td1{
    		width:100px;
    	}
    	#formsubmit{
    		width:300px;
    		text-align:center;
    		margin-top:15px;
    		margin-left:50px;
    	}
    	.userinput{
    		width:210px;
    		height:25px;
    		background-color:#FFFFFF;
    		border:solid 1px #7dbad7;
    		font-size:16px;
    	}
    	.btn{
    		background-image:url(images/b2222.gif);
    		background-position:center;
    		font:bold 12px;
    		width:80px;
    		cursor:hand;
    		height:25px;
    		border-width:0;
    	}
    </style>
  </head>
  <body>
  	<div style="height:690px; overflow-y:auto; overflow-x:hidden;">
  	<div id="header">
  				<%--在jsp文件中使用EL表达式，表达式中存放有java代码表示的变量 --%>
  		<img src="${pageContext.request.contextPath}/images/b1111.png" width="150px" height="200px">
  	</div>
  	<div id="main">
  		<div id="notice">
  			<h2>注册须知：</h2>
  			<br/>1：在本站注册的会员，必须遵守。。。
  			<br/>2：在本站发表的文章，必须满足。。。
  		</div>
  		<br/><br/>
  		<form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
	  		<table id="formtable">
	  			<%--tr标签代表网页中的一行 --%>
	  			<tr>
	  				<%--td标签代表一样中的标准单元格 --%>
	  				<td class="td1">登陆账号：</td>
	  				<td>
	  					<input class="userinput" type="text" name="username" value="${form.username }">
	  					<span class="message">${form.errors.username}</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<td class="td1">密码：</td>
	  				<td>
	  					<input class="userinput" type="password" name="password" value="${form.password }">
	  					<span class="message">${form.errors.password}</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="td1">确认密码：</td>
	  				<td>
	  					<input class="userinput" type="password" name="password2" value="${form.password2 }">
	  					<span class="message">${form.errors.password2}</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="td1">电子邮箱：</td>
	  				<td>
	  					<input class="userinput" type="text" name="email" value="${form.email }">
	  					<span class="message">${form.errors.email}</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="td1">生日：</td>
	  				<td>
	  					<input class="userinput" type="text" name="birthday" value="${form.birthday }" id="birthday" title="点击选择" onClick="showCalendar(this.id)">
	  					<span class="message">${form.errors.birthday}</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="td1">您的昵称：</td>
	  				<td>
	  					<input class="userinput" type="text" name="nickname" value="${form.nickname }">
	  					<span class="message">${form.errors.nickname}</span>
	  				</td>
	  			</tr>
	  		</table>
	  		<%-- div标签的作用是涵盖一块区域，并且区域的前后都会换行--%>
	  		<div id="formsubmit">
	  			<%--span标签是在一行中划分出一个区域，使用div标签会自动换行，使用span会保持同行 --%>
	  			<%--input标签用来收集用户信息，包括多种type，比如text，btn --%>
	  			<span><input class="btn" type="reset" name="reset" value="重置"></span>
	  			&nbsp;&nbsp;
	  			<span><input class="btn" type="submit" name="submit" value="注册"></span>
	  		</div>
  		</form>
  	</div>
  	<div id="footer">
  	
  	</div>
  </div>
  </body>   
</html>
