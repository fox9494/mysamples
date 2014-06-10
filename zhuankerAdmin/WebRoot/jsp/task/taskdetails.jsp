<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看任务详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/list2.css" />
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>	
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
          //返回任务主界面
		  function goBack(){
		     window.location="<%=path %>/task/taskList!searchList.shtml";
		  }	
		  //搜索查詢下载详情
		  function searchInfo(cur){			      	   
		      $.ajax({
		   			url:"<%=path%>/task/taskDetails!searchDownLoadDetailsJson.shtml?app.appid="+$("#appid").val()+"&currentPage="+cur+"&type="+0,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){
           			   if(data.totalPage>1){
           			     $("#listDown").html("");
           			     $.each(data.list,function(index,downInstall){
           			        if(downInstall.nickName==null){
           			           $("#listDown").append("<tr><td></td><td>"+downInstall.userName+"</td><td>"+downInstall.operateDate+"</td></tr>");
           			        }else{
           			           $("#listDown").append("<tr><td>"+downInstall.nickName+"</td><td>"+downInstall.userName+"</td><td>"+downInstall.operateDate+"</td></tr>");
           			        }			      
					        				      
					     });
           			   }        			          															   
					   $("#currentPage").attr("value",data.currentPage);
					   $("#totalPage").attr("value",data.totalPage);
					   $("#showCurrentPage").html(data.currentPage);
					}																							          						    
	 	      });	  	       
		  }	
		  //搜索查詢安装详情
		  function searchInfoInstall(cur){		   
		      $.ajax({
		   			url:"<%=path%>/task/taskDetails!searchDownLoadDetailsJson.shtml?app.appid="+$("#appid").val()+"&currentPage="+cur+"&type="+1,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){
           			   if(data.totalPage>1){
           			     $("#listInstall").html("");
           			     $.each(data.list,function(index,downInstall){	
           			         if(downInstall.nickName==null){
           			             $("#listInstall").append("<tr><td></td><td>"+downInstall.userName+"</td><td>"+downInstall.operateDate+"</td></tr>");				   
           			         }else{		      
					             $("#listInstall").append("<tr><td>"+downInstall.nickName+"</td><td>"+downInstall.userName+"</td><td>"+downInstall.operateDate+"</td></tr>");				      
					         }
					     });
           			   }        			          															   
					   $("#currentPage").attr("value",data.currentPage);
					   $("#totalPage").attr("value",data.totalPage);
					   $("#showInstallCurrentPage").html(data.currentPage);
					}																							          						    
	 	      });	  	       
		  }	   
		  //搜索查詢流程详情
		  function searchInfoSystem(cur){		      		   
		      $.ajax({
		   			url:"<%=path%>/task/taskDetails!searchSysFlowDetailsJson.shtml?app.appid="+$("#appid").val()+"&currentPage="+cur,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){
           			   if(data.totalPage>1){
           			     $("#listSystemFlow").html("");
           			     $.each(data.list,function(index,systemFlow){			      
					        $("#listSystemFlow").append("<tr><td>"+systemFlow.reportDate+"</td><td>"+systemFlow.userName+"</td><td>"+systemFlow.upNum+"</td><td>"+systemFlow.downNum+"</td></tr>");				      
					     });
           			   }        			          															   
					   $("#currentPage").attr("value",data.currentPage);
					   $("#totalPage").attr("value",data.totalPage);
					   $("#showSysCurrentPage").html(data.currentPage);
					}																							          						    
	 	      });	  	       
		  }	 
    </script>
  </head>
  
  <body>
      <div>
          <input type="button" value="返回主界面" onclick="goBack()" class="graybtn"/>
      </div>
      <form action="" method="post">
      <input type="hidden" name="taskid" value="<s:property value="task.taskid"/>"/>             
      <div class="easyui-tabs" style="width:900px;height:500px">
          <div title="基本信息" style="padding:10px">
		          <table>
		            <tr>
		              <td>名称：</td>
		              <td><input type="text" value="<s:property value="task.name"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>客户名称：</td>
		              <td><input type="text" value="<s:property value="task.companyId.name"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>金币：</td>
		              <td><input type="text" value="<s:property value="task.goldNum"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>任务完成的条件：</td>
		              <td>
		                     <s:if test="task.finishCondition==0">
		                        <input value="下载" readonly="readonly"/>                                                           
		                     </s:if>
		                     <s:elseif test="task.finishCondition==1">
		                        <input value="安装 " readonly="readonly"/>   
		                     </s:elseif>
		                     <s:else>
		                        <input value="激活 " readonly="readonly"/>   
		                     </s:else>
		               </td>
		            </tr>
		            <tr>
		              <td>任务描述：</td>
		              <td><textarea rows="14" cols="60" readonly="readonly"><s:property value="task.description"/></textarea></td>
		            </tr>
		          </table>
          </div>
          <div title="应用" style="padding:10px" data-options="href:'<%=path%>/task/taskDetails!searchApplicationDetails.shtml?task.taskid=<s:property value="task.taskid"/>'">
                  
          </div>
          <div title="渠道" style="padding:10px" data-options="href:'<%=path%>/task/taskDetails!searchChannelDetails.shtml?task.taskid=<s:property value="task.taskid"/>'">
          
          </div>
          <div title="下载量" id="down" style="padding:10px" data-options="href:'<%=path%>/task/taskDetails!searchDownLoadDetails.shtml?task.taskid=<s:property value="task.taskid"/>'">
          
          </div>
          <div title="安装量" style="padding:10px" data-options="href:'<%=path%>/task/taskDetails!searchInstallDetails.shtml?task.taskid=<s:property value="task.taskid"/>'">
          
          </div>
          <div title="使用量" style="padding:10px" data-options="href:'<%=path%>/task/taskDetails!searchSysFlowDetails.shtml?task.taskid=<s:property value="task.taskid"/>'">
          
          </div>
      </div>
      </form>
  </body>
</html>
