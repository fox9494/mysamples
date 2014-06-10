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
    
    <title>渠道管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jstree/themes/classic/style.css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.hotkeys.js"></script>


	<script type="text/javascript">
		$(function () { 
	     $("#channel_manager").jstree({   
	         "themes": {theme: 'classic'},
	         "json_data" : {   
	             "ajax" : {  
	                 "url" : "channel/getChannelList!getChannelList.shtml",  
	                 "data" : function (NODE) {   
	                     return { name : NODE.attr ? NODE.attr("id") : 0 };   
	                 }  
	             }, 
	         },
	       });
         });
	     function addChannel(){
	     }
	     function deleteChannel(){
	     }
	     function modifyChannel(){
	     }
	     function pushToUser(){
	     }
	</script>
  </head>
  <body>
        <div class="top">
            <table>
                <tr>
                   <td>
                      <input type="button" value="<s:text name="com.soarsky.octopus.channel.addchannel" />" onclick="addChannel()"></input>
                   </td>
                   <td>
                      <input type="button" value="<s:text name="com.soarsky.octopus.channel.modifychannel" />" onclick="modifyChannel()"></input>
                   </td>
                   <td>
                      <input type="button" value="<s:text name="com.soarsky.octopus.channel.deletechannel" />" onclick="deleteChannel()"></input>
                   </td>
                   <td>
                       <input type="button" value="<s:text name="com.soarsky.octopus.channel.pushtouser" />" onclick="pushToUser()"></input>
                   </td>
                </tr>
            </table>
	    </div>
       	<div id="left">
       	    <div  class="demo" id="channel_manager"></div>
		</div>
	    <div class="right">
			<div class="content">
				<ul>
					<li><a href="#tabs-1" id="welcome">欢迎</a><a class="close" href="#">x</a></li>
				</ul>
				<div id="tabs-1">这是欢迎页面</div>
		    </div>
		</div>
  </body>
  </body>
</html>
