<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edituserclient.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
    <script type="text/javascript">
       $(document).ready(function(){
           /* 设置默认属性 */     
		   $.validator.setDefaults({     
			    submitHandler: function(form) { 
			         form.submit(); 
			    } 
		   }); 
		   /* 追加自定义验证方法 */     
		   //金币数     
		   jQuery.validator.addMethod("userLevel.goldNum", function(value, element) {     
		        return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);  
		   }, "请正确输入电话");
		   $("#editForm").validate({
			/* 设置验证规则 */     
		    rules: {     
			   "userLevel.name": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 16     
			   },       
			   "userLevel.goldNum": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 10    
			    }		    
			 },
			 message:{
			    "userLevel.name": {     
		        required: "请填写赚客级别名", 
		        "userLevel.name":"名称在1到16个字符之间" 
		        },     
		        "userLevel.goldNum": {     
		        required: "请填写赚客金币数",     
		        "userLevel.goldNum": "金币数在1到10个字符之间"      
		        }	        
			 }
		    });        
       });
       //返回赚客级别列表
       function goBack(){
          window.location="<%=path %>/userlevel/userLevelList!searchList.shtml";
       }
       
    </script>
  </head>
  
  <body>
      <div class="main" style="padding-top:20px;">
       <form action="userlevel/userLevelEdit!editUserLevel.shtml" method="post" enctype="multipart/form-data" id="editForm">
          <input type="hidden" name="userLevel.imageUrl"  value="<s:property value="userLevel.imageUrl"/>"/>
          <input type="hidden" name="userLevel.isRemove"  value="<s:property value="userLevel.isRemove"/>"/>
          <input type="hidden" name="userLevel.id"  value="<s:property value="userLevel.id"/>"/>
          <div class="form">
            <table cellspacing="0" border="0">
              <tr>
                 <td>
                                                                   名称:
                 </td>
                   <td><input type="text" name="userLevel.name" value="<s:property value="userLevel.name"/>"/>
                   <font color="red"><s:fielderror fieldName="exist.editerror"/></font>
                   <font color="red"><s:fielderror fieldName="userLevel.levelName"/></font>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                   金币数:
                 </td>                   
                 <td><input type="text" name="userLevel.goldNum" value="<s:property value="userLevel.goldNum"/>"/>
                 <font color="red"><s:fielderror fieldName="userLevel.levelGold"/></font>
                 <font color="red"><s:fielderror fieldName="userLevel.goldExist"/></font>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                  升级奖励金币数:
                 </td>                                                
                 <td ><input type="text" name="userLevel.reward_num" value="<s:property value="userLevel.reward_num"/>" class="required"/>              
                 </td>
              </tr>
              <tr>
                 <td>
                                                                  图标:
                 </td>
                 <td><input type="file" name="icon"/>
                   <font color="red"><s:fielderror fieldName="userLevel.levelICON"/></font>                                               
                 </td>
              </tr>             
            </table>
            <div class="buttongroup">
                   <input type="submit" value="提交" class="graybtn"/>
                   <input type="button" value="返回" onclick="goBack()" class="graybtn"/>
            </div>  
           </div> 
          </form>
         </div> 
  </body>
</html>
