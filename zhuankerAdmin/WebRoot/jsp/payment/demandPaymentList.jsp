<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
    <title>客户结算</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script  type="text/javascript"src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>			

	<style type="text/css">
		select {
			width: 150px;
			height: 24px;}
	</style>

	<script type="text/javascript">

		//点击查询统计时执行该方法
		function statistics() {
			//跳转到查询统计页面，并初始化客户名称列表
			window.location.href = "/zhuankerAdmin/payment/demandPaymentStatistics.shtml";
		}
    	
    	//点击新增结算时执行该方法
    	function payment() {
    		//跳转到新增结算页面，并初始化客户名称列表
    		window.location.href = "/zhuankerAdmin/payment/demandPaymentAddInit.shtml";
    	}
    	
    	//当修改选中的客户时，动态修改对应该客户下发布的任务
    	function changeTaskList() {
    	
    		var companyID = $("#companySelect").val();//获取当前选中的客户id
    		$.post("/zhuankerAdmin/payment/ajaxTaskList.shtml", {companyID:companyID}, function(data, textStatus){
    			var tasks = data.tasks;//从返回的数据中获取任务列表数据
    			$("#taskSelect").empty();  //清空Select中Option  
    			//$("#taskSelect").append(new Option("请选择", "-1"));
    			$("#taskSelect").append("<option value='-1'>请选择</option>");
    			if(tasks != null) {
	    			for(var i=0;i<tasks.length;i++) {
						var task = tasks[i];
						//$("#taskSelect").append("<option value='Value'>Text</option>");  //为Select追加一个Option(下拉项)
						//var option = new Option(task.name, task.taskId);
						//if(task.taskId == "${demandPayment.task.taskid }") {
						//	option.selected = true;
						//}
						//$("#taskSelect").append(option); 
						var optionStr = "";
						if(task.taskId == "${demandPayment.task.taskid }") {
							optionStr = "<option value='"+task.taskId+"' selected='selected' >"+task.name+"</option>";
						} else {
							optionStr = "<option value='"+task.taskId+"' >"+task.name+"</option>";
						}
						//为Select追加一个Option(下拉项)
						$("#taskSelect").append(optionStr);
					}
				}
    			
    		}, "json");

    	}
    	
    	//页面一加载执行方法
		$(document).ready(function(){
			
			//动态给客户名称下拉列表添加选项改变时促发事件
			$("#companySelect").change(function() {changeTaskList();});
			//当页面以加载时就调用客户名称下拉列表添加选项改变时促发事件，初始化任务名称下拉列表数据
			changeTaskList();
		
		});
    	
	</script>

  </head>
  
  <body>
    <div class="main">
    <div id="top" class="btarea line">   	
    		<a  onclick="javascript:statistics()">查询统计</a>
    		<a  onclick="javascript:payment()">新增结算</a>
    </div>
    
    <form action="<%=path %>/payment/demandPaymentList.shtml" method="post">
    <div class="search">
    	<ul>  			
	    		<li style="width: 220px">
	    			客户名称
		    			<select name="demandPayment.company.id" id="companySelect" >
		    				<option value="-1" selected="selected">请选择</option>
		    				<c:forEach items="${companys }" var="company">
		    					<option value="${company.id }" ${demandPayment.company.id == company.id ? "selected='selected'" : "" }  >${company.name }</option>
		    				</c:forEach>
		    			</select>
	    		</li >
	    		<li style="width: 220px">
	    			任务名称
		    			<select name="demandPayment.task.taskid" id="taskSelect" >
		    				<option value="-1" selected="selected">请选择</option>
		    			</select>
	    		</li> 			
    			<li style="width: 120px">
    				<input value="查询"  type="submit" class="button" />
    			</li>   		
    	</ul>
    </div>   	   	
    <div class="list">
	    <table cellspacing="0" border="0">
    			<tr class="head"> 			
    				<td>客户名称</td>
    				<td>任务名称</td>
    				<td>开始时间</td>
    				<td>结束时间</td>
    				<td>完成量</td>
    				<td>认可量</td>
    				<td>结算金额</td>
    				<td>结算时间</td>
    			</tr>
    			<s:iterator value="pageBean.list" id="demandPayment">
    			<tr >     		
    				<td><s:property value="#demandPayment.company.name" /></td>
    				<td><s:property value="#demandPayment.task.name" /></td> 			  				
    				<td><s:date name="#demandPayment.startDate" format="yyyy-MM-dd"/></td>
    				<td><s:date name="#demandPayment.endDate" format="yyyy-MM-dd"/></td>
    				<td><s:property value="#demandPayment.statisticsAmount"/></td>
    				<td><s:property value="#demandPayment.approvedAmount"/></td>
    				<td><s:property value="#demandPayment.paymentMoney"/></td>
    				<td><s:date name="#demandPayment.paymentDate" format="yyyy-MM-dd"/></td>
    			</tr>
    			</s:iterator>
<%--      			<c:forEach items="${pageBean.list }" var="tDemandPayment">
    				<tr>
						<td>${tDemandPayment.TCompany.name}</td>
						<td>${tDemandPayment.TTask.name}</td> 			  				
						<td>${tDemandPayment.startDate}</td>
						<td>${tDemandPayment.endDate}</td>
						<td>${tDemandPayment.statisticsAmount}</td>
						<td>${tDemandPayment.approvedAmount}</td>
						<td>${tDemandPayment.paymentMoney}</td>
						<td>${tDemandPayment.paymentDate}></td>
					</tr>
    			</c:forEach>  --%>
    		</table>
    		<div >
    			<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
    		</div>
    	</div>
    </form>
   </div>
  </body>
</html>
