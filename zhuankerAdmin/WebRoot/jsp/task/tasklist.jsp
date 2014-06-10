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
	<script src="<%=path %>/js/jquery.XYTipsWindow.2.8.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>
    <script type="text/javascript">
       //初始化添加任务
       function addTask(){
          window.location.href="<%=path%>/task/taskAdd!initAddTask.shtml";
       }
       //修改任务
       function updateTask(){
          var array=getId();
          if(array.length!=0&&array.length>1){
             alert("只能一个一个修改");
             return;
          }
          if(array.length==0){
             return;
          }
          //判断任务是否过期
          $.ajax({
		   			url:"<%=path%>/task/taskEdit!findExpireState.shtml?info="+array,
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					       if(data!=null){ 
					         alert(data);
					       }else{
					         window.location.href="<%=path%>/task/taskEdit!input.shtml?info="+array;
					       } 
					}																							          						    
	 	  });        
       }
       //删除任务
       function deleteTask(){  
          array=getId(); 
          if(array.length==0){
             return;
          }        
          window.location.href="<%=path%>/task/taskDelete!delete.shtml?info="+array;
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
       //判断时间
       function dateCompare(){           
           if($("#d12").val()>$("#d13").val()){
               alert("开始时间不能大于结束时间");
               return false;
           }
       } 
    </script>
  </head>
      
  <body>
       <div class="main">
	   <div class="btarea line">
	       <a href="javascript:;" class="graybtn" id="add" onclick="addTask()">新增</a>
	       <a href="javascript:;" class="graybtn" onclick="updateTask()">修改</a>
	       <a href="javascript:;" class="graybtn" onclick="deleteTask()">删除</a>       
   	   </div> 
   	   
       <form action="task/taskList!searchListByConditions.shtml" method="post" onsubmit="return dateCompare();">
          <div class="search">
              <ul>
                <li style="width: 200px">
			        <p>任务名称:</p><input type="text" name="task.name" value="<s:property value="task.name"/>"/>
				</li>
				<li style="width: 150px">
				    <p>客户:</p><input type="text" name="task.companyId.name" value="<s:property value="task.companyId.name"/>"/>
				</li>
				<li style="width: 200px">
				    <p>开始日期:</p><input id="d12" type="text" name="task.createDate" value="<s:date name="task.createDate" format="yyyy-MM-dd"/>"/>
                                 <img onclick="WdatePicker({el:$dp.$('d12')})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif"  align="middle" style="margin-left: 15px"/>
				<li style="width: 200px">
				    <p>结束日期:</p><input id="d13" type="text" name="task.endDate" value="<s:date name="task.endDate" format="yyyy-MM-dd"/>"/>
                                 <img onclick="WdatePicker({el:$dp.$('d13')})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif"  align="middle" style="margin-left: 15px"/>
		        </li>
		        <li style="width: 200px">
		            <input type="submit" value="查询" class="button"/>
		        </li>
		      </ul>
		  </div>
		  <div class="list">
          <table cellspacing="0" border="0">
             <tr class="head"> 
                   <th><input type="checkbox" name="all" onclick="checkAll()"/>全选</th>
                   <td >名称</td>
                   <td>金币</td>
                   <td>完成条件</td>
                   <td>客户</td>
                   <td>发布时间</td>
                   <td>状态</td>
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
		                   <td>
		                   <s:if test="#tTask.expireState==1">
		                                                                                          失效
		                   </s:if>
		                   <s:else>
		                                                                                          有效
		                   </s:else>
		                   </td>
		             </tr>
	             </s:iterator>             
          </table>
          <div class="">
		        <my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}"  currentPage="${pageBean.currentPage}"></my:page>
		  </div>
         </div>
       </form>
      </div>
  </body>
</html>
