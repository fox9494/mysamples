<%@ page language="java"  pageEncoding="utf-8"%>

<!--引入静态资源一般用这个，动态资源一般用jsp:include  -->
<%@include file="../common/libs.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>添加角色</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    
	<script type="text/javascript" src="<%=basePath %>resource/jquery/jquery-1.9.1.min.js"></script>
	
	<!-- ajax提交form -->
	<script type="text/javascript" src="<%=basePath %>resource/js/jquery.form.min.js"></script>
	<script> 
        $(document).ready(function() { 
          
          
        }); 
    </script> 

  </head>
  
  <body>
      <form:form action="/frame/sys/roleAdd.do" method="post" commandName="role">
                                             角色:<input name="roleName"  type="text" value="${role.roleName}"><form:errors path="roleName" />
                   
                  <div>
        		   <input type="submit" value="提交"/>
        		  </div>
      
      </form:form>
  </body>
</html>
