<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>跳转</title>
  </head>
  <body>
  	<script type="text/javascript">
  		window.top.location.href="<%=basePath%>manager/index1.jsp";
  	</script>
  </body>
</html>
