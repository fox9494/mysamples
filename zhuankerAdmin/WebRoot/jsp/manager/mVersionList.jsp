<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mVersionList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script type="text/javascript">
	function chanageAdd(){
	    window.location="<%=request.getContextPath()%>/jsp/manager/mVersionAdd.jsp";
	}
	
	function goBack(){
	    window.location="<%=request.getContextPath()%>/mversion/versionlist!versionList.shtml";
	}
	</script>
	 

  </head>
  
  <body>
  <div class="main">
         <div class="btarea line">   		
	    	 <a href="javascript:;" class="graybtn" onclick="return goBack();">返回</a>
             <a href="javascript:;" class="graybtn" onclick="return chanageAdd();">新增</a>
	     </div>
   <form action="<%=path%>/mversion/versionlist!versionList.shtml" method="post">
   <div class="list">
	<table cellspacing="0" border="0">
	   
		<tr class="head">
			<td>版本号</td>
			<td>发布时间</td>
			<td>是否更新</td>
			<td>描述</td>
			
		</tr>
		<s:iterator value="pageBean.list" id="tversion">
		<tr>
		
			
			<td><s:property value="#tversion.version"/></td>
			<td><s:date name="#tversion.uploadDate" format="yyyy-MM-dd"/></td>
			<td><s:if test="#tversion.forceUpdate==1">是</s:if><s:elseif test="#tversion.forceUpdate==0">否</s:elseif></td>
			<td><s:property value="#tversion.description"  escape="false" /></td>			
		</tr>
		</s:iterator>
		<tr>
		
	     </tr>   		
    	
		
	</table>
	 <div style=""><my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
	 </div>
	 </div>
	 </form>
	 </div>
  </body>
</html>
