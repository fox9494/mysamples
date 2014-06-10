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
    
    <title>应用使用流量统计</title>
    
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

	<script type="text/javascript">

    	//当修改选中的客户时，动态修改对应该客户下发布的应用
    	function ajaxAppList() {
    	
    		var companyID = $("#combobox1").val();//获取当前选中的客户id
    		 $.post("/zhuankerAdmin/reports/ajaxAppList.shtml", {companyID:companyID}, function(data, textStatus){
    			var apps = data.apps;//从返回的数据中获取任务列表数据
    			$("#combobox2").empty();  //清空Select中Option  
    			$("#combobox2").append("<option value='-1' selected='selected' >请选择</option>");
    			if(apps != null) {
	    			for(var i=0;i<apps.length;i++) {
						var app = apps[i];
						var optionStr = "";
						optionStr = "<option value='"+app.appId+"' >"+app.appName+"</option>";
						//为Select追加一个Option(下拉项)
						$("#combobox2").append(optionStr);
					}
				}
    			
    		}, "json"); 

    	}
    	
    	//页面一加载执行方法
		$(document).ready(function(){
			
			$( "#combobox1" ).combobox();
			$( "#combobox1" ).toggle();
			
			$( "#combobox2" ).combobox();
			$( "#combobox2" ).toggle();
			
			//页面一加载执行下获取应用列表
			ajaxAppList();
			
			$('#ui-id-1').click(function() {ajaxAppList();});
			//ui-state-default ui-combobox-input ui-widget ui-widget-content ui-corner-left ui-autocomplete-input
			$('.ui-combobox-input:eq(0)').keydown(function(event) {
					var keyCode = $.ui.keyCode;
					switch( event.keyCode ) {
					case keyCode.PAGE_UP:
					case keyCode.PAGE_DOWN:
					case keyCode.UP:
					case keyCode.DOWN:
					case keyCode.ENTER:
					case keyCode.NUMPAD_ENTER:
					case keyCode.TAB:
					case keyCode.ESCAPE:
						ajaxAppList();
						break;
					default:
						break;
					}
			});

		});
    	
	</script>

  </head>
  
  <body>
  	<br/>
    <div class="main">
    <form action="<%=path %>/reports/appFlowStatistics.shtml" method="post">
    <div class="ui-widget" >
    	<ul>  			
	    		<li style="width: 220px">
	    			客户名称
		    			<select name="statisticsReport.companyId" id="combobox1" >
		    				<option value="-1" selected="selected">请选择</option>
		    				<c:forEach items="${companys }" var="company">
		    					<option value="${company.id }" ${statisticsReport.companyId == company.id ? "selected='selected'" : "" }  >${company.name }</option>
		    				</c:forEach>
		    			</select>
	    		</li >
	    		<li style="width: 220px">
	    			应用名称
		    			<select name="statisticsReport.appId" id="combobox2" >
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
    				<td>应用名称</td>
    				<td>上行流量</td>
    				<td>下行流量</td>
    			</tr>
     			<c:forEach items="${pageBean.list }" var="data">
    				<tr>
						<td>${data[1]}</td>
						<td>${data[3]}</td> 			  				
						<td>${(empty data[4])?"0":data[4]}</td>
						<td>${(empty data[5])?"0":data[5]}</td>
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
