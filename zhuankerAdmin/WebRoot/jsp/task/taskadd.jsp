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
	    <link rel="stylesheet" type="text/css" href="<%=path%>/css/list2.css" />	
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
        <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
       
        <style >
        	.editapp tr td{white-space:nowrap; }
        	.radioinput{line-height:32px;padding-top:0;}
        	.radioinput input{height:12px!important;margin-right:5px;background-color:#ffffff!important;border:none!important;background-image:url()!important;width:22px!important;}
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
			   $("#addForm").validate({
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
                   
                 document.form.action="<%=path%>/task/taskAdd!initAddTask.shtml?order.id="+$("#orderid").val();
                 document.form.submit();
          } 
          
		  function showTopList(){
		     var va= document.getElementById("confiresubmit").value;
		     if(va==1){
		       $("#toplist").html("<tr class='btarea'><td width='150'><a href='javascript:;' class='graybtn' onclick='addApp()'>编辑应用 </a></td><td><a href='javascript:;' class='graybtn' onclick='goBack()'>返回主界面</a></td></tr>");
		       $("#addForm").append("<input type='hidden' id='companyid' value='<s:property value='company.id'/>'/>");
		       $("#hasbutton").html("");
		     }
		     if(va>1){
		       $("#toplist").html("<tr><td><a href='javascript:;' class='graybtn' onclick='goBack()'>返回主界面</a></td></tr>");
		       $("#hasbutton").html("");
		     }
		  }
		  //初始化添加应用界面
		  function addApp(){
		     var taskid=$("#taskid").val();
		     var companyid=$("#companyid").val();
		     var taskname=$("#name").val();
		     if(taskid!=""){
		       window.location="<%=request.getContextPath()%>/application/applicationAdd!initAddApplication.shtml?task.taskid="+taskid+"&company.id="+companyid+"&task.name="+encodeURI(encodeURI(taskname));
		     }else{
		       alert("操作失败!");
		     }
		  }
		  //初始化订单
		  function initCompanyOrder(){
		     document.form.action="<%=path %>/task/taskAdd!initCompanyOrder.shtml";
		     document.form.submit();
		  }
		  //返回任务主界面
		  function goBack(){
		     window.location="<%=path %>/task/taskList!searchList.shtml";
		  }
        </script>
	</head>

	<body onload="showTopList()" style="overflow-y:auto;">
	    <div class="main" style="padding-top:20px;">
		<div>
			<div>
			   <form action="" style="border-bottom:1px solid #dedede;margin-bottom:5px;padding-bottom:0;">
			      <table  id="toplist" style="width:100%">
			        
			      </table>
			   </form>
			</div>
			<form  method="post" id="addForm"  name="form" action="taskAdd!save.shtml">
            <input type="hidden" name="confiresubmit" value="<s:property value="confiresubmit"/>" id="confiresubmit"/>
            <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
            <input type="hidden" name="order.totalNumber" value="<s:property value="order.totalNumber"/>"/> 
             <div class="form">
             <table cellspacing="0" border="0">
                    <tr>
                       <td>
                                                                                        名称：
                       </td>
                       <td><input type="text" name="task.name" value="<s:property value="task.name"/>" id="name"/>
                                     <font color="red"><s:fielderror fieldName="task.nameExist"/></font>  
                                     <font color="red"><s:fielderror fieldName="task.taskName"/></font> 
                       </td>                 
                    </tr>
                    <tr>
                       <td>客户名称：</td>
                       <td>
                          <select name="company.id" onchange="initCompanyOrder()" id="companyid" class="required">
                           <option  id="notSelect" value=""><-- 请选择客户 --></option>
                           <s:iterator value="companies" id="tcompany">
                              <option value="<s:property value="#tcompany.id"/>" <s:if test="#tcompany.id==company.id">selected="selected"</s:if>><s:property value="#tcompany.name"/></option>
                           </s:iterator>
                          </select>
                       </td>                    
                    </tr>
                    <tr>
                       <td>订单应用名称：</td>
                       <td>
                          <select name="task.orderId" id="orderid" onchange="getTotalNumber()" class="required">
                           <option  id="notSelect" value=""><-- 请选择订单应用 --></option>
                           <s:iterator value="orders" id="order"> 
                              <option value="<s:property value="#order.id"/>" <s:if test="#order.id==task.orderId">selected="selected"</s:if>><s:property value="#order.name"/></option>
                           </s:iterator>
                          </select>
                       </td>                       
                    </tr>
                    <tr>
                       <td>允许的最大任务数：</td>
                       <td><input type="text" name="task.totalNumber" value="<s:property value="order.totalNumber"/>" id="totalNumber"/>
                                     <font color="red"><s:fielderror fieldName="task.totalNumber"/></font> 
                       </td>
                    </tr>
                    <tr>
                       <td>金币：</td>
                       <td><input type="text" name="task.goldNum" value="<s:property value="task.goldNum"/>" class="number"/>
                                     <font color="red"><s:fielderror fieldName="task.goldNum"/></font>
                       </td>
                    </tr>
                    <tr>
                       <td>任务条件：</td>
                       <td>
                           <select name="task.finishCondition">
                              <option value="0" <s:if test="task.finishCondition==0">selected="selected"</s:if>>下载</option>
                              <option value="1" <s:elseif test="task.finishCondition==1">selected="selected"</s:elseif>>安装</option>
                              <option value="2" <s:elseif test="task.finishCondition==2">selected="selected"</s:elseif>>激活</option>
                           </select>
                       </td>
                    </tr>
                    <tr>
                       <td>任务描述：</td>
                       <td width=180><input type="text" name="task.completeDescription" value="<s:property value="task.completeDescription"/>"/>
                                     <font color="red"><s:fielderror fieldName="task.completeDescription"/></font>
                       </td>
                    </tr>
                    <tr>
                       <td>是否置顶：</td>
                       <td><input type="checkbox" name="isneedtop" value="1"  <s:if test="isneedtop==1">checked="checked"</s:if>/></td>
                    </tr>
                    <tr>
                       <td>任务结束时间：</td>
                       <td><input id="d12" type="text" name="task.endDate" value="<s:date name="task.endDate" format="yyyy-MM-dd"/>" class="dateISO"/>
                                     <img onclick="WdatePicker({el:$dp.$('d12'),minDate:'%y-%M-{%d+1}'})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="middle"/>
                                     <font color="red"><s:fielderror fieldName="task.endDate"/></font>
                       </td>
                    </tr>
                    <tr>
						<td>
						        产品简介：
						</td>
						<td>
							<textarea name="task.description" rows="14" cols="60"><s:property value='task.description'/></textarea>
						    <font color="red"><s:fielderror fieldName="task.description"/></font>
						</td>					
					</tr> 
				</table>
				<div class="buttongroup" id="hasbutton">
                   <input type="submit" value="提交" class="graybtn"/>&nbsp;
                   <input type="button" value="返回" onclick="goBack()" class="graybtn"/>
                </div>
                <div>
                </div>
                </div>
			</form>
		   </div>
		 </div>
	  </body>
</html>
