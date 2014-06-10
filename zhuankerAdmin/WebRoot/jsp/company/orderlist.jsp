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
    <base href="<%=basePath%>">
    
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
       //添加订单
       function addOrder(){
          window.location.href="<%=path%>/jsp/company/orderadd.jsp";
       }
       //修改订单
       function updateOrder(){
          var array=getId();
          if(array.length!=0&&array.length>1){
             alert("只能一个一个修改");
             return;
          }
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/companyorder/companyorderEdit!input.shtml?info="+array;
          
       }
       //删除订单
       function deleteOrder(){                
         array=getId();     
         if(array.length==0){
             return;
         }        
         window.location.href="<%=path%>/companyorder/companyorderDelete!delete.shtml?info="+array;
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
            alert("请至少选择一个订单"); 
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
       //返回客户管理主界面
       function goCompany(){
           window.location.href="<%=path%>/company/companyList!getUserList.shtml";
       }
    </script>
  </head>
      
  <body>
       
       <div class="main">
		<div class="btarea line">
		   <a href="javascript:;" class="graybtn" id="add" onclick="addOrder()">新增</a>
	       <a href="javascript:;" class="graybtn" onclick="updateOrder()">修改</a>
	       <a href="javascript:;" class="graybtn" onclick="deleteOrder()">删除</a>
	       <!-- <a href="javascript:;" class="graybtn" onclick="goCompany()">返回客户主界面</a> -->
   	    </div>
   	    
       <form action="companyorder/companyorderList!findByConditons.shtml" method="post">
          <div class="search">
                <ul>
                  <li>
			           <p>客户名称:</p><input type="text" name="order.company.name" value="<s:property value="order.company.name"/>"/>
                                    
                  </li>
                  <li>
                                     <input type="submit" value="查询" class="button"/>
                  </li>                  
                </ul>
		  </div>
	      <div class="list">
           <table cellspacing="0" border="0">  
             <tr class="head"><th><input type="checkbox" name="all" onclick="checkAll()"/>全选</th>
                   <td>订单ID</td>
                   <td>任务类型</td>
                   <td>应用名称</td>
                   <td>客户名称</td>
                   <td>开始日期</td>
                   <td>结束日期</td>
                   <td>金额</td>
                   <td>单价</td>
                   <td>任务量</td>
                   <td>状态</td>
             </tr>
             <s:iterator value="pageBean.list" id="tOrder">
             <tr>
                   <th><input type="checkbox" name="selectFlag" value="<s:property value="#tOrder.id"/>"/></th>
                   <td><s:property value="#tOrder.id"/></td>
                   <td>
                       <s:if test="#tOrder.type==0">
                                                                                       下载
                       </s:if>
                       <s:elseif test="#tOrder.type==1">
                                                                                         安装
                       </s:elseif>
                       <s:else>
                                                                                         激活
                       </s:else>
                   </td>
                   <td><s:property value="#tOrder.name"/></td>
                   <td><s:property value="#tOrder.company.name"/></td>
                   <td><s:date name="#tOrder.startDate" format="yyyy-MM-dd"/></td>
                   <td><s:date name="#tOrder.endDate"   format="yyyy-MM-dd"/></td>
                   <td><s:property value="#tOrder.totalmoney"/></td>
                   <td><s:property value="#tOrder.unitprice"/></td>
                   <td><s:property value="#tOrder.totalNumber"/></td>
                   <td>
                       <s:if test="#tOrder.state==0">
                                                                                           新增
                       </s:if>
                       <s:else>
                                                                                           完成
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
