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
		
	    <link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
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
				   "manager.realName": {     
				    required: true,     
				    minlength: 2,
				    maxlength: 20    
				   },
				   "manager.userName": {     
				    required: true,     
				    minlength: 6,
				    maxlength: 20    
				   },
				   "manager.TRoleInfo.id":{
				    required: true     
				   }    			   
				 },
				 message:{
				    "manager.realName": {     
			        required: "请填写用户名称", 
			        minlength:jQuery.format("输入至少{0}个字符"),
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        },
			        "manager.userName": {     
			        required: "请填写用户账号", 
			        minlength:jQuery.format("输入至少{0}个字符"),
			        maxlength: jQuery.format("输入不能超过{0}个字符")
			        },  
			        "manager.TRoleInfo.id": {     
			           required: "请选择用户角色" 
			        }		        
			 	}
		    });
		 });
	    
			function goBack(){
			   window.location.href="<%=path %>/admin/adminList.shtml";
			}
		</script>
	</head>

	<body>
	    <div class="main" style="padding-top:20px;">
			<form action="<%=path %>/admin/adminEdit.shtml" method="post" id="addForm">
			    <s:hidden name="manager.id" />
				<div class="form">
					<table cellspacing="0" border="0">
						<tr>
						   <td class="title">用户姓名：</td>
						   <td>
						      <input name="manager.realName" type="text" id="realName" value="<s:property value="manager.realName"/>"/>
						   </td>
						<tr>
						    <td>登录账号：</td>
						    <td><input name="manager.userName" type="text"
								 id="useName"   value="<s:property value="manager.userName"/>"/>
						    <font color="red"><s:fielderror name="manager.userName"></s:fielderror>	</font>	 
							</td>
						<tr>
						    <td>用户角色：</td>
							<td> 
						       <select name="manager.TRoleInfo.id">
						    	<s:iterator value="roleList" id="role">
						    		<option value="<s:property value="#role.id"/>" <s:if test="#role.id==manager.TRoleInfo.id">selected="selected"</s:if>><s:property value="#role.roleName"/></option>
						    	</s:iterator>
						       </select>
						    </td>
						</tr>
					</table>
					<div class="buttongroup">
					  <s:if test="manager.id!=1">
					     <input class="graybtn" type="submit" value="保存" >
					  </s:if>
		        	  <input class="graybtn" type="button" value="返回" onclick="goBack()">
					</div>
					<div>
				</div>
				</div>
			</form>
		</div>
	</body>
</html>
