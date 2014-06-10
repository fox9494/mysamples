<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<title>赚客网</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
			.errorMessage{position: absolute;left: 100px;top: 30px;width:150px;text-align:left;}
		</style>
		<link rel="stylesheet" href="<%=path %>/css/login.css" type="text/css"/>
		
		<!-- 解决session超时跳出框架页面--> 
		<script type="text/javascript">
			if (window != top)   
				top.location.href = location.href; 
		</script>
	</head>
	
	
<body style="background:#7dc8f5">
   <div class="login" style="background:#7dc8f5">
     <div class="loginLogo"><img src="<%=path %>/images/top_1_1_03.jpg"/></div>
	  <div class="loginForm">
	   <form action="<%=path %>/login/loginIn.shtml" method="post">
	       <font  color="red" size="2px" style="position:relative;"><s:fielderror fieldName="failed"/></font>
	       <div><label>用户名:</label><span><input type="text" name="userName"/></span></div>
	       <div><label>密 &nbsp;码:</label><span><input type="password" name="password"/>
	       </span>	      
	       </div>
		   <div><input type="submit" value="登录" class="button"/></div>
	   
	   </form>	  
	  </div>
	 </div>
</body>
	
</html>
