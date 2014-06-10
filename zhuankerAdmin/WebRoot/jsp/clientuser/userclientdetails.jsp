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
    
    <title>用户详情</title>
    
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
	//金币日志
	function goldChange(){
				var id = getUserId();				
				window.location="<%=path %>/details/goldChangeList!searchList.shtml?userId="+id;
	}
	//兑换记录
	function exchageLog(){
				var userId = getUserId();
				window.location="<%=path %>/details/exchangeLoglist!searchList.shtml?userId="+userId;
	}
	//用户任务详细列表
	function userTask(){
			var userId = getUserId();
			window.location="<%=path %>/details/userTaskList!searchList.shtml?userId="+userId;
		}
	//流量统计
	function systemFlow(){
			var userId = getUserId();
			window.location="<%=path %>/reports/systemFlowByUserId!findAllSystemFlowByUserId.shtml?userId="+userId;
	}
	//下载量统计
	function downloadReport(){
			var userId = getUserId();
			window.location="<%=path %>/reports/downloadReportByUserId!findDownloadReportById.shtml?userId="+userId;
		}
	//非系统安装应用
	function installedApk(){
			var userId = getUserId();
			window.location="<%=path %>/reports/findInsatllApkByUserId!findInstalledReportByUserId.shtml?userId="+userId;
		}
	//安装量
	function installedReport(){
			var userId = getUserId();
			window.location="<%=path%>/reports/findInstallReport!findInstallReport.shtml?userId="+userId;
	}
	//返回
	function back(){			
			window.location="<%=path %>/userclient/userclientList!searchList.shtml";
		}
	//得到用户id
	function getUserId(){
			var id = document.getElementById("id").value;
		return  id;
	}
	</script>
<style type="text/css">
 #table {   
    padding: 0;
    margin: 0;   
    border-collapse:collapse;
}
td {
    border: 1px solid #C1DAD7;   
    background: #fff;
    font-size:11px;
    padding: 6px 6px 6px 12px;
    color: #4f6b72;
}
td.alt {
    background: #F5FAFA;
    color: #797268;
}

</style>
  </head>
  
  <body>
  <div class="main">
      <div class="btarea line" >
           <a href="javascript:;" class="graybtn"  onclick="goldChange()">金币日志</a>
           <a href="javascript:;" class="graybtn"  onclick="exchageLog()">兑换记录</a>
           <a href="javascript:;" class="graybtn"  onclick="userTask()">任务明细</a>
           <a href="javascript:;" class="graybtn"  onclick="downloadReport()">下载量</a>
           <a href="javascript:;" class="graybtn"  onclick="installedReport()">安装量</a>
           <a href="javascript:;" class="graybtn"  onclick="systemFlow()">流量的统计</a>
           <a href="javascript:;" class="graybtn"  onclick="installedApk()">非系统安装应用</a>
           <a href="javascript:;" class="graybtn"  onclick="back()">返回</a>
      </div>
      <hr/>          
      <form action="">
      <input type="hidden" value="<s:property value='userclient.id'/>"  id="id"/> 
      <div  align="center"> 
      <strong>用户注册信息</strong> 
         <table id="table" width="600px">
            <tr>
              <td  class="alt" align="left" width="250px">账号：<input type="text" value="<s:property value='userclient.userName'/>" readonly="readonly"/></td>
              <td  class="alt" align="left" width="250px">昵称：<input type="text" value="<s:property value='userclient.nickName'/>" readonly="readonly"/></td>
            </tr>
            <tr>
	          <td  class="alt" align="left">性别：<input type="text" <s:if test="userclient.sex==1">value="男"</s:if><s:elseif test="userclient.sex==0">value="女"</s:elseif> readonly="readonly"/></td>
	         <td  class="alt" align="left">城市：<input type="text" value="<s:property value='city.statename'/>" readonly="readonly"/></td>
            </tr>
            <tr>
              <td  class="alt" align="left">职业：<input type="text" value="<s:property value='profession.name'/>" readonly="readonly"/></td>
              <td  class="alt" align="left">邮箱：<input type="text" value="<s:property value='userclient.email'/>" readonly="readonly"/></td>
            </tr>
            <tr>
              <td  class="alt" align="left">星座：<input type="text" value="<s:property value='constellationStr'/>" readonly="readonly"/></td>
              <td  class="alt" align="left">生肖：<input type="text" value="<s:property value='shengXiaoStr'/>" readonly="readonly"/></td>
            </tr>
            <tr>
              <td  class="alt" align="left">省份：<input type="text" value="<s:property value='province.statename'/>" readonly="readonly"/></td>
              <td  class="alt" align="left">手机号码：<input type="text" value="<s:property value='userclient.phone'/>" readonly="readonly"/></td>              
            </tr>
            <tr>                            
              <td  class="alt" align="left">渠道CODE：<input type="text" value="<s:property value='userclient.channel.levelCode'/>" readonly="readonly"/></td>
               <td  class="alt" align="left">出生年月：<input type="text" value="<s:date name='userclient.birthday' format="yyyy-MM-dd"/>" readonly="readonly"/></td>              
            </tr>
             <tr>
	       		<td  class="alt" align="right"> 爱好：
	           </td>
	           <td class="alt" align="left">
	           	  <s:iterator value="#request.hobbiesList" id="hl">             
	            	<input type="checkbox" checked="checked" disabled="disabled"><s:property value="#hl.THobbies.tagname"/></input>
	             </s:iterator>
	           </td>
            </tr>
         </table>
      </div>   
      </form>
      <hr/>
           
      <form action="">
      <div align="center">
      <strong>统计信息</strong> 
         <table id="table">
            <tr>        
              <td class="alt" align="right">当前赚客级别：<input type="text" value="<s:property value='level'/>" readonly="readonly"/></td>
              <td class="alt" align="right">当前排名：<input type="text" value="<s:property value='ranking'/>" readonly="readonly"/></td>
            </tr>
            <tr>
              <td class="alt" align="right">当前金币数：<input type="text" value="<s:property value='userGoldCount.currentGold'/>" readonly="readonly"/></td>
              <td class="alt" align="right">任务所得金币：<input type="text" value="<s:property value='userGoldCount.taskGold'/>" readonly="readonly"/></td>
            </tr>
            <tr>
              <td class="alt" align="right">奴隶数贡献金币数：<input type="text" value="<s:property value='userGoldCount.fansGold'/>" readonly="readonly"/></td>
              <td class="alt" align="right">游戏所得金币数：<input type="text" value="<s:property value='userGoldCount.gameGold'/>" readonly="readonly"/></td>
            </tr>
            <tr>
            	<td class="alt" align="right">奴隶数:<input value="<s:property value='childrenCount'/>" readonly="readonly"/></td>
            	<td class="alt" align="right">完成任务数:<input value="<s:property value='userclient.finishedTaskNum'/>" readonly="readonly"/> </td>
            </tr>
         </table>
        </div>
      </form>
    </div>
   </body>
</html>
 