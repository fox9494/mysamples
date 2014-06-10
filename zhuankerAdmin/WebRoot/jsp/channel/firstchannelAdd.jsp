<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加一级渠道</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=path %>/js/messages_zh.js"></script>
	<script type="text/javascript">
 	$(function(){
 	 $.validator.setDefaults({     
				    submitHandler: function(form) { 
						    var paylevel=$("#paylevel").val();
						    var txt=new RegExp("[ ,\\`,\\~,\\!,\\@,\#,\\$,\\%,\\^,\\+,\\*,\\&,\\\\,\\/,\\?,\\|,\\:,\\<,\\>,\\{,\\},\\(,\\),\\',\\;,\\=,\"]");
						    if(txt.test(paylevel)){
						       alert("结算等级不能有特殊字符");
						       return ;
						    }
				         form.submit(); 
				    } 
			   });
 	//form验证
 		$("#addChannelForm").validate({
 		 		rules:{
 		 				"channel.channelName":{     
				    			required: true,     
				    			minlength: 1,
				    			maxlength: 10    
				  				 },
				  		"channel.TArea.id":{     
				    			required: true    				    			    
				  				 },	
				  		"channel.contactPerson":{     
				    			required: true,     
				    			minlength: 1,
				    			maxlength: 10    
				  				 },	
				  		"channel.mobile":{     
				    			required: true     				    			   
				  				 },	
				  		"channel.email":{     
				    			required: true     				    			   
				  				 },	
				  		"channel.bank":{     
				    			required: true,     
				    			minlength: 1,
				    			maxlength: 10    
				  				 },	
				  		"channel.bankName":{     
				    			required: true,     
				    			minlength: 1,
				    			maxlength: 10    
				  				 },	
				  		"channel.bankAccount":{     
				    			required: true   
				  				 },
				  		"channel.paylevel":{     
				    			required: true,
				    			number:true,   
				    			minlength: 1,
				    			maxlength: 7    
				  				 },		 
				  		"channel.TManagerInfo.userName":{     
				    			required: true,     
				    			minlength: 1,
				    			maxlength: 10    
				  				 },		 
				  		"channel.TManagerInfo.password":{     
				    			required: true,     
				    			minlength: 1,
				    			maxlength: 10    
				  				 }	 
				  				 	
 		 				},
 				message:{
 						"channel.channelName":{
 									required:"请输入渠道名",
 									"channel.channelName":"渠道在1到10个字符之间"
 							},
 						"channel.TArea.id":{
 									required:"请选择区域",
 									"channel.channelName":"渠道在1到10个字符之间"									
 							},
 					     "channel.contactPerson":{
 									required:"请输入联系人",
 									"channel.channelName":"渠道在1到10个字符之间"
 							},
 						"channel.mobile":{
 									required:"请输入电话号码"
 							},
 						"channel.email":{
 									required:"请输入邮箱"
 							},
 						"channel.bank":{
 									required:"请输入开户行",
 									"channel.channelName":"开户行在1到10个字符之间"
 							},
 						"channel.bankName":{
 									required:"请输入开户名称"
 							},
 						"channel.bankAccount":{
 									required:"请输入开户账号"
 							}, 
 						 "channel.paylevel":{
 						 			number:"请输入有效的结算等级",
 						 			required:"请输入结算等级",
 						 			"channel.channelName":"结算等级在1到10个字符之间"
 						 	},
 						 "channel.TManagerInfo.userName":{
 						 			required:"请输入账号",
 						 			"channel.channelName":"账号在1到10个字符之间"
 						 	},
 						 "channel.TManagerInfo.password":{
 						 			required:"请输入密码",
 						 			"channel.channelName":"密码在1到10个字符之间"
 						 	}							 							 							 							
 							}
 					}); 		
	     	
		});
		
		//返回
	function back(){
			window.location="<%=path %>/firstChanel/firstchannelList!searchList.shtml";
		}
	</script>
	<script type="text/javascript">
