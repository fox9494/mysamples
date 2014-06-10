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
    
    <title>修改一级渠道</title>
    
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
 		$("#editChannelForm").validate({
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
				    			required: true     				    			    
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
 									required:"请输入开户名称",
 									"channel.channelName":"开户名称在1到10个字符之间"
 							},
 						"channel.bankAccount":{
 									required:"请输入开户账号"
 							}, 
 						 "channel.paylevel":{
 									number:"请输入有效的结算等级",
 						 			required:"请输入结算等级"
 						 			
 						 	},
 						 "channel.TManagerInfo.userName":{
 						 			required:"请输入账号",
 						 			"channel.channelName":"账号在1到10个字符之间"
 						 	},
 						 "channel.TManagerInfo.password":{
 						 			required:"请输入密码"
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
	 		//得到市级节点
	        $("#province").change(function(){
	            $.ajax({
		   			url:"area/areaList!getAreaById.shtml?parentId="+$("#province").val(),
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
						   if(data[i].attr.id==$("#cityid").val()){
						         $("#city").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
						   }else{
						        $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>"); 
						   }
					   }
					   if($("#province").val()==""){
					            $("#city").append("<option value='' selected='selected'><--请 选 择 市--></option>");
					   }else{
					            $("#city").append("<option value='' ><--请 选 择 市--></option>");
					   }
					}																							          						    
	 		   });
	 		   $("#city").html(""); 
	         });
	         	        
		}) 
	//得到市节点 
	function getCity(){	
		 $.ajax({
		   			url:"area/areaList!getAreaById.shtml?parentId="+$("#province").val(),
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
						   if(data[i].attr.id==$("#cityid").val()){
						         $("#city").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
						   }else{
						        $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>"); 
						   }
					   }
					   if($("#province").val()==""){
					            $("#city").append("<option value='' selected='selected'><--请 选 择 市--></option>");
					   }else{
					            $("#city").append("<option value='' ><--请 选 择 市--></option>");
					   }
					}																							          						    
	 		   });
	 		   $("#city").html("");
		}
	</script>
	<style type="text/css">
.errors{		
		float: right;
		padding-right: 145px;
		}
	
	</style>
  </head>
  
  <body onload="javascript:getCity()">
	<div class="main" style="padding-top:30px;">
			<form action="<%=path %>/firstChanel/firstChannelEdit!editFirstChannel.shtml" method="post"   id="editChannelForm" name="channel"  >				
				<input type="hidden" value="<s:property value='channel.id'/>" name="channel.id"/>
				<input type="hidden"  value="<s:property value='channel.TArea.id'/>" id="cityid"/>
                <input type="hidden"  value="<s:property value='channel.TArea.parentId'/>" id="provinceid"/>
                <input type="hidden"  value="<s:property value='channel.TManagerInfo.id'/>" />						
				<div class="form" style="text-align:center;">
					<table cellspacing="0" border="0">
					<tr>
						<td class="title">
							渠道名称:
						</td>
						<td>		
							<input name="channel.channelName" type="text" id="name" value="<s:property value='channel.channelName'/>" class="required" maxlength="10" minlength="1"/>
							<font color=red>*								
							</font>
							<font class="errors" color="red"><s:fielderror fieldName="channel.channelName" /></font>
						</td>																																				 						
					</tr>
					<tr>
						<td >
							所属区域:
						</td>
						
						<td>
						    <select id="province"  >						    	
						    	<s:iterator value="listArea" id="area">	
						    		<s:if test="#area.id==channel.TArea.parentId">
						    			<option value="<s:property value='#area.id'/>" selected="selected"><s:property value="#area.statename"/></option>	
						    		</s:if>	    		
						    		<s:if test="#area.id!=channel.TArea.parentId">
						    			<option value="<s:property value='#area.id'/>" ><s:property value="#area.statename"/></option>	
						    		</s:if>
						    	</s:iterator>
						        <option  value="" ><--请选择省份--></option>							    						    							    				    						    	
						    </select>						   
						    <select name="channel.TArea.id"  style="margin-left:20px;" id="city" class="required">						    								    
						    </select><font color=red>*</font>								
						</td> 						
					</tr>
					<tr>
						<td >
							行业分类:
						</td>
						<td>
							 <select name="channel.TChannelIndustry.id" class="required">
							 <option value=""><--请选择行业--></option>
						    	<s:iterator value="listIndustry" id="industry">
						    		<s:if test="channel.TChannelIndustry.id==#industry.id">
						    			<option selected="selected" value="<s:property value='#industry.id'/>"><s:property value="#industry.name"/></option>				    			
						    		</s:if>
						    		<s:if test="channel.TChannelIndustry.id!=#industry.id">
						    			<option value="<s:property value='#industry.id'/>"><s:property value="#industry.name"/></option>
						    		</s:if>
						    	</s:iterator>
						    </select><font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td >
							联系人:
						</td>
						<td>
							<input name="channel.contactPerson" type="text" id="contactPerson" value="<s:property value='channel.contactPerson'/>" class="required" maxlength="10" minlength="1"/><font color=red>*</font>
						</td>						
					</tr>
					<tr>
						<td >
							电话:
						</td>
						<td>
							<input name="channel.mobile" type="text" id="mobile" value="<s:property value='channel.mobile'/>" onkeyup="if(isNaN(value))execCommand('undo')" class="required phone" /><font color=red>*</font>
						</td>			
					</tr>
					<tr>
						<td >
							邮件:
						</td>
						<td>
							<input name="channel.email" type="text" id="email" value="<s:property value='channel.email'/>" class="required email" /><font color=red>*</font>
						</td>					
					</tr>
					<tr>
						<td >
							开户行:
						</td>
						<td>
							<input name="channel.bank" type="text" id="bank" value="<s:property value='channel.bank'/>" class="required" maxlength="10" minlength="1"/><font color=red>*</font>
						</td>					
					</tr>					
					<tr>
						<td >
							开户行名称:
						</td>
						<td>
							<input name="channel.bankName" type="text" id="bankName" value="<s:property value='channel.bankName'/>" class="required" maxlength="10" minlength="1"/><font color=red>*</font>
						</td>				
					</tr>
					
					<tr>
						<td >
							开户账号:
						</td>
						<td>
							<input name="channel.bankAccount" type="text" id="bankAccount" value="<s:property value='channel.bankAccount'/>" onkeyup="if(isNaN(value))execCommand('undo')" class="required creditcard" /><font color=red>*</font>
						</td>
						
					</tr>
					
					<tr>
						<td >
							结算等级:
						</td>
						<td >
							<input name="channel.paylevel" type="text" id="paylevel" value="<s:property value='channel.paylevel'/>"  class="required" maxlength="10" minlength="1"/><font color=red>*</font>
						</td>
						
					</tr>
					
					<tr>
						<td >
							登录账户设置:
						</td>
						<td>
							<input name="channel.TManagerInfo.userName" type="text" id="userName" value="<s:property value='channel.TManagerInfo.userName'/>" class="required" maxlength="10" minlength="1"/>
							<font color=red>*								
							</font>
							<font color="red" class="errors"><s:fielderror fieldName="channel.TManagerInfo.userName"/></font>
						</td>																											
					</tr>
					<tr>
						<td >
							登录密码设置:
						</td>
						<td>
							<input name="channel.TManagerInfo.password" type="password" id="password" value="<s:property value='channel.TManagerInfo.password'/>" class="required"  minlength="1" /><font color=red>*</font>
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
