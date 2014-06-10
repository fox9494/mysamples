<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<a href="top.jsp" target="right">top</a>
<a href="content.jsp" target="right">content</a>
<a href="left.jsp" target="right">left</a>
