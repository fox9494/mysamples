<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    
    <link rel="stylesheet" type="text/css" href="css/uploadify.css">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.uploadify.min.js"></script>
    
    <style type="text/css">
    
	    .uploadify-queue-item {
			margin-top: -50px;
			margin-left: 160px;
			
		}
    
    </style>
    
    <script type="text/javascript">
    $(function() {
    
        $('#file_upload').uploadify({
        	'auto'     : false,
            'swf'      : 'images/uploadify.swf',
            'uploader' : 'common/upload.shtml',//上传的后台处理action
            'height'   : 30,
            'width'    : 150,
            'buttonText':'浏览',
            'fileObjName': 'sourceFile',//action自动封装时需要的属性名
            // Your options here
            'formData'      : {'relativPath' : '/image/base'},//需要传给后台服务器的参数：relativPath要保存到服务器根目录的相对路径
            'onUploadSuccess' : function(file, data, response) {//上传成功后执行下面内容
            	alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
            	eval("var dataVar =" + data);
            	alert(dataVar.relativPath);
            	alert(dataVar.fileUrl);
            	$('#fileUrl').val(dataVar.fileUrl);
        	}
            
        });
        
        $('#uploadButton').click(function() {
        	$('#file_upload').uploadify('upload','*');
        });
        
    });
    
    </script>
</head>
<body>
<!-- <input type="text" name="username" id="username" value="1234" /> --> 
<input type="file" name="file_upload" id="file_upload" />

<input type="button" id="uploadButton" value="点击上传" / >
<hr>
数据库fileurl<input type="text" id="fileUrl" />


<hr>

<form action="common/upload.shtml" enctype="multipart/form-data" method="post">
	<input type="file" name="sourceFile" />
	<input type="submit" />
</form>

</body>
</html>