<%@ page language="java" import="com.soarsky.octopus.utils.*" pageEncoding="utf-8"%>
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
	
	<link rel="stylesheet" href="<%=path %>/css/main.css" type="text/css"/>
	
	<script src="<%=path %>/js/jquery-1.8.3.js" type="text/javascript"></script>
	<script src="<%=path %>/js/jquery-ui-1.9.2.custom.js"></script>
	<script language="JavaScript" type="text/javascript">
	     var flag=$("#flag").val();
	</script>
	

  </head>
  
  <body>
    <div class="main_wraper">
    <div class="main_tab"><label>您好,<%=session.getAttribute("session.security.realName") %></label></div>
    <div class="main_content">
	  <label>欢迎你进入赚客网后台管理系统</label><br />
	  <label>今天是<%=DateUtil.getCurDateStr("yyyy-MM-dd")%></label>
	</div>
	</div>
</body>
  </body>
</html>
