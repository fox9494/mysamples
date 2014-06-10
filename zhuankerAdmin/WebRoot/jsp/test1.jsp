<%@ page language="java" pageEncoding="utf-8"%>

<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
request.setAttribute("_path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'test.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.jstree.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.cookie.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
	
	<script type="text/javascript">
		$(function () { 
		 	 $.ajaxSetup({cache:false});
		     $("#demo1").jstree({   
		         "json_data" : {   
		             "ajax" : {  
		                 "url" : "${_path}/login/getdata.shtml",  
		                 "data" : function (n) {   
		                     return { name : n.attr ? n.attr("id") : 0 };   
		                 }  
		             }  
		         },
		         
		         "contextmenu":{"items":{"delete":{"label":"删除"},"create":{"label":"新增"},"rename":{"label":"重命名"}}},
		         "plugins" : [ "themes", "json_data","checkbox","contextmenu","ui" ]  
		     }).bind("select_node.jstree", function (e, data) { alert(data.rslt.obj.attr("id"));});
		 });

	
	
	</script>
  </head>
  
  <body>
  
     <div id="demo1" class="demo jstree jstree-1 jstree-default jstree-focused" style="width: 200px">
     </div>
   
  </body>
</html>
