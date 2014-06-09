<%@ page language="java"  pageEncoding="utf-8"%>

<%
final String path = request.getContextPath();
request.setAttribute("_path",path);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>国信证券软件管家管理 </title>
	<link rel="stylesheet" href="resources/css/ext-all.css" type="text/css" media="screen" charset="utf-8" />
	<link rel="stylesheet" href="styles/html.css" type="text/css" media="screen" charset="utf-8" />
	<link rel="shortcut icon" href="images/ico.png" type="image/x-icon"/>
	<link rel="stylesheet" href="styles/index.css" />

	<!--[if IE]> <link href="styles/ieindex.css" rel="stylesheet" type="text/css" /> <![endif]-->
	
	<script src="scripts/Ext/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script src="scripts/Ext/jquery-plugins.js" type="text/javascript" charset="utf-8"></script>
	<script src="scripts/Ext/ext-jquery-adapter.js" type="text/javascript" charset="utf-8"></script>
	<script src="scripts/Ext/ext-all.js" type="text/javascript" charset="utf-8"></script>
	<script src="scripts/Wathon.Admin.js"></script>
	<script type="text/javascript" src="scripts/Wathon.Admin.Index.js"></script>
  
	
	<script type="text/javascript">
	    
		var items;
		var name = '<%=session.getAttribute("username")%>';
		$(document).ready(function(){
			$.getJSON("${_path}/menuAction!getMenus.action",{t:new Date()},function(json){//参数中加了时间戳，防止IE缓存
			    items = json;
			    
	            Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

				var index = Wathon.Admin.Index;
				if (items == null) {
					alert("加载菜单出错");
				} else {
					index.addmenus(items);
				}
			
				index.init();
			    
	       });
		
		});
		/*
		var items;
		
		var name = '<%=session.getAttribute("username")%>';
		var item = {
					title : '后台管理',
					width : '100',
					items : [{title:'后台管理员',href:'adminuserList!searchListPage.action'},
							{title:'权限分配',href:'adminRoleList!searchAllRole.action'}
						    ]
				};
	 	var items = [ {
					title : '<img src="../images/min-icon.png">&nbsp;类别管理',
					width : '200',
					items : [{title:'类别管理',href:'typeList!searchListPage.action'}
							 ]
				},{
					title : '应用管理',
					width : '200',
					items : [{title:'应用管理',href:'../jsp/frame.jsp'}
							]
				},{
					title : '角色管理',
					width : '100',
					items : [{title:'角色管理',href:'roleList!searchListPage.action'},
							 {title:'角色应用',href:'roleAppList!searchListPage.action'}]
				},{
					title : '客户管理',
					width : '200',
					items : [{title:'客户管理',href:'customerList!searchListPage.action'}
							 ]
				},{
					title : '版本管理',
					width : '200',
					items : [{title:'查看版本',href:'searchLocalVerList!searchVersion.action'},
							 {title:'上传版本',href:'updateLocalVersion!initUpdateVersion.action'}]
				}];
				if("admin" == name){
					items.push(item);
				}
	*/
		
    </script>
</head>
<body>
	<s:if test="%{#session.username == null}">
		<%response.sendRedirect("../login/welcome.jsp"); %>
	</s:if>
	
	
	<div id="loading-mask" style=""></div>
	<div id="loading">
	    <div class="loading-indicator"><img src="images/Ext/extanim64.gif" width="64" height="64" style="margin-right:8px;" />系统加载中，请稍候...</div>
	</div>
	<div id="panelTop">
		<div class="header"><h1>国信证券软件管家-后台管理<samp>版本:1.0</samp>
		<span class="aa" id="gai">欢迎您：&nbsp;<%=session.getAttribute("username") %>！ 
		<a href="userLogin!exit.action" style="color: white;">退出系统</a></span>	</h1>
		</div>
		<div id="panelToolbar" style="height:28px;">
		</div>
	</div>

	<div id="panelContent">
		
	</div>
	<div id="panelBottom"></div>
</body>
</html>