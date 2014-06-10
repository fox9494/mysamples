<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/gxupload";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>	     
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/list2.css" />
	
		<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
        <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
        <style >
        	.radioinput{line-height:32px;padding-top:0;}
        	.radioinput input{height:16px!important;margin-right:5px;background-color:#ffffff!important;border:none!important;background-image:url()!important;width:22px!important;}
       		.tabtitle{text-align:right;}
        </style>
	    <!-- 前台验证 -->
        <script type="text/javascript">
          $(document).ready(function(){
	           /* 设置默认属性 */     
			   $.validator.setDefaults({     
				    submitHandler: function(form) { 
				         form.submit(); 
				    } 
			   }); 
			   $("#editForm").validate({
				/* 设置验证规则 */     
			    rules: {     
				   "task.name": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 20    
				   },   
				   "task.totalNumber": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 20    
				   }, 
				   "task.goldNum": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 10    
				   },
				   "task.completeDescription": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 100    
				   },
				   "task.endDate": {     
				    required: true,				       
				   },	
				   "task.description": {     
				    required: true,	
				    minlength: 1,
				    maxlength: 1000	       
				   }		            			   
				 },
				 message:{
				   "company.name": {     
			        required: "请填写行业名称" ,
			        "company.name":"名称在1到20个字符之间" 
			        },
			        "company.phone": {     
			        required: "请填写电话号码" ,
			        "company.phone":"电话号码在6到12个字符之间" 
			        }     		        
				 }
			    });        
           }); 
        </script>
        
        <script type="text/javascript">
          //获得最大任务数
          function getTotalNumber(){ 
                   
                 document.form.action="<%=path%>/task/taskEdit!initTotalNumber.shtml?order.id="+$("#orderid").val();
                 document.form.submit();
          } 
        
		  //初始化修改应用界面
		  function addApp(){
		     var taskid=$("#taskid").val();
		     var companyid=$("#companyid").val();
		     var appid=$("#appid").val();
		     var taskname=$("#taskname").val();
		     if(taskid!=""){
		       window.location="<%=request.getContextPath()%>/application/applicationEdit!input.shtml?task.taskid="+taskid+"&company.id="+companyid+"&app.appid="+appid+"&task.name="+encodeURI(encodeURI(taskname));
		     }else{
		       alert("操作失败!");
		     }
		  }
		  //初始化渠道筛选界面
		  function screenChannel(){
		     var taskid=$("#taskid").val();
		     var companyid=$("#companyid").val();
		     var appid=$("#appid").val();
             if(taskid!=""){
		       window.location="<%=request.getContextPath()%>/task/screeningChannelEdit!initChannel.shtml?task.taskid="+taskid;
		     }else{
		       alert("操作失败!");
		     }
		  }
		  //返回任务主界面
		  function goBack(){
		     window.location="<%=path %>/task/taskList!searchList.shtml";
		  }
        </script>
	</head>

	<body style="overflow-y:auto;">      
	        <div class="main" style="padding-top:20px;">
			<div>
			   <form action="" style="border-bottom:1px solid #dedede;margin-bottom:5px;padding-bottom:0;">
			      <table id="toplist" style="width:100%">
			        <tr class="btarea">
				      <td width="150"><a href="javascript:;" class="graybtn" id="add" onclick="addApp()">编辑应用</a></td>
				      <td><a href="javascript:;" class="graybtn" onclick="screenChannel()">渠道筛选</a></td>
			        </tr>
			      </table>
			   </form>
			</div>
			<form  method="post"  name="form" action="task/taskEdit!save.shtml" id="editForm">
             <input type="hidden" id="companyid" value="<s:property value='company.id'/>"/>
             <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
             <input type="hidden" name="task.isRemove" value="<s:property value="task.isRemove"/>"/>
             <input type="hidden" name="task.createDate" value="<s:property value="task.createDate"/>"/>
             <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>" id="appid"/>
             <input type="hidden" name="task.state" value="<s:property value="task.state"/>"/>
             <input type="hidden" name="order.totalNumber" value="<s:property value="order.totalNumber"/>"/> 
             <div class="form">				
              <table cellspacing="0" border="0" >
                    <tr>
                       <td class="tabtitle">名称：</td>
                       <td><input type="text" name="task.name" value="<s:property value="task.name"/>" id="taskname"/>
                                     <font color="red"><s:fielderror fieldName="task.nameExist"/></font>  
                                     <font color="red"><s:fielderror fieldName="task.taskName"/></font> 
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">客户名称：</td>
                       <td>
                          <select name="company.id" onchange="getTotalNumber()" class="required">
                          <option  id="notSelect" value=""><-- 请选择客户 --></option>
                           <s:iterator value="companies" id="tcompany">
                              <option value="<s:property value="#tcompany.id"/>" <s:if test="#tcompany.id==company.id">selected="selected"</s:if>><s:property value="#tcompany.name"/></option>
                           </s:iterator>
                          </select>
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">订单应用名称：</td>
                       <td>                          
                          <select name="task.orderId" onchange="getTotalNumber()" id="orderid" class="required">
                          <option  id="notSelect" value=""><-- 请选择订单应用 --></option>
                           <s:iterator value="orders" id="order">
                              <option value="<s:property value="#order.id"/>" <s:if test="#order.id==task.orderId">selected="selected"</s:if>><s:property value="#order.name"/></option>
                           </s:iterator>
                          </select>
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">允许的最大任务数：</td>
                       <td><input type="text" name="task.totalNumber" value="<s:property value="order.totalNumber"/>"/>
                                     <font color="red"><s:fielderror fieldName="task.totalNumber"/></font>
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">金币：</td>
                       <td><input type="text" name="task.goldNum" value="<s:property value="task.goldNum"/>" class="number"/>
                                     <font color="red"><s:fielderror fieldName="task.goldNum"/></font>
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">任务条件：</td>
                       <td>
                           <select name="task.finishCondition">
                              <option value="0" <s:if test="task.finishCondition==0">selected="selected"</s:if>>下载</option>
                              <option value="1" <s:elseif test="task.finishCondition==1">selected="selected"</s:elseif>>安装</option>
                              <option value="2" <s:elseif test="task.finishCondition==2">selected="selected"</s:elseif>>激活</option>
                           </select>
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">任务描述：</td>
                       <td><input type="text" name="task.completeDescription" value="<s:property value="task.completeDescription"/>"/>
                                     <font color="red"><s:fielderror fieldName="task.completeDescription"/></font>
                       </td>
                    </tr>
                    <tr>
                       <td class="tabtitle">是否置顶：</td>
                       <td class="radioinput"><input type="checkbox" name="isneedtop" value="1"  <s:if test="isneedtop==1">checked="checked"</s:if>/></td>
                    </tr>
                    <tr>
                       <td class="tabtitle">任务结束时间：</td>
                       <td><input id="d12" type="text" name="task.endDate" value="<s:date name="task.endDate" format="yyyy-MM-dd"/>" class="dateISO"/>
		                             <img onclick="WdatePicker({el:$dp.$('d12'),minDate:'%y-%M-{%d+1}'})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="middle"/>
		                             <font color="red"><s:fielderror fieldName="task.endDate"/></font>
                       </td>
                    </tr>
                    <tr>
						<td class="tabtitle">
						             产品简介：
						</td>
						<td>
							<textarea name="task.description" rows="14" cols="60"><s:property value='task.description'/></textarea>
						    <font color="red"><s:fielderror fieldName="task.description"/></font>
						</td>					
					</tr> 
				 </table>
				 <div class="buttongroup">
                   <input type="submit" value="提交" class="graybtn"/>&nbsp;
                   <input type="button" value="返回" onclick="goBack()" class="graybtn"/>
                 </div>
                 <div>
                </div>              
			   </div>	
			</form>
		   </div>
	</body>
</html>
