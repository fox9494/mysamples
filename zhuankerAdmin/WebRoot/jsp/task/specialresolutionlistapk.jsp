<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
       
       //修改特定分辨率APK
       function updateApk(id){ 
          
          window.location="<%=path%>/application/specialApkEdit!input.shtml?apkContent.id="+id+"&app.appid="+$("#appid").val()+"&task.taskid="+$("#taskid").val()+"&company.id="+$("#companyid").val();
       }
       
       //删除APK
       /*function deleteUserLevel(id){
          
          window.location="<%=path%>/userlevel/userLevelDelete!delete.shtml?userLevel.id="+id;
       }*/
       
       //返回
       function goback(){
             var taskid=$("#taskid").val();
		     var companyid=$("#companyid").val();
		     var appid=$("#appid").val();
		     if(taskid!=""){
		       window.location="<%=request.getContextPath()%>/application/applicationEdit!input.shtml?task.taskid="+taskid+"&company.id="+companyid+"&app.appid="+appid;
		     }else{
		       alert("操作失败!");
		     }
       }
       
        //新增特定分辨率APK
       function addSpecialApk(){
       
          window.location.href="<%=path%>/application/specialApkEdit!input.shtml?app.appid="+$("#appid").val()+"&task.taskid="+$("#taskid").val()+"&company.id="+$("#companyid").val();
       }
    </script>
  </head>
      
  <body>
       <div class="main">
		<div class="btarea line">
	       <a href="javascript:;" class="graybtn" id="add" onclick="addSpecialApk()">添加特定分辨率APK</a>
	       <a href="javascript:;" class="graybtn" id="add" onclick="goback()">返回</a>	       	                                   
	   </div>
       <form action="" name="">         
          <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>" id="appid"/>
          <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
          <input type="hidden" name="company.id" value="<s:property value="company.id"/>" id="companyid"/>
          <div class="list">
          <table cellspacing="0" border="0">
             <tr class="head">
                   <td>分辨率高</td>
                   <td>分辨率宽</td>
                   <td>下载地址</td>
                   <td>大小</td>
                   <td>操作</td>
             </tr>
             <s:iterator value="pageBean.list" id="apk">
             <tr>
                   <td><s:property value="#apk.resolution_height"/></td> 
                   <td><s:property value="#apk.resolution_width"/></td>
                   <td><s:property value="#apk.downloadUrl"/></td>
                   <td><s:property value="#apk.apkSize"/></td>
                   <td><a href="javascript:void(0)" onclick="updateApk(<s:property value="#apk.id"/>)">修改</a></td>
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
