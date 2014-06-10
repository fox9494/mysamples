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
	<style>
html, body {
	width : 100%;
	height : 100%;
	padding : 0;
	margin : 0;
	overflow : hidden;
}


</style>
<link href="<%=path %>/css/tab/core.css" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/css/tab/TabPanel.css" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/css/tab/Toolbar.css" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/css/tab/WindowPanel.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path %>/js/tab/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab/Fader.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab/TabPanel.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab/Math.uuid.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab/Toolbar.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab/WindowPanel.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab/Drag.js"></script>
</head>

<body>
	<script type="text/javascript">
	
		/////////////////////////////////////////////////////////////////
		var tabpanel;
		var toolbar;
		var openedId=-1;
		$(document).ready(function(){
		  tabpanel = new TabPanel({
			renderTo:'tab',
			autoResizable:true,
			border:'none',
			active : 0,
			maxLength : 10,
			items : []
			});
		});
		
		function addtab(url,title){
			if(openedId == title){
			var tabposition = tabpanel.getTabPosision(openedId);
			if(tabposition>=0){
			tabpanel.kill(tabposition);
			}
			}else{
			openedId = title;
			}
		
		  	tabpanel.addTab({id:title,title:title, html:'<iframe src="'+url+'" width="100%" height="100%" frameborder="0"></iframe>'});
		}
	
	</script>
	
	<div id="tab" style="width:400px;"></div>

  </body>
</html>
