<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
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

       //审核任务
       function approveTask(){          
          array=getId();         
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/task/taskApprove!approveTask.shtml?info="+array;
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
            alert("请至少选择一个任务"); 
        }  
		
		return array;
       }
       
       //全选
       function checkAll(){
         if($("input[name='all']:checkbox").attr("checked")){
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",true);          
             });            
         }else{
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",false);
             });          
         }        
       }
       
       //查看任务详情
       function searchDetail(taskid){

          window.location="<%=path%>/task/taskDetails!searchTaskDetails.shtml?task.taskid="+taskid;
       }
    </script>
  </head>
      
  <body>
	   <div class="main">
		<div class="btarea line">
	       <a href="javascript:;" class="graybtn" onclick="approveTask()">审核通过</a>
		</div>
       <form action="" method="post">          
          <div class="list">
          <table cellspacing="0" border="0">              
	            <tr class="head">
	                   <th><input type="checkbox" name="all" onclick="checkAll()"/>全选</th>
	                   <td>名称</td>
	                   <td>金币</td>
	                   <td>完成条件</td>
	                   <td>客户</td>
	                   <td>发布时间</td>
	             </tr>    
	             <s:iterator value="pageBean.list" id="tTask">
		             <tr>
		                   <th><input type="checkbox" name="selectFlag" value="<s:property value="#tTask.taskid"/>"/></th>
		                   <td><a href="#" onclick="searchDetail(<s:property value='#tTask.taskid'/>)"><s:property value="#tTask.name"/></a></td>
		                   <td><s:property value="#tTask.goldNum"/></td>
		                   <td>
		                     <s:if test="#tTask.finishCondition==0">
		                                                                                       下载
		                     </s:if>
		                     <s:elseif test="#tTask.finishCondition==1">
		                                                                                         安装
		                     </s:elseif>
		                     <s:else>
		                                                                                         激活
		                     </s:else>
		                   </td>
		                   <td><s:property value="#tTask.companyId.name"/></td>
		                   <td><s:date name="#tTask.createDate" format="yyyy-MM-dd"/></td>
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
