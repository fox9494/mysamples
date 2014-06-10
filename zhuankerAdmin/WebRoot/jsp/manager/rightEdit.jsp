<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editRight.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css" >
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/jstree/themes/classic/style.css" />
	<script src="<%=path %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="<%=path %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.hotkeys.js"></script>
	
	<script type="text/javascript">
		function checkSubmit(){
			var form = document.getElementById("addForm");
			form.action="<%=path%>/admin/rightEdit.shtml";
			form.submit();
		}
		
		function goBack(){
			   window.location.href="<%=path %>/admin/roleList.shtml";
	    }
	</script>
  </head>
  
  <body>
  
     <div class="main" style="padding-top:20px;">
			<form action="<%=path%>/admin/rightEdit.shtml" method="post" id="addForm">
			     <s:hidden name="role.id" />
				<div class="form">
					<table cellspacing="0" border="0">
						<tr>
						   <td width="70px">角色名称：</td>
						   <td >
						     <input id="roleName" name="role.roleName" type="text" value="${role.roleName }" readonly="readonly"/>
						   </td>
						</tr>
						
						<tr>
						   <td>操作范围：</td>
						   <td width="300px">
						      <s:iterator value="modelList" id="model" status="sta">
							   <div style="float: left;width: 120px;text-align: left">
								<input type="checkbox" name="model" value="<s:property value="#model.ID"/>" 
								 <s:iterator value="role.TRightInfos" id="right" status="sta">
								 	<s:if test="#right.TModelInfo.id==#model.ID">checked="checked"</s:if>
								 </s:iterator> style="width: auto; vertical-align: middle;"
								><s:property value="#model.NAME"/>
							  </div>
							 <%--  <s:if test="#sta.even">
        		                <br/>
   							  </s:if> --%>
					          </s:iterator>
						   </td>
						</tr>
					</table>
					<div class="buttongroup">
					  <input class="graybtn" type="button" value="保存"  onclick="return checkSubmit()">
		        	  <input class="graybtn" type="button" value="返回" onclick="goBack()">
					</div>
					<div>
				</div>
				</div>
			</form>
	   </div>
  </body>
</html>
