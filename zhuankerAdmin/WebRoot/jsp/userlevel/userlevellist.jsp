<%@ page language="java" import="com.soarsky.octopus.utils.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/upload";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'clientuserlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
    <script type="text/javascript">
       //添加客户
       function addUserLevel(){
         
          window.location.href="<%=basePath%>jsp/userlevel/userleveladd.jsp";
       }
       function updateUserLevel(id){ 
    
          window.location="<%=path%>/userlevel/userLevelEdit!initUserLevel.shtml?userLevel.id="+id;
       }
       function deleteUserLevel(id){
          
          window.location="<%=path%>/userlevel/userLevelDelete!delete.shtml?userLevel.id="+id;
       }
       function getId(){
		var array = new Array(); 
		//用于保存 选中的那一条数据的ID   
        var flag;
        var param=""; //判断是否一个未选   
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    if ($(this).attr("checked")) { //判断是否选中    
                        flag = true; //只要有一个被选择 设置为 true  
                    }  
                });  

        if (flag) {  
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                      if ($(this).attr("checked")) { //判断是否选中                
                           array.push($(this).val()); //将选中的值 添加到 array中   
                    }  
                    });                   
            //将要集体删除的数据 传递给action处理   
					
        } else {  
            alert("请至少选择一个用户");  
        }  
		
		return array;
       }
    </script>
  </head>
      
  <body>
       <div class="main">
		<div class="btarea line">
	       <a href="javascript:;" class="graybtn" id="add" onclick="addUserLevel()">新增</a>	       
		</div>
	           
       <form action="" name="userlevelList"> 
             <div class="search"></div>
                <div class="list">
		          <table cellspacing="0" border="0">
			             <tr class="head">			                    
			                   <td>名称</td>
			                   <td>金币数</td>
			                   <td>图标</td>
			                   <td>操作</td>
			             </tr>		            
			             <s:iterator value="pageBean.list" id="userlevel">
				             <tr>
				                   <td class="taline tahei"><s:property value="#userlevel.name"/></td>
				                   <td class="taline tahei"><s:property value="#userlevel.goldNum"/></td>
				                   <td class="taline tahei"><img src="<%=PathUtil.getHttpPath()+"/upload"%><s:property value="#userlevel.imageUrl"/>" width="35px" height="35px"/></td>
				                   <td class="taline tahei"><a href="javascript:void(0)" onclick="updateUserLevel(<s:property value="#userlevel.id"/>)">修改</a>&nbsp;<a href="javascript:void(0)" onclick="deleteUserLevel(<s:property value="#userlevel.id"/>)">删除</a></td>
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
