<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.Exception" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>


<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>framework</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>

<body>

<div class="container">


<% Exception ex=(Exception)request.getAttribute("exception");
  ex.printStackTrace(new PrintWriter(out));
%>

   <%--  异常信息:${exception.message} --%>
</div>
</body>

</html>
