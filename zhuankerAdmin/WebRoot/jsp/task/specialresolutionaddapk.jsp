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
			       if($("#apk").val()==""){ 
			           alert("请选择文件");
			       }else if(!/\.(apk)$/.test(path)){
			           alert("请上传APK文件");
		           }else{
			           form.submit(); 
			       }		        
			    } 
		   }); 		   
		   $("#addForm").validate({
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
			   }, 
			   "apk": {     
			    required: true,     			      
			   }       			   
			 }
		    });        
       });
    </script>
    
    <script type="text/javascript">
    
       //添加并退出
       function addAndExit(){
           
           document.addform.action="<%=path%>/application/specialApkAdd!addApkAndExit.shtml";
           
           document.addform.submit();
       }
       
       //添加并继续添加
       function addAndContinue(){
           
           document.addform.action="<%=path%>/application/specialApkAdd!addApkAndContinue.shtml";
           
           document.addform.submit();
       }
       
       //返回添加任务界面
       function goBack(){
       
          document.addform.action="<%=path%>/application/specialApkAdd!goBack.shtml";
           
          document.addform.submit();
       
       }
    </script>
  </head>
  
  <body>
   <div class="main" style="padding-top:20px;">
    <form action="" name="addform"  enctype="multipart/form-data" method="post" id="addForm">
      <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>"/>
      <input type="hidden" name="confiresubmit" value="<s:property value="confiresubmit"/>" id="confiresubmit"/>
      <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>"/> 
      <input type="hidden" name="submitApk" value="<s:property value="submitApk"/>"/>
      <input type="hidden" name="submitChannel" value="<s:property value="submitChannel"/>"/>
      <input type="hidden" name="company.id" value="<s:property value="company.id"/>" id="companyid"/>
      <div class="form"> 
       <table cellspacing="0" border="0">
          <tr>
             <td class="title">
                                                     分辨率宽：
             </td>
             <td >
               <input name="apkContent.resolution_width" class="number"/>
               <font color="red"><s:fielderror fieldName="apk.resolution_width"/></font>  
             </td>            
          </tr>
          <tr>
             <td>
                                                     分辨率高：
             </td>
             <td>
                <input name="apkContent.resolution_height" class="number"/>
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
                   <input type="button" value="返回" onclick="goBack()" class="graybtn"/>
                   <input type="button" value="保存并退出" onclick="addAndExit()" class="graybtn" />
                   <input type="button" value="保存并继续添加" onclick="addAndContinue()" class="graybtn"/>
       </div>
      </div> 
    </form>
   </div>
  </body>
</html>