$(function(){
//得到省级节点
     		$.ajax({
		   			url:"<%=path%>/area/areaList!initUserArea.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){         			        			             															
					   for(var i=0;i<data.length;i++){
					    if(data[i].attr.id==$("#provinceL").val()){					    	
					       $("#province").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
					    }else{
					       $("#province").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
					    }
					   }
					   $("#province").trigger("change");
					}																							          						    
	 		});

     //得到市级节点
    	 $("#province").change(function(){
    	 if($("#province").val()==-1){
    	 		$("#city").html("");
    			$("#city").append("<option value=''>"+"<--请选择市-->"+"</option>");
    	 	}else{
    	 	$.ajax({
		   			url:"<%=path%>/area/areaList!getAreaById.shtml?parentId="+$("#province").val(),
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
					      if(data[i].attr.id==$("#cityL").val()){					   		
					   			$("#city").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");		 										 					   				     
	                      }else{
	                            $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");		 										 				
	                      }				   
					   }
					}																							          						    
	 		   });
	 		   $("#city").html("");
    	 	}	           
	         });

	});	
		
	
	</script>
	<style type="text/css">
	.errors{		
		float: right;
		padding-right: 145px;				
		}
	</style>
  </head>
  
  <body>
    <div class="main" style="padding-top:30px;">
			<form action="<%=path %>/firstChanel/firstChannelAdd!saveFirstChannel.shtml" method="post"   id="addChannelForm" name="channel"  >
			<input type="hidden" value="<s:property value='channel.TArea.id'/>" id="cityL">
        	<input type="hidden" value="<s:property value='province'/>" id="provinceL">
				<div class="form" style="text-align:center;">
				<table cellspacing="0" border="0">
					<tr>
						<td class="title"> 
							渠道名称: 
						</td>
						<td>						
							<input name="channel.channelName" type="text" id="channelName" class="required " maxlength="10" minlength="1" value="<s:property value='channel.channelName'/>"/>							
							 <font color="red">*</font>						
							<font color="red" class="errors"><s:fielderror fieldName="channel.channelName"/></font>
						</td>
					</tr>
					<tr>
						<td >
							所属区域:
						</td>
						<td >
						    <select id="province" name="province" >
						     <option  value="-1" ><--请选择省份--></option>						    
						    </select>		
						    <select name="channel.TArea.id"  id="city" style="margin-left:20px;" class="required">
						     	<option value="" ><--请选择市--></option>						     	
						    </select><font color=red>*</font>								
						</td>
					</tr>
					<tr>
						<td >
							行业分类:
						</td>
						<td >
							 <SELECT name="channel.TChannelIndustry.id"  class="required" >
							 	<option value=""><--请选择行业--></option>
						    	<s:iterator value="listIndustry" id="industry">
						    		<option value="<s:property value='#industry.id'/>"<s:if test="channel.TChannelIndustry.id">selected="selected"</s:if> ><s:property value="#industry.name"/></option>
						    	</s:iterator>
						    </SELECT><font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td >
							联系人:
						</td>
						<td >
							<input name="channel.contactPerson" type="text" id="contactPerson" class="required" maxlength="50" minlength="1" value="<s:property value='channel.contactPerson'/>"/><font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td>
							电话:
						</td>
						<td >
							<input name="channel.mobile" type="text" id="mobile" onkeyup="if(isNaN(value))execCommand('undo')"  value="<s:property value='channel.mobile'/>" class="required phone"/><font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td >
							邮件:
						</td>
						<td >
							<input name="channel.email" type="text" id="email" value="<s:property value='channel.email'/>"  class="required email" /><font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td >
							开户行:
						</td>
						<td >
							<input name="channel.bank" type="text" id="bank" class="required" maxlength="10" minlength="1"  value="<s:property value='channel.bank'/>"/><font color=red>*</font>
						</td>
					</tr>
					
					<tr>
						<td >
							开户行名称:
						</td>
						<td >
							<input name="channel.bankName" type="text" id="bankName" class="required" maxlength="10" minlength="1"  value="<s:property value='channel.bankName'/>"/><font color=red>*</font>
						</td>
					</tr>
					
					<tr>
						<td >
							开户账号:
						</td>
						<td >
							<input name="channel.bankAccount" type="text" id="bankAccount" onkeyup="if(isNaN(value))execCommand('undo')" class="required creditcard" value="<s:property value='channel.bankAccount'/>"/><font color=red>*</font>
						</td>
					</tr>
					
					<tr>
						<td >
							结算等级:
						</td>
						<td >
							<input name="channel.paylevel" type="text" id="paylevel"     class="required" value="<s:property value='channel.paylevel'/>"/><font color=red>*</font>
						</td>
					</tr>
					
					<tr>
						<td >
							登录账户设置:
						</td>
						<td >
							<input name="channel.TManagerInfo.userName" type="text" id="userName" class="required" maxlength="10" minlength="1" value="<s:property value='channel.TManagerInfo.userName'/>"/>
							<font color=red>*</font>
							<font color="red" class="errors"><s:fielderror fieldName="channel.TManagerInfo.userName" /></font>
						</td>																			
					</tr>
					<tr>
						<td >
							登录密码设置:
						</td>
						<td >
							<input name="channel.TManagerInfo.password" type="password" id="password" class="required" maxlength="10" minlength="1" value="<s:property value='channel.TManagerInfo.password'/>"/><font color=red>*</font>
						</td>
					</tr>					
				</table>				
				<div class="buttongroup">
					<input type="submit" class="graybtn" value="提  交" />
					<input type="button" class="graybtn" value="返回"  onclick="javascript:back()"/>
				</div>
				</div>
			</form>
		</div>
  </body>
</html>
