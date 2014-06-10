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
	    <script type="text/javascript" src="js/jquery.validate.js"></script>
	    <script type="text/javascript" src="js/messages_zh.js"></script>
	    
	    <script type="text/javascript">
	    	
	    	function save(){
	    		var pass = $("#password").val();
	    		var id = $("#managerId").val();
	    		if(pass.length<6){
	    		  $("#msg").html("<font color='red'>密码长度不能小于6位</font>");
	    		  return;
	    		}
	    		$.ajax({
				   type: "POST",
				   url: "<%=path %>/admin/passEdit.shtml",
				   cache: false,
				   data: "password="+pass+"&id="+id,
				   success: function(msg){
				     if (msg==0){
     				   alert( "修改成功" );
     				   window.location.href="javascript:history.back()";
				     }else{
				       alert("修改失败");
				     }
				   }
				});
	    	
	    	
	    	}
	    
	    </script>
	  
	    
	</head>

	<body>
	    <div class="main" style="padding-top:20px;">
			<form action="<%=path %>/admin/passEdit.shtml" method="post" id="changeForm">
			    <s:hidden name="manager.id" id="managerId" />
				<div class="form">
					<table cellspacing="0" border="0">
						<tr>
						   <td class="title">用户姓名：</td>
						   <td>
						      <input name="manager.userName" type="text" id="userName" value="<s:property value="manager.userName"/>" readonly="readonly"/>
						   </td>
						<tr>
						    <td>密码：</td>
						    <td><input name="manager.password" type="password"
								 id="password"   value="<s:property value="manager.password"/>" /><span id="msg"></span></td>
					</table>
					<div class="buttongroup">
					  <input class="graybtn" type="button" value="保存" onclick="save()">
					</div>
					<div>
				</div>
				</div>
			</form>
		</div>
	</body>
</html>

