<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>非系统安装应用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script src="<%=path %>/js/jquery.XYTipsWindow.2.8.js" type="text/javascript"></script>
	<script type="text/javascript">
	function getUserId(){
			var userId = $("input[name='userId']").val();
			return userId;
		}
	function back(){
			var userid = getUserId();
			if(userid!=null){
					window.location = "<%=path%>/userclient/userclientDetails!initUserDetails.shtml?userclient.id="+userid;	
				}
			else{
				return;
			}
		}
	
	</script>
  </head>
  
  <body>
<div class="main">
		<div class="btarea line">
           <a href="javascript:;" class="graybtn" onclick="javascript:back()" >返回</a>	    		
    	</div>	
    <form action="<%=path %>/reports/findInsatllApkByUserId!findInstalledReportByUserId.shtml" method="post">
    <input  name="userId" type="hidden" value="<s:property value='userId'/>" />
	<div class="list">
		<table cellspacing="0" border="0">
		<tr class="head">
    			<td>应用名称</td>    			
    			<td>应用包名</td>
    			<td>版本号</td>
    			<td>上报时间</td>
    		</tr>
    		<s:iterator value="pageBean.list" id="installed">
    		<tr>   		
    			<td><s:property value="#installed.apkName"/></td>
    			<td><s:property value="#installed.packageName"/></td>
    			<td><s:property value="#installed.version"/></td>
    			<td><s:date name="#installed.reportDate" format="yyyy-MM-dd"/></td>	
    		</tr>
    		</s:iterator>
    	</table>
    	</div>
    	<div style="">
			<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}"
				showNum="2" currentPage="${pageBean.currentPage}"></my:page>
		</div>
    </form>
   </div>
  </body>
</html>
