<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'accord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.9.2.custom.js"></script>
	
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui-1.9.2.custom.css">
	
	<script type="text/javascript">
		$(function(){ 
		   $("#nav").accordion({
      			heightStyle: "content",
      			collapsible: true,
      			closedSign: '[+]', 
        		openedSign: '[-]' 
    		});
		   
		});  
	
	</script>

  </head>
  
  <body>
    
    	 <ul id="nav"> 
		   <li><a href="http://www.helloweba.com">首页</a></li> 
		   <li><a href="#">服务</a>
		   		<ul> 
		            <li><a href="#">Cookies</a></li> 
		            <li><a href="#">Event</a></li>
		        </ul> 
		   </li> 
		   <li><a href="#">案例</a></li> 
		   <li><a href="#">文章</a> 
		        <ul> 
		           <li><a href="#" target="_blank">XHTML/CSS</a></li> 
		           <li><a href="#">Javascript/Ajax/jQuery</a>
		                <ul> 
		                    <li><a href="#">Cookies</a></li> 
		                    <li><a href="#">Event</a></li> 
		                    <li><a href="#">Games</a></li> 
		                    <li><a href="#">Images</a></li> 
		                </ul> 
		            </li> 
		            <li><a href="#" target="_blank">PHP/MYSQL</a></li> 
		            <li><a href="#" target="_blank">前端观察</a></li> 
		            <li><a href="#" target="_blank">HTML5/移动WEB应用</a></li> 
		        </ul> 
		    </li> 
		    <li><a href="#">关于</a></li> 
		</ul> 
  </body>
</html>
