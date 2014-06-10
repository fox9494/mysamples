<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>应用安装统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	
	<!-- select 可编辑并自动提示所需css和js引入，select必须加id="combobox" 如果有对齐问题可在select外套上div且class="ui-widget"  -->
	<LINK rel="stylesheet" href="js/combobox_files/jquery-ui.css" type="text/css" />	 
	<LINK rel="stylesheet" href="js/combobox_files/style.css" type="text/css" />	 
	<SCRIPT type="text/javascript" src="js/combobox_files/jquery-ui.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="js/combobox_files/combobox.js"></SCRIPT>

	<style type="text/css">
		input {
			height: 24px;
			width: 140px;
		}
		ul li {
			float: left;
			margin-right: 30px;
			list-style:none;
		}
		.ui-autocomplete {
			width:156px;
			overflow:auto;
			height: 80%;
		}
	</style>


  </head>
  
  <body>
  	<br/>
    <div class="main">
    <form action="<%=path %>/reports/userAppStatistics.shtml" method="post" >
    <div class="ui-widget" >
    	<ul>  			
    		<li style="width: 220px">
    			应用名称
	    			<input type="text" name="appName" value="${appName}"/>
    		</li> 			
   			<li style="width: 120px">
   				<input value="查询"  type="submit" class="button" />
   			</li>   		
    	</ul>
    </div>   	   	
    <div class="list">
	    	<table cellspacing="0" border="0">
    			<tr class="head"> 			
    				<td>应用名称</td>
    				<td>安装量</td>
    			</tr>
     			<c:forEach items="${pageBean.list }" var="data">
    				<tr>
						<td>${data[0]}</td>
						<td>${data[1]}</td> 			  				
					</tr>
    			</c:forEach> 
    		</table>
    		<div >
    			<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
    		</div>
    	</div>
    </form>
   </div>
  </body>
</html>
