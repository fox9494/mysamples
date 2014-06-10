<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    
    <title>渠道结算</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript"src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>
	
	<!-- select 可编辑并自动提示所需css和js引入，select必须加id="combobox" 如果有对齐问题可在select外套上div且class="ui-widget"  -->
	<LINK rel="stylesheet" href="js/combobox_files/jquery-ui.css" type="text/css" />	 
	<LINK rel="stylesheet" href="js/combobox_files/style.css" type="text/css" />	 
	<SCRIPT type="text/javascript" src="js/combobox_files/jquery-ui.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="js/combobox_files/combobox.js"></SCRIPT>	
		
	<style type="text/css">
		select {
			width: 250px;
			height: 24px;}
	</style>

	<script type="text/javascript">

		//点击查询统计时执行该方法
		function statistics() {
			//跳转到查询统计页面，并初始化渠道名称列表
			window.location.href = "/zhuankerAdmin/payment/channelPaymentStatistics.shtml";
		}
    	
    	//点击新增结算时执行该方法
    	function payment() {
    		//跳转到新增结算页面，并初始化渠道名称列表
    		window.location.href = "/zhuankerAdmin/payment/channelPaymentAddInit.shtml";
    	}
    	
    	//页面一加载执行方法
		$(document).ready(function(){
			$( "#combobox" ).combobox();
			$( "#combobox" ).toggle();
		
		});
    	
	</script>

  </head>
  
  <body>
      <div class="main">
    <div id="top" class="btarea line">   	
    		<a  onclick="javascript:statistics()">查询统计</a>
    		<a  onclick="javascript:payment()">新增结算</a>
    </div>
    <br />
    <br />
    <br />
    <form action="<%=path %>/payment/channelPaymentList.shtml" method="post">
    	
    <div class="ui-widget">
		<span>
			&nbsp;&nbsp;渠道名称
 			<select name="channelId" id="combobox" >
 				<option value="-1" selected="selected">请选择</option>
 				<c:forEach items="${channels }" var="channel">
 					<option value="${channel.channelId }" ${channelId== channel.channelId ? "selected='selected'" : "" }  >${channel.channelName }</option>
 				</c:forEach>
 			</select>
		</span >
		<span style="margin-left: 20px">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结算日期
			<input type="text" name="startDate" value="${param.startDate }" id="startDate" onclick="WdatePicker({el:$dp.$('d12')})" style="width: 100px;height: 24px;" />
		</span>
		<span>
			--
			<input type="text" name="endDate" value="${param.endDate }" id="endDate" onclick="WdatePicker({el:$dp.$('d12')})" style="width: 100px;height: 24px;"/>
		</span >
		<span style="margin-left: 20px">
			<input value="查询"  type="submit" class="button"/>
		</span>
	</div>  
     	   	
    <div class="list">
	    <table cellspacing="0" border="0">
    			<tr class="head"> 			
    				<td>渠道名称</td>
    				<td>开始时间</td>
    				<td>结束时间</td>
    				<td>累计任务量</td>
    				<td>累计金币量</td>
    				<td>结算金额</td>
    				<td>结算时间</td>
    			</tr>
     			<c:forEach items="${pageBean.list }" var="channelPayment">
    				<tr>
						<td>${channelPayment.channel.channelName}</td>
						<td>
							<c:if test="${channelPayment.startDate == null}">
								之前
							</c:if>
							<c:if test="${channelPayment.startDate != null}">
								<fmt:formatDate value="${channelPayment.startDate}" pattern="yyyy-MM-dd"/>
							</c:if>
						</td>
						<td>
							<c:if test="${channelPayment.endDate == null}">
								至今
							</c:if>
							<c:if test="${channelPayment.endDate != null}">
								<fmt:formatDate value="${channelPayment.endDate}" pattern="yyyy-MM-dd"/>
							</c:if>
						</td>
						<td>${channelPayment.taskStatistics}</td>
						<td>${channelPayment.coinStatistics}</td>
						<td>${channelPayment.paymentMoney}</td>
						<td><fmt:formatDate value="${channelPayment.paymentDate}" pattern="yyyy-MM-dd"/></td>
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
