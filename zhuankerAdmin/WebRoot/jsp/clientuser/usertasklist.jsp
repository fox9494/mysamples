<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>任务详情列表</title>
    
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
  var tabTxt=self.parent.window.frames.leftFrame.txtInfo;
    
	$(document).ready(function() {
		//页面加载完成后 初始化tab
		//alert(tabTxt);
		//var  tabContent=;
		for(i=0;i<tabTxt.length;i++){
			$("#tab_info").append("<div class='tab_box'><span>"+tabTxt[i]+"</span><a href=''><img src='../images/delete_tab.jpg' class='deleteTab'/></a></div>");
			//默认显示5个
			if(i==5){
			 //出现左右移动的按钮  开始隐藏
			 $("#tab_info").append("<div class='ar'><input type='button' value='左' id='moveleft' style='float:right'>"+
			 "<input type='button' value='右' id='moveRight' tyle='float:right'><div>");
			 
			}
			//初始化加载超过5个
			if(i>=5){
				var divFirst=$("#tab_info").find('.tab_box').first();
				while(divFirst.is(":hidden")){
					divFirst=divFirst.next();
				}
				$(divFirst).hide();	
				//var temp= $("#test").is(":hidden");//是否隐藏
				//var temp1= $("#test").is(":visible");//是否可见
						
			}
		}
		//向右移动
		$("#moveRight").click(function(){
			//隐藏后面
			var divLast=$("#tab_info").find('.tab_box').last();
				while(divLast.is(":hidden")){
					divLast=divLast.prev();
				}
				$(divLast).hide();	
		
		//显示前面
		var divFirst=$("#tab_info").find('.tab_box').first();
				while(divFirst.is(":visible")){
					divFirst=divFirst.next();
				}
				$(divFirst).show();	
		});
		//向左移动
		$("#moveleft").click(function(){
			//隐藏后面
			var divLast=$("#tab_info").find('.tab_box').last();
				while(divLast.is(":visible")){
					divLast=divLast.prev();
				}
				$(divLast).show();	
		
		//显示前面
		var divFirst=$("#tab_info").find('.tab_box').first();
				while(divFirst.is(":hidden")){
					divFirst=divFirst.next();
				}
				$(divFirst).hide();	
		});
		
		//弹出层
		$("#popup").dialog({
					modal: true,
					autoOpen:false,
					width:450,
					height:200,
					buttons : {
					
				}
				
		});
		//open dialog
		
	});
	
	function openDialog(){
	 // $("#popup").dialog("open");
	}
//**************************
	function getUserId(){
			var userId = $("input[name='userId']").val();
			return userId;
		}
	function back(){
			var userid = getUserId();
			if(userid!=null){
					window.location = "<%=path%>/userclient/userclientDetails!initUserDetails.shtml?userclient.id="+userid;	
				}
			else{
				return;
			}
		}
</script>

  </head>
  
  <body>
  
    <div id="tab_info">
	   
	</div>
<div class="main">
		<div class="btarea line">
           <a href="javascript:;" class="graybtn" onclick="javascript:back()" >返回</a>	    		
    	</div>
    <form action="<%=path %>/details/userTaskList!searchList.shtml" method="post">
    	<input  name="userId" type="hidden" value="<s:property value='userId'/>" />
	<div class="list">
		<table cellspacing="0" border="0">
		<tr class="head">
    			<td>完成时间</td>
    			<td>任务名称</td>
    			<td>任务状态</td>
    			<td>所赚金币</td>
    		</tr>
    		<s:iterator value="pageBean.list" id="task">
    		<tr> 
    		<!-- 只显示做任务得到的金币 --> 
    		 		
    			<td><s:date name="#task.userTask.finishDate" format=" yyyy-MM-dd"/></td>
    			
    			<td><s:property value="#task.userTask.TTask.name"/></td>    
    			   					
    			<s:if test="#task.userTask.isFinished==0">
    				<td>未完成</td>
    			</s:if>
    			<s:if test="#task.userTask.isFinished==1">
    				<td>完成</td>
    			</s:if>
    			<td><s:property value="#task.currentExchangeNum"/></td>
    		 
    		</tr>
    		</s:iterator>
    	</table>
    	</div>
    	<div style="">
			<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}"
				showNum="2" currentPage="${pageBean.currentPage}"></my:page>
		</div>
    </form>
    </div>
  </body>
</html>
