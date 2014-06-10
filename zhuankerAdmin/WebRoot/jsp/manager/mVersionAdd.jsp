<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mversionAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
	<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/CKEdit4.1/ckeditor.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/messages_zh.js"></script>
	
    <script type="text/javascript">
        //上传APK
        function uploadAPK(){
		   var path=$("#apk").val();
		   if(path==""){
		     alert("上传前请选择APK文件");
		     return;
		   }else if(!/\.(apk)$/.test(path)){
			           alert("请上传APK文件!");
			           return;
		   }
		      document.getElementById("addForm").action="<%=request.getContextPath()%>/mversion/versionadd!uploadApk.shtml";
		      document.form.submit();
		  }
		  function addVersion(){
		   var b=null;
		   var y=0;
		   var versionNo=$("#versionNo").val();
		   if(versionNo==""){
		        alert("请先上传APK");
		        b=false;
		        return false;
		   }
		   else {
		     return true;
		   }
		   }
		  
		  function goBack(){
	         window.location="<%=request.getContextPath()%>/mversion/versionlist!versionList.shtml";
          }
    </script>
    <!-- 表单验证 -->
    <script type="text/javascript">
          $(document).ready(function(){     
   
		/* 设置默认属性 */     
		   $.validator.setDefaults({     
		    submitHandler: function(form) { 
		       if(addVersion()){
		         form.submit(); 
		       }
		    }     
		   });     
		   // 中文字两个字节     
		   jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {     
		     var length = value.length;     
		     for(var i = 0; i < value.length; i++){     
		      if(value.charCodeAt(i) > 127){     
		     length++;     
		    }     
		  }     
		  return this.optional(element) || ( length >= param[0] && length <= param[1] );     
		}, "请确保输入的值在4-16个字符之间(一个中文字算2个字节)");     
		   
		/* 追加自定义验证方法 */     
		
		$("#addForm").validate({     
		/* 设置验证规则 */     
		  rules: {     
		   "tversion.uploadDate": {     
		    required: true         
		   }  
		 },
		   /* 设置错误信息 */ 
		    messages: {     
			"tversion.uploadDate": {     
		    required: "请填写上传日期", 
		    "tversion.uploadDate":"上传日期不能为空" 
		         }
		   
		        }    
		     });
		  });   
			
        </script>
        
   
  
  </head>
  
  <body>
   <div class="main" >
			<div class="toolpad clearfix">
				<label style="font-size: 14px"><strong>添加版本</strong></label>
			</div>
			<form  method="post" id="addForm" enctype="multipart/form-data" name="form" action="mversion/versionadd!versionAdd.shtml">
             <input type="hidden" name="tversion.apkUrl" value="<s:property value='tversion.apkUrl'/>"/>
            <div class="form">
             <table cellspacing="0" border="0" style="padding:0px 100px 0px 0px;">
                    <tr>
                      <td class="c01">
                                                                       上传APK： 
                       </td>
                       <td>
                           <input type="file" name="apk" id="apk" value="<s:property value='apkcontent.versionFileName'/>"/><input type="button" value="上传" style="width: 80px" onclick="uploadAPK()"/>
                       
                       </td> 
                   </tr>
					<tr>                
						<td class="c01">
							版本：
						</td>
						<td> 
							<input name="tversion.version" value="<s:property value='tversion.version'/>" readonly="readonly" id="versionNo"></input>
                             <font color="red">上传apk文件后自动获取 <s:fielderror fieldName="tversion.version"/></font>
						</td>
					</tr>
                    
                    <tr>
						<td class="c01">
							是否必须升级:
						</td>
						<td>
							<select name="tversion.forceUpdate"><option value="0">否</option><option value="1">是</option></select>
						    <font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
					</tr> 
                    <tr>
						<td class="c01">
							发布日期：
						</td>
						<td>
							<input onClick="WdatePicker()" readonly="readonly"  format='yyyy-MM-dd' type="text" id="date-input" name="tversion.uploadDate" value="<s:property value='tversion.uploadDate'/>"></input>
						    <font color="red">格式'YYYY-MM-DD'</font>
                        </td>
					</tr> 
                     <tr>
						<td class="c01">
						              简介：
						</td>
						<td >
							<textarea name="tversion.description"  class="ckeditor"><s:property value='tversion.description'/></textarea>         
						</td>
					</tr> 
				</table>
				</div>
				<br>
				<div class="buttongroup">
					<input type="submit" style="width: 100px;" value="提  交" class="graybtn"/>
                    <input type="button" style="width: 100px;" value="返回" onclick="goBack()" class="graybtn"/>
				</div>
			</form>
		</div>
  </body>
</html>
