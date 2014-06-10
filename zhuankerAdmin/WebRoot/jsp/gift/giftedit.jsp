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
    
    <title>My JSP 'edituserclient.jsp' starting page</title>
    
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
       <form action="gift/giftEdit!save.shtml" method="post" enctype="multipart/form-data">
          <input type="hidden" name="gift.id" value="<s:property value="gift.id"/>"/>
          <input type="hidden" name="gift.giftUrl" value="<s:property value="gift.giftUrl"/>"/>
           <input type="hidden" name="gift.isRemove" value="<s:property value="gift.isRemove"/>"/>
          <table>
             <tr>
                 <td>
                                                                   类型:<select name="gift.giftType">
                           <option value="0">充值卡</option>
                           <option value="1">现金</option>
                           <option value="2">Q币</option>
                      </select>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                名称:<input type="text" name="gift.giftName" value="<s:property value="gift.giftName"/>"/>
                  <font color="red"><s:fielderror fieldName="exist.editerror"/></font>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                   价值(人民币):<input type="text" name="gift.giftPrice" value="<s:property value="gift.giftPrice"/>"/>
                 </td>
              </tr>
               <tr>
                 <td>
                                                                   所需金币:<input type="text" name="gift.giftGold" value="<s:property value="gift.giftGold"/>"/>
                 </td>
              </tr>
               <tr>
                 <td>
                                                                   图片:<input type="file" name="icon"/>
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
