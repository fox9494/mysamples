<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		.bottom{
			text-align: center;
			line-height: 43px;
			color: #666666;
			font-size: 14px;
		  }
	</style>
  </head>
  
  <body style="background-image:url(<%=path %>/images/bg_2_10.jpg);background-repeat:x-repeat;">
    <div id="bottom_wraper">
		<div class="bottom">CopyRight ©2013 赚客网后台管理系统</div>
	</div>
  </body>
</html>
