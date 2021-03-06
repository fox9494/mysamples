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
    
    <!-- 前台验证 -->
    <script type="text/javascript">
       $(document).ready(function(){
           /* 设置默认属性 */     
		   $.validator.setDefaults({     
			    submitHandler: function(form) { 
			        var companyName=$("#companyname").val();
				    var txt=new RegExp("[ ,\\`,\\~,\\!,\\@,\#,\\$,\\%,\\^,\\+,\\*,\\&,\\\\,\\/,\\?,\\|,\\:,\\.,\\<,\\>,\\{,\\},\\(,\\),\\',\\;,\\=,\"]");
				    if(txt.test(companyName)){
				       alert("客户名不能有特殊字符");
				       return ;
				    }
			        form.submit(); 
			    } 
		   }); 
		   /* 追加自定义验证方法 */     
		   //验证电话号码    
		   jQuery.validator.addMethod("company.phone", function(value, element) {     
		        return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);  
		   }, "请正确输入电话");
		   $("#editForm").validate({
			/* 设置验证规则 */     
		    rules: {     
			   "company.name": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   },   
			   "company.contactName": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   }, 
			   "company.phone": {     
			    required: true,     
			    minlength: 7,
			    maxlength: 11    
			   },
			   "company.email": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   },
			   "company.address": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   }			            			   
			 },
			 message:{
			   "company.name": {     
		        required: "请填写行业名称" ,
		        "company.name":"名称在1到20个字符之间" 
		        },
		        "company.phone": {     
		        required: "请填写电话号码" ,
		        "company.phone":"电话号码在6到12个字符之间" 
		        }     		        
			 }
		    });        
       }); 
    </script>
    
    <script type="text/javascript">
    $(function(){
            //得到省级节点
     		$.ajax({
		   			url:"area/areaList!initUserArea.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){          															
					   for(var i=0;i<data.length;i++){
					      if(data[i].attr.id==$("#provinceid").val()){
					         $("#province").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
					      }else{
					         $("#province").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
					      }
					   }
					   if($("#provinceid").val()==""){
           			          $("#province").append("<option value='' selected='selected'><--请选择省份--></option>");
           			   }else{
           			          $("#province").append("<option value=''><--请选择省份--></option>");
           			   } 
					   $("#province").trigger("change");
					}																							          						    
	 		});
	 		//得到市级节点
	        $("#province").change(function(){
	           $.ajax({
		   			url:"area/areaList!getAreaById.shtml?parentId="+$("#province").val(),
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
						   if(data[i].attr.id==$("#cityid").val()){
						         $("#city").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
						   }else{
						        $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>"); 
						   }
					   }
					   if($("#province").val()==""){
					            $("#city").append("<option value='' selected='selected'><--请 选 择 市--></option>");
					   }else{
					            $("#city").append("<option value='' ><--请 选 择 市--></option>");
					   }
					}																							          						    
	 		   });
	 		   $("#city").html("");
	         });
	 });
	 //返回
	 function goBack(){
	    window.location="<%=path %>/company/companyList!getUserList.shtml";
	 }
	 </script>
  </head>
  
  <body>
      <div class="main" style="padding-top:20px;">
       <form action="company/companyEdit!editUserClient.shtml" method="post" id="editForm">
          <input type="hidden" name="company.id" value="<s:property value="company.id"/>"/>
          <input type="hidden" name="company.isRemove" value="<s:property value="company.isRemove"/>"/>
          <input type="hidden" name="company.createDate" value="<s:property value="company.createDate"/>"/>
          <input type="hidden" name="" value="<s:property value="company.area.id"/>" id="cityid"/>
          <input type="hidden" name="" value="<s:property value="company.area.parentId"/>" id="provinceid"/>
          <div class="form">
          <table cellspacing="0" border="0">
             <tr>
                 <td class="title">
                                                                   名称:
                 </td>
                 <td >
                   <input type="text" name="company.name" value="<s:property value="company.name"/>" id="companyname"/>
                   <font color="red"><s:fielderror fieldName="company.nameExist"/></font>  
                   <font color="red"><s:fielderror fieldName="company.companyName"/></font>
                 </td>
              </tr>
             <tr>
                 <td>
                                                                      所属行业:
                 </td>
                 <td>                                                     
                        <select name="channelindustry.id">
                          <s:iterator value="channelIndustrys" id="channelIndustry">
                             <option value="<s:property value="#channelIndustry.id"/>" <s:if test="#channelIndustry.id==company.channelIndustry.id">selected="selected"</s:if>><s:property value="#channelIndustry.name"/></option>
                          </s:iterator>
                        </select>
                 </td>                 
             </tr>
             <tr>
                 <td>
                                                                   所在区域:
                 </td>
                 <td>
                         <select id="province" onchange="getCity()"></select>&nbsp;&nbsp;
                         <select id="city" name="area.id"></select>                                          
                 </td>               
             </tr>
             <tr>
                 <td>
                                                                   联系人:
                 </td>
                 <td>
                         <input type="text" name="company.contactName"  value="<s:property value="company.contactName"/>"/>
                         <font color="red"><s:fielderror fieldName="company.contactName"/></font>
                 </td>               
             </tr>
             <tr>
                 <td>
                                                                   联系电话:
                 </td>
                 <td>
                         <input type="text" name="company.phone" value="<s:property value="company.phone"/>" class="phone"/>
                         <font color="red"><s:fielderror fieldName="company.phone"/></font>
                 </td>               
             </tr>
             <tr>
                 <td>
                                                                   邮箱:
                 </td>
                 <td>
                         <input type="text" name="company.email" value="<s:property value="company.email"/>" class="email"/>
                         <font color="red"><s:fielderror fieldName="company.email"/></font>
                 </td>
             </tr>
             <tr>
                 <td>
                                                                   通信地址:
                 </td>
                 <td>
                         <input type="text" name="company.address" value="<s:property value="company.address"/>"/>
                         <font color="red"><s:fielderror fieldName="company.address"/></font>
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
