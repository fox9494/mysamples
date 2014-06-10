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
	   <link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css" >
	   
	   <script type="text/javascript">
	   
		function goBack(){
			   window.location.href="<%=path %>/admin/roleList.shtml";
	    }
	</script>
	</head>

	<body>
	
	     <div class="main" style="padding-top:20px;">
			<form action="<%=path %>/admin/roleEdit.shtml" method="post">
			    <s:hidden name="role.id"></s:hidden>
				<div class="form">
					<table cellspacing="0" border="0">
						<tr>
						   <td class="title">角色名称：</td>
						   <td>
						      <input name="role.roleName" type="text"
								 id="realName"   value="<s:property value="role.roleName"/>"/>
						   </td><td width=28></td><td><font color="red"><s:fielderror name="role.roleName"></s:fielderror></font></td>
						</tr>
					</table>
					<div class="buttongroup">
					  <input class="graybtn" type="submit" value="保存" >
		        	  <input class="graybtn" type="button" value="返回" id="back" onclick="goBack()">
					</div>
					<div>
				</div>
				</div>
			</form>
		</div>
	</body>
</html>
