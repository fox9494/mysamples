<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用量统计</title>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
 function checkSubmit(){
 			document.getElementById("userName").value = document.getElementById("user").value;
			document.getElementById("queryName").value = document.getElementById("appName").value;						
			var search = document.getElementById("search_form");
			search.action = "<%=path %>/reports/sysFlowList!findAllSysFlowByConditions.shtml";
			search.submit();
	
	} 
	
    </script>
  </head>
      
  <body>
  <form method="post" id="search_form" >
       <div>
      		 <label>客户名称</label>
       <select id="user" >
	       <option>张三</option>
	       <option>李四</option>
	       <option>曹操</option>
	       <option>测试</option>
       </select>
       		<label>应用名称</label>
       		<input  id="appName" type="text" name="appName"  ></input>        		 		
			<input name="userName" type="hidden" id="userName"></input>
			<input name="appName" type="hidden" id="queryName"></input>
      		 <input type="submit" value="查询" onclick="checkSubmit()"/></div>
     <table border="1">
     	<tr>
     		<td>客户名称</td>
     		<td>应用名称</td>  	
     		<td>上行流量</td>
     		<td>下行流量</td>
     	<tr>
     	<s:iterator value="pageBean.list" id = "sysflow">
     		<tr>
	     		<td><s:property value="#sysflow.TUserClient.userName"/></td>
	     		<td><s:property value="#sysflow.TApplication.appName"/></td>
	     		<td><s:property value ="#sysflow.upNum"/></td>
	     		<td><s:property value ="#sysflow.downNum"/></td>
     		</tr>
     	</s:iterator>
     </table>  				
				
				<div style=""><my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page></div>				
			</form>    
			
  </body>
</html>
