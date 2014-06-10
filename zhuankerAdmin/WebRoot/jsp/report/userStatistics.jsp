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
	
  </head>
  
  <body>
  <div class="main">
  	<center>
	  	<h4>赚客儿客户端统计信息</h4>
	  	<p>
	  	<span style="margin-right: 30px;">总注册用户:<input type="text" value="${userReportVo.registerUser_Count }" disabled="disabled" /></span>
	  	<span>总活跃用户:<input type="text" value="${userReportVo.activeUser_Count }" disabled="disabled" /> </span>
	  	</p>
  	</center>
    <form action="<%=path %>/reports/userStatistics.shtml" method="post" >
    	<div style="margin-left: 7px;">
    	<span>请选择统计类型<select name="statType" style="height: 24px; margin-left: 10px;margin-right: 30px;">
    		<option value="1" ${statType=="1"?"selected='selected'":"" } >一级渠道统计</option>
    		<option value="2" ${statType=="2"?"selected='selected'":"" } >地区统计</option>
    		<option value="3" ${statType=="3"?"selected='selected'":"" } >赚客级别统计</option>
    	</select></span>
    	<span><input value="统计" type="submit" class="button" /></span>
    	</div>
	    <div class="list">
		    	<table cellspacing="0" border="0">
	    			<tr class="head">
	    				<td>
		    				<c:choose>
		    					<c:when test="${statType == 1 }">渠道</c:when>
		    					<c:when test="${statType == 2 }">地区(省)</c:when>
		    					<c:when test="${statType == 3 }">赚客级别</c:when>
		    				</c:choose>
	    				</td>	
	    				<td>
	    					<c:choose>
		    					<c:when test="${statType == 1 }">注册用户</c:when>
		    					<c:when test="${statType == 2 }">注册用户</c:when>
		    					<c:when test="${statType == 3 }">人数</c:when>
		    				</c:choose>
	    				</td>
	    				<td>
	    			    	<c:choose>
		    					<c:when test="${statType == 1 }">活跃用户(最近一月)</c:when>
		    					<c:when test="${statType == 2 }">注册用户(最近一月)</c:when>
		    					<c:when test="${statType == 3 }">活跃数</c:when>
		    				</c:choose>		</td>
	    			</tr>
	     			<c:forEach items="${pageBean.list }" var="userReportVo">
	    				<tr>
							<td>${userReportVo.statName }</td>
							<td>${userReportVo.registerUser_Count }</td>
							<td>${userReportVo.activeUser_Count }</td>			  				
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
