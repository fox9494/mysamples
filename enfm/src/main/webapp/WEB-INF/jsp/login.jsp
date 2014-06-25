<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@include file="common/libs.jsp" %>


<!DOCTYPE html><!--使用html5文档  -->
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="common/scripts.jsp" %>	
	
	<script type="text/javascript">
		
		$(document).ready(function(){
  			getvalue();
		});
		
		function getvalue() 
		{ 
			var pare=window.opener; 
			if(pare!=null) 
			{ 
				var what=pare.document.getElementById("tt"); 
				if(what!=null) 
				{ 
				 alert(what.value); 
				} 
			} 
		} 
	</script>
  </head>
  
  <body>
    
    <div class="container">
        
        
        <div class="row" style="padding-top: 80px">
        <form class="form-horizontal" action="login.do">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">用户名</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="userName" placeholder="用户名" name="userName">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="password" placeholder="密码" name="password">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox"> 记住我
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">登录</button>
		      <button type="reset" class="btn btn-default">重置</button>
		    </div>
		  </div>
		</form>
        
        </div>
    	
    </div>
    
    
    
  </body>
</html>
