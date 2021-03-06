<%@ page  pageEncoding="UTF-8" language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="common/libs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>成勘院会议主页</title>
<%@include file="common/scripts.jsp" %>

<script type="text/javascript">
$(function(){
	DWZ.init("<c:url value='/resource/dwz/dwz.frag.xml'/>", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"<c:url value='/resource/dwz/themes'/>"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="<c:url value='/'/>" target="website">Home</a></li>
					<li><a href="<c:url value='/passport/logout'/>">Log out</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">blue</div></li>
					<li theme="green"><div>green</div></li>
					<li theme="purple"><div>purple</div></li>
					<li theme="silver"><div>silver</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>导航菜单</h2><div>collapse</div></div>
			
				<div class="accordion" fillSpace="sideBar">
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/management/website/edit'/>" target="navTab" rel="websiteNav">网站装修</a></li>
							<li><a href="<c:url value='/management/webpage/list'/>" target="navTab" rel="pageLiNav">页面管理</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/management/user'/>" target="navTab" rel="userLiNav">用户管理</a></li>
							<li><a href="<c:url value='/sys/role/roleList.do'/>" target="navTab" rel="sysRoleLiNav">角色管理</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>其它</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/management/news'/>" target="navTab" rel="newsLiNav">资讯管理</a></li>
						</ul>
					</div>
					
				</div>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">My Home</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<c:set var="contextUser" value="系统管理员"></c:set>
							<div class="right">
								<p>2014-01-01</p>
							</div>
							<p><span>Welcome, 陈利乐</span></p>
							<p>cll219@qq.com</p>
						</div>
						
						<div class="pageFormContent" layoutH="80">
							<p>
								<label>用户名:</label><span class="unit">fic</span>
							</p>
							<p>
								<label>姓名:</label><span class="unit">陈利乐</span>
							</p>

							<p>
								<label>电话:</label><span class="unit">12121212121</span>
							</p>
							<p>
								<label>Email:</label><span class="unit">cll@qq.com</span>
							</p>
							
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
	
	<div id="footer">成勘院版权所有</div>


</body>
</html>