<%@ page language="java" pageEncoding="utf-8"%>

<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'test.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    
    
    <form method="post" name="pageInfo" action="demo.action">
    test:<s:property value="test"/><br>
    <br>
    <table width="100%">
    <tr>
    	<td>用户ID</td>
	    <td>账号</td>
	    <td>密码</td>
	</tr>
 	<s:iterator value="pageBean.list" id="user" status="sta">
 	  <tr>
	    <td><s:property value="#user.userId"/></td>
	    <td><s:property value="#user.userAccount"/></td>
	    <td><s:property value="#user.userPassword"/></td>
	  </tr>
    </s:iterator>
    </table>
    <div style=""><my:page total="${pageBean.totalPage}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page></div>
    </form>
  </body>
</html>
