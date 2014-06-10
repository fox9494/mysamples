<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/top.css" type="text/css" media="screen" />
	<script type="text/javascript">
			function exit(){
			   top.location.href="<%=path%>/login/loginOut.shtml";
			}
			
			//修改密码
			function changePass(){
			    window.top.frames['leftFrame'].opentab("<%=path%>/admin/changePass.shtml?id="+<%=session.getAttribute("session.security.userId") %>,"密码修改");
			}
	</script>

  </head>
  
  <body>
 	<div id="top_wraper">
    <div id="top_left"><img id="img_logo" src="../../images/logo.jpg"/></div>
 	<div id="top_left"><img id="img_logo" src="../../images/logozi.jpg"/></div>
    <div id="top_right_wraper">
	  <div id="top_right" ><label class="p12">欢迎你，<%=session.getAttribute("session.security.userName") %></label><br /><br /><input type="button" class="button" value="修改密码" onclick="changePass()">
	  <input type="button" class="button" value="退出" onclick="exit()">
	  </div>
	  <div id="top_right" ><img src="../../images/person.jpg"/></div>
	</div>
    </div>
  </body>
</html>
