<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>下载量统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script src="<%=path %>/js/jquery.XYTipsWindow.2.8.js" type="text/javascript"></script>

	<script type="text/javascript">


	</script>
  </head>
  
  <body>
  <div class="main">
    <form  method="post" action="<%=path %>/reports/downloadLogListByParams!searchListByParams.shtml">      	
    	<div class="search">
    		<ul>
    			<li>
    				<p>客户名称</p>
    				<select id="user.id" name="user.id">
    					<option value="0">---请选择---</option>
						<s:iterator value="userList" id="user">						
							<option value="<s:property value='#user.id'/>"><s:property value="#user.userName"/></option>
						</s:iterator>
    				</select>
    			</li>    			
    			<li>
    				<p>应用名称</p><input type="text" id="app.appName" name="app.appName"></input>
    			</li>	
    			<li>
    				<input type="submit" value="查询" class="button"/>
    			</li>    		     		
    		</ul>
    	</div>
    <div class="list">
    	<table cellspacing="0" border="0">	
    		<tr class="head">
    			<td>订单ID</td>
    			<td>应用名称</td>
    			<td>客户名称</td>
    			<td>累计下载量</td>
    		</tr>    		
    		<s:iterator value="pageBean.list" id="download">
	    		<tr>	    		
	    			<td><s:property value="#download.TApplication.task.companyId.id"/></td>
	    			<td><s:property value="#download.TApplication.appName"/></td>
	    			<td><s:property value="#download.TUserClient.userName"/></td>
	    			<td><s:property value="#download.TApplication.initDownLoad"/></td>
	    		</tr>
    		</s:iterator>      	 		
    	</table>
    	<div style="">
    		<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
    	</div>
    </div>				
    </form>
    </div>
  </body>
</html>
