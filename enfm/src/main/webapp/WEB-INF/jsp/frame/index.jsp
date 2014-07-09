<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="../common/libs.jsp" %>


<!DOCTYPE HTML >
<html>
  <head>
    
    <title>基础开发框架</title>
	<%@include file="../common/scripts.jsp" %>
	
  </head>
  
 <body class="easyui-layout">
	<%-- <div data-options="region:'north',href:'${pageContext.request.contextPath}/general/layout/north.jsp'" style="height: 30px;overflow: hidden;" ></div>
	<div data-options="region:'west',title:'功能导航',href:'${pageContext.request.contextPath}/general/layout/west.jsp'" style="width: 200px;overflow: hidden;"></div> --%>
<!--  <div data-options="region:'east',title:'日历',split:true,href:'${pageContext.request.contextPath}/general/layout/east.jsp'" style="width: 200px;overflow: hidden;"></div>-->
	<%-- <div data-options="region:'center',title:'欢迎使用基础开发平台',href:'${pageContext.request.contextPath}/general/layout/center.jsp'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'${pageContext.request.contextPath}/general/layout/south.jsp'" style="height: 20px;overflow: hidden;"></div> --%>
	
	
	<div data-options="region:'north',href:'north.jsp'" style="height: 30px;overflow: hidden;" ></div>
	<div data-options="region:'west',title:'功能导航',href:'west.jsp'" style="width: 200px;overflow: hidden;"></div>
	<div data-options="region:'center',title:'欢迎使用基础开发平台',href:'center.jsp'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'south.jsp'" style="height: 20px;overflow: hidden;"></div>

	<jsp:include page="isIe.jsp"></jsp:include>
</body>
</html>
