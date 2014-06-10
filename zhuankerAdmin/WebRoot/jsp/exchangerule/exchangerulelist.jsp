<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script type="text/javascript" src="js/jquery1.7.1.min.js"></script>
    <script type="text/javascript">
       //添加客户
       function addExchangeRule(){
       
          window.location.href="<%=basePath%>jsp/exchangerule/exchangeruleadd.jsp";
       }
       function updateExchangeRule(id){ 
          
          window.location="<%=path%>/exchangerule/exchangeRuleEdit!input.shtml?exchangRule.id="+id;
       }
       function deleteExchangeRule(id){
          
          window.location="<%=path%>/exchangerule/exchangeRuleDelete!delete.shtml?exchangRule.id="+id;
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
       <div><input type="button" value="新增" onclick="addExchangeRule()"/></div>
       <form action="" name="exchangeRule">
          <table border="1">
             <tr>
                   <td>现金兑换标准</td>
                   <td>金币兑换比例</td>
                   <td>操作</td>
             </tr>
             <s:iterator value="pageBean.list" id="exchangeRule">
             <tr>
                   <td><s:property value="#exchangeRule.gold"/></td>
                   <td><s:property value="#exchangeRule.rate"/></td>
                   <td><a href="javascript:void(0)" onclick="updateExchangeRule(<s:property value="#exchangeRule.id"/>)">修改</a>&nbsp;<a href="javascript:void(0)" onclick="deleteExchangeRule(<s:property value="#exchangeRule.id"/>)">删除</a></td>
             </tr>
             </s:iterator>
          </table>
            <div style=""><my:page total="${pageBean.totalPage}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page></div>
       </form>
  </body>
</html>
