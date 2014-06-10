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
	
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script src="<%=path %>/js/jquery.XYTipsWindow.2.8.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	//自己写的
	   $(function(){
	        //删除
			 $("input[id='delete']").click(function(){
			 	var checkNum=0;
	            var array = new Array(); 
	            
	       	    $("input[name='selectFlag']").each(function(){
	       	    	if ($(this).attr("checked")=="checked"){
	       	    		checkNum++;
	       	    		array.push($(this).val());
	       	    	}
	       	    });
	       	    
	       	    if (checkNum==0){
	       	    	alert("请选择一项删除");
	       	    	return false;
	       	    }
	       	    
	       	    window.location.href="<%=path%>/admin/adminDelete.shtml?ids="+array;
	       	    return true;
			 });
			 
			  //新增
			 $("a[id='add']").click(function(){
	       	    window.location.href="<%=path %>/admin/adminAddInit.shtml";
	       	    return true;
			 });
	   });
	
		//删除
       function deleteNum(){
            var checkNum=0;
            var array = new Array(); 
            var flag=0;
            
       	    $("input[name='selectFlag']").each(function(){
       	    	if ($(this).attr("checked")=="checked"){
       	    		checkNum++;
       	    		if ($(this).val()==1){
       	    			flag=1;
       	    		}
       	    		array.push($(this).val());
       	    	}
       	    });

       	    if (flag==1){
       	    	alert("不能删除admin账户");
       	    	return false;
       	    }
       	    
       	    if (checkNum==0){
       	    	alert("请选择一项删除");
       	    	return false;
       	    }
       	    $.ajax({
		   			url:"<%=path%>/admin/judgeMgrChannel.shtml?ids="+array,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){      															
					     var judgeName=data.judgeName;
			          if(judgeName==0){
			        
			              alert("该用户下有渠道,不能删除!");
			            }
                       else if(judgeName==1){
                         window.location="<%=path%>/admin/adminDelete.shtml?ids="+array;
					    }
					   
					},
					error:function(data){
					  alert("出错了");
					}																							          						    
	 		      });
       	    
       	   
       	    
          }
	
		//全选
       function checkAll(){
         if($("input[name='selecAll']:checkbox").attr("checked")){
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",true);
             });
         }else{
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",false);
             });
         }
       }
       
       /*修改判断*/
       function checkBoxNum(){
            var checkNum=0;
            var managerId;
       	    $("input[name='selectFlag']").each(function(){
       	    	if ($(this).attr("checked")=="checked"){
       	    		checkNum++;
       	    		managerId = $(this).val();
       	    	}
       	    });
       	    
       	    if (checkNum==0){
       	    	alert("请选择一项修改");
       	    	return false;
       	    }
       	    
       	    if (checkNum>1){
       	    	alert("只能选择一项");
       	    	return false;
       	    }
       	    
       	    
       	    window.location.href="<%=path%>/admin/adminEditInit.shtml?id="+managerId;
       	    return true;
       }
       
        /*初始化密码*/
       function initPass(){
           var checkNum=0;
           var array = new Array(); 
       	    $("input[name='selectFlag']").each(function(){
       	    	if ($(this).attr("checked")=="checked"){
       	    		checkNum++;
       	    		array.push($(this).val());
       	    	}
       	    });
       	    
       	    if (checkNum==0){
       	    	alert("请选择一项修改");
       	    	return false;
       	    }
       	    
       	    
       	    window.location.href="<%=path%>/admin/adminInitPass.shtml?ids="+array;
       	    return true;
       }
	
	
	</script>

  </head>
  
  <body>
    
	
	<div class="main">
	<div class="btarea line">
       <a href="javascript:;" class="graybtn" id="add">新增</a>
       <a href="javascript:;" class="graybtn" onclick="return checkBoxNum();">修改</a>
       <a href="javascript:;" class="graybtn" onclick="return deleteNum();">删除</a>
       <a href="javascript:;" class="graybtn" onclick="return initPass();">密码初始化</a>
	</div>
	  <form action="<%=path %>/admin/adminList.shtml" method="post">
	  <!--  
		<div class="search">
			<ul>
				<li>
					<p>任务名称：</p><input type="text"> 
				</li>
				<li>
					<p>渠道：</p><select><option>选择</option><option>选择</option><option>选择</option><option>选择</option><option>选择</option><option>选择</option><option>选择</option><option>选择</option><option>选择</option></select> 
				</li>
				<li>
				<input type="submit" class="button"/> 
				</li>
			</ul>
		</div>-->
		<div class="list">
			<table cellspacing="0" border="0">
				<tr class="head"><th><input type="checkbox" onclick="checkAll()" name="selecAll"/>全选</th><td>用户姓名</td><td>登录账号</td><td>所属角色</td></tr>
				<s:iterator value="pageBean.list" id="manager" status="sta">
			 	  <tr>
			 	    <th><input type="checkbox" name="selectFlag" value="<s:property value="#manager.id"/>"/></th>
				    <td><s:property value="#manager.realName"/></td>
				    <td><s:property value="#manager.userName"/></td>
				    <td><s:property value="#manager.TRoleInfo.roleName"/></td>
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
