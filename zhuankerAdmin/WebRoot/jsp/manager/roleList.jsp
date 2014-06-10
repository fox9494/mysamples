<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	
	<script type="text/javascript">
	  
		//新增
       function addRole(){
         window.location.href="<%=path%>/admin/roleAddInit.shtml";
       }
       //角色是否能被删除的判断提示
       function deleteRole(id){
             $.ajax({
		   			url:"<%=path%>/admin/judgeMgrRole.shtml?id="+id,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){      															
					     var judgeName=data.judgeName;
			          if(judgeName==0){
			        
			              alert("该角色下有用户,不能删除!");
			            }
                       else if(judgeName==1){
                         window.location="<%=path %>/admin/roleDelete.shtml?id="+id;
					    }
					   
					},
					error:function(data){
					  alert("出错了");
					}																							          						    
	 		      });
       
       }
	
	</script>

  </head>
  
  <body>
  
    <div class="main">
	  <div class="btarea line">
	      <a href="javascript:;" class="graybtn" id="add" onclick="addRole();">新增</a>
	   </div>
	  <form action="<%=path %>/admin/roleList.shtml" method="post">
	  <input type="hidden" id="judgeRemove" value="<s:property value="judgeRemove"/>">
	  <input type="hidden" id="judgeRoleName" value="<s:property value="judgeRoleName"/>">
	  
		<div class="list">
			<table cellspacing="0" border="0">
				<tr class="head"><td>角色名称</td><td>操作</td></tr>
				
				<s:iterator value="pageBean.list" id="role" status="sta">
			 	  <tr>
				    <td><s:property value="#role.roleName"/></td>
				    <td>
				       <s:if test="#role.id!=1 && #role.id!=2">
				       <a href="<%=path %>/admin/rightEditInit.shtml?id=<s:property value="#role.id"/>">修改权限</a>&nbsp;&nbsp;
				       <a href="<%=path %>/admin/roleEditInit.shtml?id=<s:property value="#role.id"/>">修改名称</a>&nbsp;&nbsp;
				       <a href="javascript:;" class="graybtn" id="del" onclick="deleteRole(<s:property value="#role.id"/>)">删除</a>&nbsp;&nbsp;
				       </s:if>
				       <s:else>
				         <a href="<%=path %>/admin/rightQuery.shtml?id=<s:property value="#role.id"/>">查看权限</a>&nbsp;&nbsp;
				       </s:else>
				    </td>
				  </tr>
		        </s:iterator>
				
			</table>
			<div class="">
			   <my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
			</div>
		 </div>
		</form>
	</div>
   
  </body>
</html>
