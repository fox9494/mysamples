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
    
    <title>My JSP 'channelMgrAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/messages_zh.js"></script>
    <script type="text/javascript">	
     function init(parentId){ 			      
	           $.ajax({
		   			url:"<%=path%>/area/areaList!getAreaById.shtml?parentId="+parentId,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){					   
					      $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
					   }
					}																							          						    
	 		   });
	 		   $("#city").html("");		
 	}
		function goBack(){
	         window.location="<%=request.getContextPath()%>/jsp/channel/channelMgrList.jsp";
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
	         	        
		}); 
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
	<!-- 表单验证 -->
	<script type="text/javascript">
	      $(document).ready(function(){     
			   
			/* 设置默认属性 */     
			   $.validator.setDefaults({     
			    submitHandler: function(form) { form.submit(); }     
			   });     
			   // 中文字两个字节     
			   jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {     
			     var length = value.length;     
			     for(var i = 0; i < value.length; i++){     
			      if(value.charCodeAt(i) > 127){     
			     length++;     
			    }     
			  }     
			  return this.optional(element) || ( length >= param[0] && length <= param[1] );     
			}, "请确保输入的值在4-16个字符之间(一个中文字算2个字符)");       
			   
			// 字符验证     
			jQuery.validator.addMethod("channel.channelName", function(value, element) {   
			 return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);    
			}, "用户名只能包括中文字、英文字母、数字和下划线");        
			   
			// 电话号码验证     
			jQuery.validator.addMethod("channel.mobile", function(value, element) {     
			  return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);   
			}, "请正确填写您的电话号码");     
			   
			// 联系人验证
			jQuery.validator.addMethod("channel.contactPerson",function(value, element){			
			    return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
			},"请正确填写你的姓名");
			 
			
			
			$("#addForm").validate({     
			/* 设置验证规则 */     
			  rules: {     
			   "channel.channelName": {     
			       required: true 
			   },     
			           
			   "channel.contactPerson": {     
			     required: true 		        
			   },     
			   "channel.mobile": {     
			    required: true   
			   },     
			   "channel.email": {     
			    required: true, 
			    email :true
			          
			   },     
			   "channel.TManagerInfo.userName":{
			      required: true 
			   },
			   "channel.TManagerInfo.password" :{
			       required: true 
			   },
			   repassword:{
			      required: true, 
			      equalTo: "#password" 
			   }
			  },
			      
			/* 设置错误信息 */  
			   
			  messages: {     
				"channel.channelName": {     
			    required: "请填写渠道名称", 
			     minlength: jQuery.format("输入至少{0}个字符"),
			     maxlength: jQuery.format("输入最多{0}个字符")     
			   },     
			   "channel.TManagerInfo.password": {     
			    required: "请填写密码",     
			    minlength: jQuery.format("输入至少{0}个字符"),
			    maxlength: jQuery.format("输入最多{0}个字符")     
			   },     
			   repassword: {     
			    required: "请填写确认密码",
			    minlength: jQuery.format("输入至少{0}个字符"),
			    maxlength: jQuery.format("输入最多{0}个字符"),    
			    equalTo: "两次密码输入不相同"     
			   },      
			   "channel.contactPerson": {     
			    required: "请填写您的姓名",
			    minlength: jQuery.format("输入至少{0}个字符"),
			    maxlength: jQuery.format("输入最多{0}个字符")     
			   },     
			   "channel.email": {     
			    required: "请输入email",      
			    "channel.email": "请输入一个有效的email"     
			   },
			   "channel.mobile": {     
			    required: "请输入固定电话", 
			    minlength: jQuery.format("输入至少{0}个字符"),
			    maxlength: jQuery.format("输入最多{0}个字符"),    
			    "channel.mobile": "请输入一个有效的固定电话"     
			   }
			   
			  } 
			  
			   }); 
			   
			});
	
	
	</script>
  </head>
  
  <body onload="javascript:getCity()">
  <div class="main" style="padding-top:20px;">
			<form action="<%=path %>/channel/channelEdit!editChannel.shtml" method="post"   id="addForm" name="channel"  >
			    <input id="parentId" name="channel.parent.id" value="<s:property value='parChannel.id'/>" type="hidden">
			    <input id="channelId" name="channel.id" value="<s:property value='channel.id'/>" type="hidden">  
			    <input name="channel.levelCode" value="<s:property value='channel.levelCode'/>" type="hidden">
			    	<input type="hidden"  value="<s:property value='channel.TArea.id'/>" id="cityid"/>
                <input type="hidden"  value="<s:property value='channel.TArea.parentId'/>" id="provinceid"/>
				<div class="form">
				<table cellspacing="0" border="0">
					<tr>
						<td class="title">
							渠道名称:
						</td>
						<td>
							<input name="channel.channelName" type="text" id="name" value="<s:property value='channel.channelName'/>" />
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="channel.channelName"/></font>
						</td>
					</tr>
					<tr>
					    <td>上级渠道名称:</td>
					    <td>
					        <input name="" value="<s:property value='parChannel.channelName'/>" type="text" readonly="readonly">
					    </td>
					
					</tr>
					<tr>
							<td >
							所属区域:
						</td>
						<td >
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
							 <SELECT name="channel.TChannelIndustry.id" style="width:150px;">
						    	<s:iterator value="listIndustry" id="industry">
						    		<option value="<s:property value='#industry.id'/>"><s:property value="#industry.name"/></option>
						    	</s:iterator>
						    </SELECT>
						</td>
					</tr>
					<tr>
						<td >
							联系人:
						</td>
						<td>
							<input name="channel.contactPerson" type="text" id="contactPerson" value="<s:property value='channel.contactPerson'/>"/>
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="channel.contactPerson"/></font>
						</td>
					</tr>
					<tr>
						<td >
							电话:
						</td>
						<td>
							<input name="channel.mobile" value="<s:property value='channel.mobile'/>"  type="text" id="mobile" onkeyup="if(isNaN(value))execCommand('undo')"/>
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="channel.mobile"/></font>
						</td>
					</tr>
					<tr>
						<td >
							邮件:
						</td>
						<td>
							<input name="channel.email" value="<s:property value='channel.email'/>" type="text" id="email"/>
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="channel.email"/></font>
						</td>
					</tr>								
					<tr>
						<td >
							登录账户设置:
						</td>
						<td>
							<input name="channel.TManagerInfo.userName"  value="<s:property value='channel.TManagerInfo.userName'/>" type="text" id="userName" />
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="channel.TManagerInfo.userName"/></font>
						</td>
					</tr>
					<tr>
						<td >
							登录密码设置:
						</td>
						<td>
							<input name="channel.TManagerInfo.password"  value="<s:property value='channel.TManagerInfo.password'/>" type="password" id="password"/>
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="channel.TManagerInfo.password"/></font>
						</td>
					</tr>
					<tr>
					    <td>确认密码:</td>
					    <td>
					        <input name="repassword" value="<s:property value='channel.TManagerInfo.password'/>" type="password" id="password"/>
							<font color="red">&nbsp;<b>*</b>&nbsp;</font>					    
					    </td>
					</tr>
					
				</table>
				</div>
				<br>
				<div class="buttongroup">
					<input type="submit" style="width: 100px;" value="提  交"  class="graybtn" />
					<input type="button" style="width: 100px;" value="返回"  onclick="goBack()"  class="graybtn"/>
				</div>
			</form>
		</div>
  
  </body>
</html>
