<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'clientuserlist.jsp' starting page</title>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
    <script type="text/javascript">
        function confirmCompany(companyid){
          
          window.location="<%=path%>/companyorder/companyorderEdit!confirmCompany.shtml?company.id="+companyid+"&order.id="+$("#orderid").val();
        }
    </script>
  </head>
      
  <body>
      <div class="main">
	      <div class="btarea line">
		  </div>
       <form action="companyorder/companyorderAdd!getCompanyByConditions.shtml" method="post">
          <input type="hidden" name="order.id" id="orderid" value="<s:property value="order.id"/>"/>
                <div class="search">
                     <ul>
                        <li>
						   <p>客户名称:</p><input type="text" name="company.name" value="<s:property value="company.name"/>"/>
						</li>
						<li>
						   <p>所属行业:</p><select name="channelindustry.name">
						                           <option value=""><-- 请选择行业   --></option>
						                           <s:iterator value="channelIndustrys" id="channelIndustry">
						                             <option value="<s:property value="#channelIndustry.name"/>" <s:if test="#channelIndustry.name==channelindustry.name">selected="selected"</s:if>><s:property value="#channelIndustry.name"/></option>
						                           </s:iterator>			                                     </select>

			             </li>
			             <li>
				                         <input type="submit" class="button" value="查询"/> 
				         </li>
		             </ul>
				  </div>
				  
				  <div class="list">
		          <table cellspacing="0" border="0">
		            <tr class="head">
							<td>客户名称</td>
							<td>所属行业</td>
							<td>所在城市</td>
							<td>联系人</td>
							<td>联系电话</td>
							<td>邮箱</td>
							<td>操作</td>
					 </tr>				           
			             <s:iterator value="pageBean.list" id="tCompany">
				             <tr>
				                   <td class="taline tahei"><s:property value="#tCompany.name"/></td>
				                   <td class="taline tahei"><s:property value="#tCompany.channelIndustry.name"/></td>
				                   <td class="taline tahei"><s:property value="#tCompany.area.statename"/></td>
				                   <td class="taline tahei"><s:property value="#tCompany.contactName"/></td>
				                   <td class="taline tahei"><s:property value="#tCompany.phone"/></td>
				                   <td class="taline tahei"><s:property value="#tCompany.email"/></td>
				                   <td class="taline tahei"><a href="#" onclick="confirmCompany(<s:property value="#tCompany.id"/>)">确认</a></td>
				             </tr>
			             </s:iterator>		            
		          </table>
                  <div class="">
						<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
				  </div>
                  </div>
       </form>
       </div>
  </body>
</html>
