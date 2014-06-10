<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/upload";
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
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
       //添加客户
       function addGift(){
          window.location.href="<%=basePath%>jsp/gift/giftadd.jsp";
       }
       function updateGift(){
          var array=getId();
          if(array.length!=0&&array.length>1){
             alert("只能一个一个修改");
             return;
          }
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/gift/giftEdit!input.shtml?info="+array;
          
       }
       function deleteGift(){
          var array=getId();
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/gift/giftDelete!delete.shtml?info="+array;
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
            alert("请至少选择一个对象"); 
        }  
		
		return array;
       }
    </script>
  </head>
      
  <body>
       <div><input type="button" value="新增" onclick="addGift()"/>&nbsp;<input type="button" value="修改" onclick="updateGift()"/>&nbsp;<input type="button" value="删除" onclick="deleteGift()"/>&nbsp;</div>
       <form action="">
          <table border="1">
             <tr>  
                   <td>选项</td>
                   <td>类别</td>
                   <td>名称</td>
                   <td>价值</td>
                   <td>所需金币</td>
                   <td>图片</td>
             </tr>
             
             <s:iterator value="pageBean.list" id="tGift">
             <tr>
                   <td><input type="checkbox" name="selectFlag" value="<s:property value="#tGift.id"/>"/></td>
                   <td>
                     <s:if test="#tGift.giftType==0">
                                                                                    充值卡
                     </s:if>
                     <s:elseif test="#tGift.giftType==1">
                                                                                    现金
                     </s:elseif>
                     <s:else>
                        Q币
                     </s:else>
                   </td>
                   <td><s:property value="#tGift.giftName"/></td>
                   <td><s:property value="#tGift.giftPrice"/></td>
                   <td><s:property value="#tGift.giftGold"/></td>
                   <td><img src="<%=imgPath%><s:property value="#tGift.giftUrl"/>" width="35px" height="35px"/></td>
             </tr>
             </s:iterator>
          </table>
          <div style=""><my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page></div>
       </form>
  </body>
</html>
