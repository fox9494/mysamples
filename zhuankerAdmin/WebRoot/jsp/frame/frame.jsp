<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'frame.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  
 	<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui-1.9.2.custom.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/framestyle.css"> 
        
    <script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-ui-1.9.2.custom.js"></script>
    <script type="text/javascript" src="<%=path %>/js/index.js"></script>

	<script type="text/javascript" src="<%=path %>/js/accordion.js"></script>
	<style type="text/css">
		ul{list-style:none}
		.nav {width: 213px; padding: 40px 28px 25px 0; font-family: "Microsoft yahei", Arial, Helvetica, sans-serif;} 
		ul.nav {padding: 0; margin: 0; font-size: 1em; line-height: 0.5em; list-style: none;} 
		ul.nav li {} 
		ul.nav li a {line-height: 10px; font-size: 14px; padding: 10px 5px; color: #000; display: block; text-decoration: none; font-weight: bolder;}
		ul.nav li a:hover {background-color:#675C7C;    color:white;}
		ul.nav ul { margin: 0; padding: 0;display: none;} 
		ul.nav ul li { margin: 0; padding: 0; clear: both;} 
		ul.nav ul li a { padding-left: 20px; font-size: 12px; font-weight: normal;}
		ul.nav ul li a:hover {background-color:#D3C99C; color:#675C7C;} 
		ul.nav ul ul li a {color:silver; padding-left: 40px;} 
		ul.nav ul ul li a:hover { background-color:#D3CEB8; color:#675C7C;} 
		ul.nav span{float:right;}
	</style>
	

  </head>
  
  <body>
   		<div class="top">
			<div class="welcome"><img src="<%=path %>/css/images/icon_user.gif" width="25" height="18" />欢迎:&nbsp;
			  
			</div>
		    <div class="right"><img src="<%=path %>/css/images/icon_time.gif" width="16" height="14" />
		              日期<span id="curDate"></span>&nbsp;&nbsp;&nbsp;<span id="curWeek"></span>&nbsp;&nbsp;&nbsp;
		    <input type="button" value="返回首页" class="btn_home" onclick="window.location=''" /><input type="button" value="帮助" class="btn_help" /><a href="<%=path %>/login/loginOut.shtml" style="color: white;" class="btn_exit">退出</a></div>
	    </div>
	   
       	<div id="left">
		   
		        <ul class="nav">
		        
		         <li class="active"><a href="#">用户管理</a>
		              <ul>
		                  <li><a href="<%=path %>/userclient/userclientList!searchList.shtml" title="注册用户管理"	id="menu1_1">注册用户管理</a></li>
		                  <li><a href="<%=path %>/suggection/suggectionList!searchList.shtml" title="用户反馈" id="menu1_2">用户反馈</a></li>
		              </ul>
		         </li>
		         
		         <li><a href="#" title="渠道管理">渠道管理</a>
		         	   <ul>
		         	   	  <li><a href="<%=path %>/jsp/channel/firstchannelList.jsp" title="一级渠道管理"	id="menu2_1">一级渠道管理</a></li>
		                  <li><a href="<%=path %>/channel/channelManager!initChannelManager.shtml" title="渠道管理"	id="menu2_2">渠道管理</a></li>
		              </ul>
		         </li>
		         
		         <li><a href="#">任务管理</a>
		              <ul>
		                   <li ><a href="<%=path %>/company/companyList!getUserList.shtml" id="menu4_1" title="客户管理">客户管理</a></li>
		                   <li >
		                        <a href="<%=path %>/task/taskList!searchList.shtml" id="menu4_2">任务管理</a>
		                   </li>
		                   <li><a href="<%=path %>/task/taskApprove!searchList.shtml" id="menu4_2_1">任务审核</a></li>
		              </ul>
		         </li>
		         
                 <li><a href="#">统计管理</a>
		              <ul>
		                   <li ><a href="<%=path %>/reports/downloadLogList!searchList.shtml" id="menu5_1">下载量统计</a></li>
		                   <li ><a href="#order-6" id="menu5_2">安装量统计</a></li>
		                   <li ><a href="<%=path %>/reports/systemFlowList!searchList.shtml" id="menu5_3">使用量统计</a></li>
		                   <li ><a href="#order-6" id="menu5_4">非平台安装的应用</a></li>
		                   <li ><a href="#order-6" id="menu5_5">赚客网用户统计</a></li>
		              </ul>
		         </li>
		         
		         <li><a href="#" >游戏管理</a>
		         	<ul>
		                  <li><a href="<%=path %>/index.jsp" title="游戏管理"	id="menu1_1">游戏管理</a></li>
		                  <li><a href="<%=path %>/jsp/login.jsp" title="游戏金币变化" id="menu1_2">游戏金币变化</a></li>
		            </ul>
		         </li>
		        
		         <li><a href="#">结算管理</a>
		              <ul>
		                   <li ><a href="#order-6" id="menu8_1">用户结算</a></li>
		                   <li ><a href="#order-6" id="menu8_2">需求方结算</a></li>
		                   <li ><a href="#order-6" id="menu8_3">渠道结算</a></li>
		              </ul>
		         </li>	 	
		                  
                 <li><a href="#">基础数据管理</a>
		              <ul>
		                   <li><a href="<%=path %>/userlevel/userLevelList!searchList.shtml" title="赚客级别" id="menu2_2">赚客级别</a></li>
		                   <li><a href="<%=path %>/jsp/clientuser/arealist.jsp" title="区域管理" id="menu2_3">区域管理</a></li>
		                   <li><a href="<%=path %>/channelindustry/channelIndustryList!getChannelIndustryList.shtml" title="行业管理" id="menu3_2">行业管理</a></li>
		                   <li><a href="<%=path %>/hobbies/hobbiesList!searchList.shtml" title="爱好管理" id="menu3_3">爱好管理</a></li>
		              </ul>
		         </li>	
		         
		         <li><a href="#">系统管理</a>
		              <ul>
		                   <li ><a href="<%=path %>/admin/adminList.shtml" id="menu8_1" title="后台用户">后台用户</a></li>
		                   <li ><a href="<%=path %>/admin/roleList.shtml" id="menu8_2" title="角色管理">角色管理</a></li>
		                   <li ><a href="<%=path %>/jsp/manager/tmodelinfo.jsp" id="menu8_3" title="模块管理">模块管理</a></li>
		                   <li ><a href="#order-6" id="menu7_4">版本管理</a></li>
		              </ul>
		         </li>
		      </ul>
		</div>
        
	    <div class="right">
			<div class="content">
			   <div id="tabs">
					<ul>
						<li><a href="#tabs-1" id="welcome">欢迎</a><a class="close" href="#">x</a></li>
					</ul>
					<div id="tabs-1">这是欢迎页面</div>
			   </div>
		       
		    </div>
		</div>
   
  </body>
</html>
