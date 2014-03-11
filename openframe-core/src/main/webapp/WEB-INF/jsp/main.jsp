<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="common/libs.jsp" %>

<!DOCTYPE HTML >
<html><!-- doctype和html都不写，即使html5 -->
  <head>
    
    <title>主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="common/scripts.jsp" %>
	
	<script type="text/javascript">
		
		$(document).ready(function(){
  			
		});
		
	</script>
  </head>
  
  <body>
      <div class="container">
    	<div class="row" id="head"><h3>演示</h3></div>
    	
    	<div class="row">
    		<div id="menu" class="pull-left col-sm-2">
    			<ul>
    				<li><a  href="#">系统管理</a>
    					<ul>
						  <li><a target="mainFrame" href="frame/sys/roleList.do">角色管理</a></li>	    					
						  <li><a target="mainFrame" href="frame/sys/userList.do">用户列表</a></li>
    					
    					
    					</ul>
    				</li>
    				<li><a target="mainFrame" href="">文件上传</a></li>
    			
    			
    			</ul>
    		
    		</div>
    		
    	
    		<div class="pull-right col-sm-10" id="content" >
    			<iframe id="mainFrame"  width="100%" height="900px" scrolling="yes" frameborder="0" ></iframe>
    		</div>
    	</div>
    
    </div>
    
  </body>
</html>
