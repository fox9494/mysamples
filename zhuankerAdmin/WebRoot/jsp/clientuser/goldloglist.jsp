<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>金币日志记录</title>

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
	<form action="<%=path%>/details/goldChangeList!searchList.shtml"
		method="post">
		<input  name="userId" type="hidden" value="<s:property value='userId'/>" />
	<div class="list">
		<table cellspacing="0" border="0">
			<tr class="head">
				<td>时间</td>
				<td>本次金币</td>
				<td>当前金币</td>
				<td>金币增/减</td>
				<td>描述</td>
			</tr>
			<s:iterator value="pageBean.list" id="gold" >
				<tr>
					<td><s:date name="#gold.dealDate"
							format=" yyyy-MM-dd" />
					</td>
					<td><s:property value="#gold.currentExchangeNum" /></td>					
					<td><s:property value="#gold.currentGold" /></td>
					<td>
					   <s:if test="#gold.operateType==1">
					                 减<s:property value="#gold.currentExchangeNum" />
					   </s:if>
					   <s:elseif test="#gold.operateType==2">
					                 减<s:property value="#gold.currentExchangeNum" />
					   </s:elseif>
					   <s:else>
					                 增<s:property value="#gold.currentExchangeNum" />
					   </s:else>
                    </td>							
					<s:if test="#gold.operateType==0">
						<td>游戏增加的金币</td>
					</s:if>
					<s:if test="#gold.operateType==1">
						<td>游戏减少的金币</td>
					</s:if>
					<s:if test="#gold.operateType==2">
						<td>兑换的金币</td>
					</s:if>
					<s:if test="#gold.operateType==3">
						<td>任务增加的金币</td>
					</s:if>
					<s:if test="#gold.operateType==4">
						<td>奴隶增加的金币</td>
					</s:if>
					<s:if test="#gold.operateType==5">
						<td>奴隶增加的金币</td>
					</s:if>
					<s:if test="#gold.operateType==6">
						<td>完成资料增加的金币</td>
					</s:if>
					<s:if test="#gold.operateType==7">
						<td>升级增加的金币</td>
					</s:if>
					<s:if test="#gold.operateType==9">
						<td>审批不通过返还金币</td>
					</s:if>
					
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
