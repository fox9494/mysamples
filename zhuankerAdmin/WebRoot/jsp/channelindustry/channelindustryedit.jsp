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
		   jQuery.validator.addMethod("channelindustry.name", function(value, element) {     
		        return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);  
		   }, "请正确输入电话");
		   $("#editForm").validate({
			/* 设置验证规则 */     
		    rules: {     
			   "channelindustry.name": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   }      			   
			 },
			 message:{
			    "channelindustry.name": {     
		        required: "请填写行业名称", 
		        "channelindustry.name":"名称在1到20个字符之间" 
		        }    		        
			 }
		    });        
       });
       //返回行业列表
       function goBack(){
           window.location="<%=path %>/channelindustry/channelIndustryList!getChannelIndustryList.shtml";
       }
       
    </script>
  </head>
  
  <body>
      <div class="main" style="padding-top:20px;">
       <form action="channelindustry/channelIndustryEdit!editChannelIndustry.shtml" method="post" id="editForm">
          <input type="hidden" name="channelindustry.id" value="<s:property value="channelindustry.id"/>"/>
          <input type="hidden" name="channelindustry.isRemove" value="<s:property value="channelindustry.isRemove"/>"/>
          <div class="form">
            <table  cellspacing="0" border="0">
             <tr>
                 <td class="title">
                                                                   行业名称:
                 </td>
                 <td ><input type="text" name="channelindustry.name" value="<s:property value="channelindustry.name"/>"/>
                   <font color="red"><s:fielderror fieldName="channelIndustry.nameExist"/></font>
                   <font color="red"><s:fielderror fieldName="channelIndustry.industryName"/></font>
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
