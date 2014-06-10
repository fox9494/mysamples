<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>添加特定分辨率APK</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
    
    <!-- 前台验证    -->
    <script type="text/javascript">
        $(document).ready(function(){
           /* 设置默认属性 */     
		   $.validator.setDefaults({     
			    submitHandler: function(form) {
			       var path=$("#apk").val();			       	       			    
			       if($("#downurl").val()==""&&$("#apk").val()==""){ 
			           alert("请选择文件");
			       }else if(!/\.(apk)$/.test(path)){
			           alert("请上传APK文件");
		           }else{
			           form.submit(); 
			       }		        
			    } 
		   }); 		   
		   $("#editForm").validate({
			/* 设置验证规则 */     
		    rules: {     
			   "apkContent.resolution_width": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   },
			   "apkContent.resolution_height": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   }		        			   
			 }
		    });        
       });
    </script>
    
    <script type="text/javascript">
   
       //返回
       function goback(){
       
          window.location="<%=path%>/application/specialApkEdit!searchList.shtml?app.appid="+$("#appid").val()+"&task.taskid="+$("#taskid").val()+"&company.id="+$("#companyid").val();
       }
       
    </script>
  </head>
  
  <body>
   <div class="main" style="padding-top:20px;">
    <form action="application/specialApkEdit!save.shtml" name="addform"  enctype="multipart/form-data" method="post" id="editForm">
      <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>" id="appid"/>
      <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
      <input type="hidden" name="company.id" value="<s:property value="company.id"/>" id="companyid"/>
      <input type="hidden" name="apkContent.id" value="<s:property value="apkContent.id"/>"/>
      <input type="hidden" name="apkContent.apkSize" value="<s:property value="apkContent.apkSize"/>"/>
      <input type="hidden" name="apkContent.downloadUrl" value="<s:property value="apkContent.downloadUrl"/>" id="downurl"/>
      <input type="hidden" name="apkContent.isDefault" value="<s:property value="apkContent.isDefault"/>"/>
      <input type="hidden" name="apkContent.uploadDate" value="<s:property value="apkContent.uploadDate"/>"/>
      <div class="form"> 
      <table cellspacing="0" border="0">
          <tr>
             <td width="80px">
                                                     分辨率宽：
             </td>
             <td>
               <input name="apkContent.resolution_width" value="<s:property value="apkContent.resolution_width"/>" class="number"/>
               <font color="red"><s:fielderror fieldName="apk.resolution_width"/></font> 
             </td>             
          </tr>
          <tr>
             <td>
                                                     分辨率高：
             </td>
             <td>
                <input name="apkContent.resolution_height" value="<s:property value="apkContent.resolution_height"/>" class="number"/>
                <font color="red"><s:fielderror fieldName="apk.resolution_height"/></font>
             </td>            
          </tr>
          <tr>
             <td>
                APK文件：
             </td>
             <td>
               <input type="file" name="apk" id="apk"/>
               <font color="red"><s:fielderror fieldName="apk.apk"/></font> 
             </td>             
          </tr>
       </table>
       <div class="buttongroup">
                   <input type="submit" value="保存"  class="graybtn"/>
                   <input type="button" value="返回" class="graybtn" onclick="goback()"/>
       </div>
       </div>
    </form>
   </div> 
  </body>
</html>
