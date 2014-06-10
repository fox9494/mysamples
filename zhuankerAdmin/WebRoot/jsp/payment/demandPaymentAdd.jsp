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
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script  type="text/javascript"src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>	
	<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>		

	<script type="text/javascript">

    	//当修改选中的客户时，动态修改对应该客户下发布的任务
    	function changeTaskList(companySelect) {
    	
    		companyID = companySelect.value;//获取当前选中的客户id
    		$.post("/zhuankerAdmin/payment/ajaxTaskList.shtml", {companyID:companyID}, function(data, textStatus){
    			var tasks = data.tasks;//从返回的数据中获取任务列表数据
    			$("#taskSelect").empty();  //清空Select中Option  
    			$("#taskSelect").append("<option value='-1'>请选择</option>");
    			if(tasks != null) {
	    			for(var i=0;i<tasks.length;i++) {
						var task = tasks[i];
						var optionStr = "<option value='"+task.taskId+"' >"+task.name+"</option>";
						//为Select追加一个Option(下拉项)
						$("#taskSelect").append(optionStr);
					}
				}
    			
    		}, "json");

    	}
    	//任务名称下拉列表添加选项改变时，异步请求选中任务的最末次结算时间用作本次结算的开始时间
    	function changeStartDate(taskSelect) {
    		var taskId = taskSelect.value;//获取当前选中的客户id
    		$.post("/zhuankerAdmin/payment/ajaxStartDate.shtml", {taskId:taskId}, function(data, textStatus){
    			var startDate = data.startDate;//从返回的数据中获取任务列表数据
    			//取出日期的年月日
    			var startDate1 = startDate.substr(0,10);
				$("#startDate").attr("value",startDate1);
    		}, "json");

    	}
    	//点击统计按钮时，异步请求：根据任务id，开始时间，结束时间请求该任务在统计时间范围内的完成量
    	function ajaxStatisticsAmount() {
    	
    		//清除认可量和统计金额
    		$('#approvedAmount').val("");
    		$('#paymentMoney').val("");
    		
    		var taskId = $("#taskSelect").val();
    		var startDate = $("#startDate").val();
    		var endtDate = $("#endDate").val();
    		$("#statisticsAmount").attr("value","");
    		$.post("/zhuankerAdmin/payment/ajaxStatistics.shtml", {taskId:taskId,startDate:startDate,endtDate:endtDate}, function(data, textStatus){
    			if(data.erroMsg != null){
	    			alert(data.erroMsg);
				} else {
					statisticsAmount = data.statisticsAmount;//从返回的数据中获取任务列表数据
					taskGoleNum = data.taskGoldNum;
					$("#statisticsAmount").attr("value",statisticsAmount);
				}
    		}, "json");
    	}
    	
    	function initPaymentMoney(input) {
    		var approvedAmount = input.value;
    		
    		if(approvedAmount>statisticsAmount) {
    			alert("认可量不能大于完成量！！");
    			input.value = "";
    			return;
    		} else {
    			$('#paymentMoney').attr("value",(taskGoleNum*approvedAmount/100));
    		}
    	}
    	
    	//页面一加载执行方法
		$(document).ready(function(){
			
			//动态给客户名称下拉列表添加选项改变时促发事件
			$("#companySelect").change(function() {changeTaskList(this);});
			//动态给任务名称下拉列表添加选项改变时促发事件（异步请求选中任务的最末次结算时间用作本次结算的开始时间）
			$("#taskSelect").change(function() {changeStartDate(this);});
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
				   "demandPayment.statisticsAmount": {     
				    required: true,     
				    maxlength: 20    
				   },
				   "demandPayment.approvedAmount": {     
				    required: true,     
				    maxlength: 20    
				   },
				   "demandPayment.paymentMoney":{
				    required: true,
				    maxlength: 14
				   }    			   
				 },
				 message:{
				    "demandPayment.statisticsAmount": {     
			        required: "无统计结果", 
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        },
			        "demandPayment.approvedAmount": {     
			        required: "请确认输入认可量", 
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        },  
			        "demandPayment.paymentMoney": {     
			           required: "请输入结算金额",
			           maxlength: jQuery.format("输入不能超过{0}个字符")
			        }		        
			 	}
		    });
		
		});
	</script>

  </head>
  
  <body>
  	<center>
	    <form action="<%=path %>/payment/demandPaymentAdd.shtml" method="post" id="addForm">
    		<p>
    			客户名称
	    			<select name="demandPayment.company.id" id="companySelect" style="width: 180px" >
	    				<option value="-1" selected="selected" >请选择</option>
	    				<c:forEach items="${companys }" var="company">
	    					<option value="${company.id }" >${company.name }</option>
	    				</c:forEach>
	    			</select>
    		</p>
    		<p>
    			任务名称
	    			<select name="demandPayment.task.taskid" id="taskSelect" style="width: 180px">
	    				<option value="-1" selected="selected" >请选择</option>
	    			</select>
    		</p> 		
    		<p>
    			开始时间
   				<input type="text" name="demandPayment.startDate" id="startDate" style="width: 180px" readonly="readonly" />
   			</p>   
   			<p>
   				结束时间
   				<input type="text" name="demandPayment.endDate" id="endDate" style="width: 180px" onclick="WdatePicker({el:$dp.$('d12')})" />
   			</p>
   			<div><font color="red">备注：若指定任务是第一次结算，则开始时间为该任务发布时间，统计时间截止当天凌晨00:00:00</font></div>     	
   			<p>
   				<input value="统计"  type="button" class="button" onclick="ajaxStatisticsAmount()" style="width: 100px"/>
   			</p>   	
   			<p>
   				&nbsp;&nbsp;&nbsp;&nbsp;完成量<input type="text" name="demandPayment.statisticsAmount" id="statisticsAmount" readonly="readonly" style="width: 180px" />
   			</p>   
   			<p>
   				&nbsp;&nbsp;&nbsp;&nbsp;认可量<input type="text" id="approvedAmount" name="demandPayment.approvedAmount" onchange="initPaymentMoney(this)" style="width: 180px" />
   			</p>
   			<p>
   				结算金额<input type="text" id="paymentMoney" name="demandPayment.paymentMoney" style="width: 180px" />
   			</p> 
   			<p>
   				<input type="submit" value="确定结算" class="button" />
   			</p>   			   			 
	    </form>
	</center>
	 <br/>
  </body>
</html>
