<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.errortable{
		color:#e0786d;
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
    	<tr height=207><td></td>
	    	<td width=600>
	    		<div style="width:100%;height:100%;border:1px solid #dbdbdb;padding:22px;">
	    			<div style="background-image:url('<%=path%>/images/error.png');background-repeat:no-repeat;padding-left:53px;margin-bottom:22px;height:55px;"><p style="font-weight:bold;margin-bottom:8px;">未能打开此网页！！！</p>
	    				当前网页繁忙，请你稍后再试！！！
	    			</div>
	    			<div style="background">
	    				你可以 <a href="javascript:location.reload();">点此重试</a>，重新访问此网页。<br><br>
	    				如果仍然无法打开，建议你检查网址是否正确，网络连接设置是否正常。
	    			</div>
	    		</div>
	    	</td>
	    	<td></td></tr>
    	<tr><td></td><td></td><td></td></tr>
    </table>
  </body>
</html>
