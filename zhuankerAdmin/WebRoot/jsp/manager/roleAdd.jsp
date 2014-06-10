<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>新增用户</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">	
		
		<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
		<script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
		
		<script type="text/javascript">
 			$(document).ready(function(){
		       //设置提交验证     
			   $.validator.setDefaults({     
				    submitHandler: function(form) { 
				         form.submit(); 
				    } 
			   }); 
			   
		 	  $("#addForm").validate({
				/* 设置验证规则 */     
			    rules: {     
				   "role.roleName": {     
				    required: true,     
				    minlength: 2,
				    maxlength: 20    
				   }			   
				 },
				 message:{
				    "role.roleName": {     
			        required: "请填写角色名称", 
			        minlength:jQuery.format("输入至少{0}个字符"),
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        }  
			 	}
		    });
		 });		
		     
			function goBack(){
			   window.location.href="<%=path %>/admin/roleList.shtml";
			}
		</script>	
	
	</head>

	<body>
	    <div class="main" style="padding-top:20px;">
			<form action="<%=path %>/admin/roleAdd.shtml" method="post" id="addForm">
			    <s:hidden name="role.id"></s:hidden>
				<div class="form">
					<table cellspacing="0" border="0">
						<tr>
						   <td class="title">角色名称：</td>
						   <td>
						     <input name="role.roleName" type="text"
								 id="realName"   /><font color=red><s:fielderror name="role.roleName"></s:fielderror></font>
						   </td>
						</tr>
					</table>
					<div class="buttongroup">
					  <input class="graybtn" type="submit" value="保存" >
		        	  <input class="graybtn" type="button" value="返回" onclick="goBack()"/>
					</div>
					<div>
				</div>
				</div>
			</form>
		</div>
	</body>
</html>
