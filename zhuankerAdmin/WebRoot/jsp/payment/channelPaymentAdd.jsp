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
	<script  type="text/javascript"src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>	
	<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>		
	
	<!-- select 可编辑并自动提示所需css和js引入，select必须加id="combobox" 如果有对齐问题可在select外套上div且class="ui-widget"  -->
	<LINK rel="stylesheet" href="js/combobox_files/jquery-ui.css" type="text/css" />	 
	<LINK rel="stylesheet" href="js/combobox_files/style.css" type="text/css" />	 
	<SCRIPT type="text/javascript" src="js/combobox_files/jquery-ui.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="js/combobox_files/combobox.js"></SCRIPT>	

	<style type="text/css">
		select {
			width: 180px;
			height: 21px;}
	</style>

	<script type="text/javascript">

    	//动态给渠道名称下拉列表添加选项改变时促发事件（异步请求选中渠道的最末次结算时间用作本次结算的开始时间）
    	function ajaxStartDate(channelSelect) {
    		$("#startDate").attr("value","");
    		var channelId = channelSelect.value;//获取当前选中的渠道id
    		$.post("/zhuankerAdmin/payment/ajaxCPLastDate.shtml", {channelId:channelId}, function(data, textStatus){
    			var startDate = data.startDate;//从返回的数据中获取startDate
    			//取出日期的年月日
    			var startDate1 = startDate.substr(0,10);
				$("#startDate").attr("value",startDate1);
    		}, "json");

    	}
    	//点击统计按钮时，异步请求：根据任务id，开始时间，结束时间请求该任务在统计时间范围内的完成量
    	function ajaxStatistics() {
    		var channelId = $("#channelSelect").val();
    		var startDate = $("#startDate").val();
    		var endDate = $("#endDate").val();
    		if(channelId.length == 0) {
    			alert("请选择结算渠道");
    			return;
    		}
    		if(endDate.length == 0) {
    			alert("请选择结算结束日期");
    			return;
    		}
    		$("#taskStatistics").attr("value","");
    		$("#coinStatistics").attr("value","");
    		$("#paymentMoney").attr("value","");
    		$.post("/zhuankerAdmin/payment/ajaxCPStatistics.shtml", {channelId:channelId,startDate:startDate,endDate:endDate}, function(data, textStatus){
    			if(data.erroMsg != null){
	    			alert(data.erroMsg);
				} else {
					var statisticsData = data.statisticsData;//从返回的数据中获取累计任务数、累计金币、结算金额
					$("#taskStatistics").attr("value",statisticsData.taskStatistics);
					$("#coinStatistics").attr("value",statisticsData.coinStatistics);
					$("#paymentMoney").attr("value",statisticsData.paymentMoney);
				}
    		}, "json");
    	}
    	
    	//页面一加载执行方法
		$(document).ready(function(){
			
			//动态给渠道名称下拉列表添加选项改变时促发事件（异步请求选中渠道的最末次结算时间用作本次结算的开始时间）
			//$("#channelSelect").change(function() {ajaxStartDate(this);});
			//判断是否有错误信息，有就显示出来
			if("${erroMsg}".length != 0) {
				alert("${erroMsg}");
			}
			
			//设置提交验证     
			  $.validator.setDefaults({     
				    submitHandler: function(form) { 
				         form.submit(); 
				    } 
			   }); 
		 	  $("#addForm").validate({
				/* 设置验证规则 */     
			    rules: {     
				   "channelPayment.taskStatistics": {     
				    required: true,     
				    maxlength: 20    
				   },
				   "channelPayment.coinStatistics": {     
				    required: true,     
				    maxlength: 20    
				   },
				   "channelPayment.paymentMoney":{
				    required: true,
				    maxlength: 18
				   }    			   
				 },
				 message:{
				    "channelPayment.taskStatistics": {     
			        required: "无统计结果", 
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        },
			        "channelPayment.coinStatistics": {     
			        required: "无金币总数", 
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        },  
			        "channelPayment.paymentMoney": {     
			           required: "无结算金额",
			           maxlength: jQuery.format("输入不能超过{0}个字符")
			        }		        
			 	}
		    });
		
		});
	</script>

  </head>
  <body>
  <br/><br/>
  	<center>
	    <form action="<%=path %>/payment/channelPaymentAdd.shtml" method="post" id="addForm">
    		<p>
    			渠道名称
    			<select name="channelPayment.channel.id" onchange="ajaxStartDate(this);" id="channelSelect" >
    				<option value="-1" selected="selected">请选择</option>
    				<c:forEach items="${channels }" var="channel">
    					<option value="${channel.channelId }" >${channel.channelName }</option>
    				</c:forEach>
    			</select>
    		</p>
    		<p>
    			开始时间
   				<input type="text" name="channelPayment.startDate" id="startDate" style="width: 180px" readonly="readonly" />
   			</p>   
   			<p>
   				结束时间
   				<input type="text" name="channelPayment.endDate" id="endDate" style="width: 180px" onclick="WdatePicker({el:$dp.$('d12')})" />
   			</p>
   			<div><font color="red">备注：开始时间为上次结算结束时间不可编辑，无时间表示没有结算过，统计时间截止当天凌晨00:00:00</font></div>   	
   			<p>
   				<input value="统计"  type="button" class="button" onclick="ajaxStatistics()" style="width: 100px"/>
   			</p>   	
   			<p>
   				累计完成任务<input type="text" name="channelPayment.taskStatistics" id="taskStatistics" readonly="readonly" style="width: 180px" />
   			</p>   
   			<p>
   				累计所赚金币<input type="text" name="channelPayment.coinStatistics" id="coinStatistics" readonly="readonly" style="width: 180px" />
   			</p>
   			<p>
   				累计结算金额<input type="text" name="channelPayment.paymentMoney" id="paymentMoney" readonly="readonly" style="width: 180px" />
   			</p> 
   			<p>
   				<input type="submit" value="确定结算" class="button" />
   			</p>   			   			 
	    </form>
	</center>
	 <br/><br/>
  </body>
</html>
