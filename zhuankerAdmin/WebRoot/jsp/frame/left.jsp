<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.soarsky.octopus.manager.action.MenuAction" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//构造平台导航菜单对象
MenuAction navagate = new MenuAction();
//-------------------------------------------
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/left.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/Styles.css"/>
	<script src="<%=path %>/js/jquery-1.8.3.js" type="text/javascript"></script>
	<script src="<%=path %>/js/jquery-ui-1.9.2.custom.js"></script>
    <script src="<%=path %>/js/JQuery.MenuTree.js" type="text/javascript"></script>
  </head>
  
  <body>
  <div id="menu" class="menuTree">
    <%=navagate.getMenus(path) %>
  </div>
   <!--  
      <div id="menu" class="menuTree">
        <ul>
            <li class="parent"><a href="javascript:;"><img src="../../images/icon_3_1_03.png"/>用户管理</a>
                <ul>
                    <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/userclient/userclientList!searchList.shtml','一级渠道')"><img src="../../images/icon_3_1_11.png"/>注册用户管理</a></li>
                    <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/suggection/suggectionList!searchList.shtml','用户反馈')"><img src="../../images/icon_3_1_11.png"/>用户反馈</a></li>
                </ul>
            </li>
            <li class="parent"><a href="javascript:;"><img src="../../images/icon_3_1_05.png"/>渠道管理</a>
                <ul>
                    <li class="parent"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/firstChanel/firstchannelList!searchList.shtml','一级渠道管理')"><img src="../../images/icon_3_1_11.png"/>一级渠道管理</a></li>
                    <li class="parent"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/channel/channelManager!initChannelManager.shtml','子渠道管理')"><img src="../../images/icon_3_1_11.png"/>子渠道管理</a></li>
                </ul>
            </li>
            <li class="parent"><a target="mainFrame" href="javascript:;" ><img src="../../images/icon_3_1_06.png"/>任务管理</a>
            	 <ul>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/company/companyList!getUserList.shtml','客户管理')"><img src="../../images/icon_3_1_11.png"/>客户管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskList!searchList.shtml','任务管理')"><img src="../../images/icon_3_1_11.png"/>任务管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskApprove!searchList.shtml','任务审核')"><img src="../../images/icon_3_1_11.png"/>任务审核</a></li>
                 </ul>
            </li>
            <li class="parent"><a target="mainFrame" href="javascript:;" ><img src="../../images/icon_3_1_07.png"/>统计管理</a>
            	 <ul>
            	 	 <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/reports/downloadLogList!searchList.shtml','下载量统计')"><img src="../../images/icon_3_1_11.png"/>下载量统计</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskList!searchList.shtml','安装量统计')"><img src="../../images/icon_3_1_11.png"/>安装量统计</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskApprove!searchList.shtml','使用量统计')"><img src="../../images/icon_3_1_11.png"/>使用量统计</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskApprove!searchList.shtml','非系统安装应用')"><img src="../../images/icon_3_1_11.png"/>非系统安装应用</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskApprove!searchList.shtml','赚客网用户统计')"><img src="../../images/icon_3_1_11.png"/>赚客网用户统计</a></li>
                 </ul>
            </li>
            <li class="parent"><a target="mainFrame" href="javascript:;" ><img src="../../images/icon_3_1_09.png"/>结算管理</a>
            	 <ul>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/payment/paymentList!searchList.shtml','用户结算')"><img src="../../images/icon_3_1_11.png"/>用户结算</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/payment/demandPaymentList.shtml','客户结算')"><img src="../../images/icon_3_1_11.png"/>客户结算</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/task/taskApprove!searchList.shtml','渠道结算')"><img src="../../images/icon_3_1_11.png"/>渠道结算</a></li>
                 </ul>
            </li>
            <li class="parent"><a target="mainFrame" href="javascript:;" ><img src="../../images/icon_3_1_08.png"/>基础数据</a>
            	 <ul>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/userlevel/userLevelList!searchList.shtml','赚客级别')"><img src="../../images/icon_3_1_11.png"/>赚客级别</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/jsp/clientuser/arealist.jsp','区域管理')"><img src="../../images/icon_3_1_11.png"/>区域管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/channelindustry/channelIndustryList!getChannelIndustryList.shtml','行业管理')"><img src="../../images/icon_3_1_11.png"/>行业管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/hobbies/hobbiesList!searchList.shtml','爱好管理')"><img src="../../images/icon_3_1_11.png"/>爱好管理</a></li>
                 </ul>
            </li>
             <li class="parent"><a target="mainFrame" href="javascript:;" ><img src="../../images/icon_3_1_10.png"/>系统管理</a>
            	 <ul>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/admin/adminList.shtml','用户管理')"><img src="../../images/icon_3_1_11.png"/>用户管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/admin/roleList.shtml','角色管理')"><img src="../../images/icon_3_1_11.png"/>角色管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/jsp/manager/modelInfo.jsp','模块管理')"><img src="../../images/icon_3_1_11.png"/>模块管理</a></li>
                     <li class="child"><a target="mainFrame" href="javascript:;" onclick="opentab('<%=path %>/mversion/versionlist!versionList.shtml','版本管理')"><img src="../../images/icon_3_1_11.png"/>版本管理</a></li>
                 </ul>
            </li>
        </ul>
    </div>-->
    <script>
       $(function() {
            $('#menu').menuTree({
           		 expandSpeed: 300,
                 collapseSpeed: 50
            });
        });
	    function opentab(url,title){
	    	window.top.frames['mainFrame_tab'].addtab(url,title);
	    	window.parent.document.getElementById("frame_main").rows="100%,*" ;
	    }
	    function open_notab(url){
	    	window.top.frames['mainFrame'].location=url;
	    	window.parent.document.getElementById("frame_main").rows="*,100%" ;
	    }
	    $(".parent li a").click(function(){
	    	$("#menu a").each(function(i,val){
	    		$(this).removeClass("selected");
	    	});
			$(this).addClass("selected");
		});
    </script>
    
  </body>
</html>
