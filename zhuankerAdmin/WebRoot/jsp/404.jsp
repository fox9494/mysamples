<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>赚客网 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.errortable{
		color:#777777;
	}
	.errortable p{
		margin:0;
		padding:0;
	}
	</style>
  </head>
  
  <body>
    <table style="width:100%;height:100%;" class="errortable">
    	<tr><td></td><td></td><td></td></tr>
    	<tr height=407><td></td>
	    	<td width=600 style="background-image:url('<%=path%>/images/404.png');background-repeat:no-repeat; padding-top:300px;font-size:12px;">
	    		<div style="width:100%;height:100%padding:22px;">
	    			<div style="padding-left:53px;margin-bottom:22px;height:55px;"><p style="font-weight:bold;margin-bottom:8px;font-size:18px!important;color:#5757575;">抱歉！你访问的页面不存在！！！</p>
	    				请确认你访问的地址是否正确.<br><br><br>
	    				你可以 <a href="javascript:location.reload();">点此</a>重试，重新访问此网页。或  <a href="javascript:history.back();">点此</a>返回上一页
	    			</div>
	    			
	    		</div>
	    	</td>
	    	<td></td></tr>
    	<tr><td></td><td></td><td></td></tr>
    </table>
  </body>
</html>
