<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>赚客网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
	 <frameset rows="80px,*,47px"  cols="1280" frameborder="no" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" >
		     <frame src="<%=path %>/jsp/frame/top.jsp" noresize="noresize" name="topFrame" scrolling="no" marginwidth="0" marginheight="0"  border="0" framespacing="0" 
		        target="mainFrame" style="border-bottom:1px solid rgb(185, 183, 183);"/>
		     <frameset cols="206,*" id="frame" name="frame" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" >
		        <frame src="<%=path %>/jsp/frame/left.jsp" id="leftFrame" name="leftFrame" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" 
		            target="mainFrame" style="border-right:1px solid rgb(185, 183, 183);"/>
		             <frameset rows="*,100%" id="frame_main" name="frame_main" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" >
		            		 <!--tab-->
		             		 <frame src="<%=path %>/jsp/frame/tab.jsp" id="mainFrame_tab" name="mainFrame_tab"  target="_self" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" style="padding:8px 8px 0 8px;"/>
		             		 <!--无tab-->
		             		 <frame src="<%=path %>/jsp/frame/main.jsp" id="mainFrame" name="mainFrame"  target="_self" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" style="padding:8px 8px 0 8px;"/>
		             </frameset>
		       
		    </frameset>
		      <frame src="<%=path %>/jsp/frame/bottom.jsp" noresize="noresize" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" border="0" framespacing="0" 
		        target="mainFrame" />
	   </frameset>
</html>
