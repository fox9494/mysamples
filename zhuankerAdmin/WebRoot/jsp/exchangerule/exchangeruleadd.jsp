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
    
    <title>My JSP 'adduserclient.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
       <form action="exchangerule/exchangeRuleAdd!save.shtml" method="post">
          <table>
             <tr>
                 <td>
                                                                现金兑换最低标准:<input type="text" name="exchangRule.gold" value="<s:property value="exchangRule.gold"/>"/>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                金币兑换比例:<input type="text" name="exchangRule.rate" value="<s:property value="exchangRule.rate"/>"/>
                 </td>
              </tr>
              <tr>
                 <td>
                   <input type="submit" value="提交"/>&nbsp;
                   <input type="button" value="返回"/>
                 </td>
             </tr>
          </table>
       </form>
  </body>
</html>
