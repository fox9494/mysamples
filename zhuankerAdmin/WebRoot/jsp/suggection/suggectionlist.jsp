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
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>		
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>	
	<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>
	
    <script type="text/javascript">
       //添加客户
       function addUser(){
          window.location.href="<%=path%>/company/companyAdd!initAddUserClient.shtml";
       }
       function updateUser(){
          var array=getId();
          if(array.length!=0&&array.length>1){
             alert("只能一个一个修改");
             return;
          }
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/company/companyEdit!initUserClient.shtml?info="+array;
       }
       function deleteUser(){
          var array=getId();
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/company/companyDelete!removeUserClient.shtml?info="+array;
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
       //判断时间
       function dateCompare(){           
           if($("#d12").val()>$("#d13").val()){
               alert("开始时间不能大于结束时间");
               return false;
           }
       } 
       //查看详情
       $(function(){
        $("#dlg").dialog("close");
       });
       function checkeDetails(va){  
          $("#dlg").text(va);        
          $("#dlg").dialog();  
       }
    </script>
  </head>
      
  <body>
       <div class="main">
		<div class="btarea line"></div>
		
   <form action="suggection/suggectionList!findSuggectionByCondition.shtml" method="post" onsubmit="return dateCompare();">
          <div class="search">
             <ul> 
                 <li style="width: 200px">
                   <p>登录账号:</p><input type="text" name="userClient.userName" value="<s:property value="userClient.userName"/>"/>
                 </li>
                 <li style="width: 250px">
                   <p>开始时间:</p>
                   <input id="d12" type="text" name="startDate" value="<s:date name="startDate" format="yyyy-MM-dd"/>" readonly="readonly"/>
                   <img onclick="WdatePicker({el:$dp.$('d12')})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif" style="margin-left: 15px"/>
                 </li>
                 <li>
                   <p>结束时间:</p><input id="d13" type="text" name="endDate" value="<s:date name="endDate" format="yyyy-MM-dd"/>" readonly="readonly"/>
                   <img onclick="WdatePicker({el:$dp.$('d13')})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="middle" style="margin-left: 15px"/>
                 </li>
                 <li><input type="submit" value="查询" class="button"/></li>
             </ul>
          </div>
          <div class="list">
          <table cellspacing="0" border="0" style="table-layout:fixed;">            
             <tr class="head"> 
                   <td>反馈时间</td>
                   <td>登录账户</td>
                   <td>电话</td>
                   <td>邮箱</td>
                   <td style="word-wrap:break-word;">反馈信息</td>
             </tr>
             
             <s:iterator value="pageBean.list" id="suggection">
             <tr>
                   <td><s:date name="#suggection.replayDate" format="yyyy-MM-dd"/></td>
                   <td><s:property value="#suggection.TUserClient.userName"/></td>
                   <td><s:property value="#suggection.mobile"/></td>
                   <td><s:property value="#suggection.email"/></td>
                   <td style="text-align: left;" id="suggection">
                    <s:if test="#suggection.suggection.length()>40">
                      <a href="javascript:void(0)" onclick="checkeDetails('<s:property value="#suggection.suggection"/>')"><s:property value="#suggection.suggection.substring(0, 40)" />……</a>                  
                    </s:if>
                    <s:else>
                      <s:property value="#suggection.suggection"/>
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
  <div id="dlg"  class="easyui-dialog" title="Basic Dialog" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px;">
		            
  </div> 
</html>
