<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/libs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>My JSP 'actionInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path%>/css/pf_style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery1.7.1.min.js"></script>
	<script type="text/javascript">

	//搜索查詢
	function searchInfo(cur){
		
		//document.getElementById("currentPage").value = cur;
		//var search = document.getElementById("search_form");
		//search.action="roleList!searchListPage.action";
		//search.submit();
		$("#currentPage").val(cur);
		$("#search_form").attr("action","adminRoleList!searchListPage.action");
		$("#search_form").submit();
	}
	
	
	//搜索查詢
	function checkSubmit(cur){
		$("#currentPage").val(cur);
		$("#roleNameParam").val($("roleName").val());
		//document.getElementById("currentPage").value = cur;
		//document.getElementById("content").value = document.getElementById("contentParmas").value;
		//var search = document.getElementById("search_form");
		//search.action="ActionNoticeAction!searchActionNoticeListPage.action";
		alert($("#currentPage").val());
		alert($("#roleNameParam").val());
		$("#search_form").attr("action","adminRoleList!searchListPage.action");
		$("#search_form").submit();
		//search.submit();
	}
	
	//查看角色
	function LookUp(item_id){
			window.location="<%=request.getContextPath()%>/roleEdit!initEditRole.action?roleId="+item_id;
	}
	
	//新增角色
	function addAdminRole(){
		window.location="<%=request.getContextPath()%>/adminRoleAdd!initAddRole.action";
	}
	
	//删除角色
   //	function deleteAction(id){
	 //   var msg="您确定要删除此条记录吗?";
		//    if(confirm(msg)==true){
		  //  	window.location.href="<%=request.getContextPath()%>/Roledelete!deleteRole.action?roleId="+id;
		    //}
		    //else{
		      //  return false;
		    //}
   //}
   
   
    //删除角色
		 function deleteAction(id){
		 				var msg="您确认删除此条记录吗？";
		 				if(confirm(msg)==true){
		 				$.ajax({
		 						url:'Roledelete!deleteRole.action?roleId='+id,
		 						type:'post',
		 						dataType:'json',
		 						cache:false,
		 						success:function(data){
		 								 $.each(data,function(i,value){
				 								 if(value.msg!=null){
						 								 if(value.flag==false){
						 								 		alert(value.msg);						 									 	
						 									}
				 									 		else if(value.flag==true){
				 									 			alert(value.msg);
				 									 			window.location.reload();
				 									 		}			 										 
				 									 }		 								 		
					             			 });
		 							}
		 						});
		 				}
		 				else{
		 					return false;
		 				}
		 		}
		 			
	
	</script>
  </head>
  <body>
  
   <div class="rightContent">
			<div class="toolpad clearfix">
				<table style="text-align: right;width: 100%">
					<tr>
						<td>
						   角色名:
						</td>
						<td>
							<input type="text" name="role.roleName" id="roleName" value=${role.roleName}></input>
						</td>
						<td>&nbsp;&nbsp;</td>
						<td>
							 <!-- <a class="input" href="javascript:void(0)" onclick="checkSubmit(1)"></a>-->
							  <input type="button" value="搜索" onclick="checkSubmit(1)" />
						</td>
						<td>&nbsp;&nbsp;</td>
						<td>
							<!-- <a class="input" href="javascript:void(0)" onclick="addAdmin()">新增角色</a>-->
							 <input type="button" value="新增角色" onclick="addAdminRole()" />
						</td>
					</tr>
				</table>
			</div>
			<form method="post" name="pageInfo">
				<table class="listtable" width="100%">
					<tr>
						<th>序号</th>
						<th>角色名</th>
						<th>角色简介</th>
						<th>创建时间</th>
						<th style="width: 100px;">操作</th>
					</tr>
					
					<c:forEach var="role" items="${pageBean.list}" varStatus="s">
					    <tr onmouseover="this.className='tr_o'"
								onmouseout="this.className='tr_s'" class="tr_s">
								
						   <td >${s.index + 1}</td>
						   <td  style="text-align: left;">
			            	     ${role.roleName}
			               </td>
			               <td  style="text-align: left;">
			            	     ${role.remark}
			               </td>
			               <td  style="text-align: left;">
			            	    <fmt:formatDate value="${role.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			               </td>
			               <td>
				           		<a href="#" onclick="LookUp('<s:property value='#tappRole.roleId'/>')" >修改</a>
				           		&nbsp;|&nbsp;
				           		<a href="javascript:void(0)" onclick="deleteAction(<s:property value="#tappRole.roleId"/>)">删除</a>
			           	   </td>
					</c:forEach>
		        </table>
		        <div style="text-align:right;" class="pageArea">
		        		<s:if test="pageBean.list!=null">
				         	<div style="">
								<a href="javascript:void(0)" onclick="searchInfo(1)" class="linkFirst">&nbsp;&nbsp;首页 </a><a href="javascript:void(0)" onclick="searchInfo(${pageBean.currentPage-1})" class="linkBack">&nbsp;上一页</a>
								<a href="javascript:void(0)" onclick="searchInfo(${pageBean.currentPage+1})" class="linkNext"> 下一页&nbsp; </a><a href="javascript:void(0)" onclick="searchInfo(${pageBean.totalPage})" class="linkLast">尾页&nbsp;&nbsp;</a>
								第${pageBean.currentPage}页/共${pageBean.totalPage}页 共计${pageBean.allRow}条
								转到&nbsp;<input type="text" name="pageBean.currentPage" value="<s:property value='pageBean.currentPage'/>" style="width:35px; text-align: center;" onblur="this.value=this.value.replace(/[^\d\.]+/g,'')"
											onafterpaste="this.value=this.value.replace(/[^\d\.]+/g,'')" id="pagenum"/>&nbsp;页
								 <input type="button" value="go" onclick="searchInfo(document.getElementById('pagenum').value)" />
					    	</div>
			         	</s:if>
			         	<s:else>
			         		<div>
								<a href="javascript:void(0)" class="linkFirst">&nbsp;&nbsp;首页 </a><a href="javascript:void(0)" class="linkBack">&nbsp;上一页</a>
								<a href="javascript:void(0)" class="linkNext"> 下一页 &nbsp;</a><a href="javascript:void(0)" class="linkLast">尾页&nbsp;&nbsp;</a>
								 一共<s:property value="pageBean.totalPage"></s:property> 页 
								当前是第<s:property value="pageBean.currentPage"></s:property>页 
								转到&nbsp;
											<input type="text" name="pageBean.currentPage"
												value="<s:property value='pageBean.currentPage'/>"
												style="width: 35px; text-align: center;"
												onblur="this.value=this.value.replace(/[^\d\.]+/g,'')"
												onafterpaste="this.value=this.value.replace(/[^\d\.]+/g,'')" id="page"/>
											&nbsp;页
								 <input type="button" value="go" onclick="goPage()"/>
					    	</div>
			         	</s:else>
			         	
			       </div>
			</form>
			
		  	<s:form  method="post" id="search_form">
		  		    <input name="currentPage" type="hidden" id="currentPage"/>
		  		    <input name="role.roleName" type="hidden" id="roleNameParam"/>
		  	</s:form>
	</div>
  </body>
</html>
