<%@ page language="java" pageEncoding="utf-8"%>

<!--引入静态资源一般用这个，动态资源一般用jsp:include  -->
<%@include file="../common/libs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>查询列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
   
   	<form action=<c:url value="/frame/sys/roleList.do"/> method="post">
	<div >
        <div >
        	角色名： <input  name="roleName" type="text" >
            <input  type="submit" value="查询">
            <div ></div>
        </div>
        
        <div>
        	<input  type="button" value="新增" onclick="location='<c:url value="/frame/sys/initRoleAdd.do"/>'">
        	<input  type="button" value="删除" onclick="batchDelete('checkedown')">
        </div>

        <div >
          <table cellpadding="1" cellspacing="1" border="1">
              <tr>
              	<th>序号</th>
                <th>id</th>
                <th>角色名</th>
                <th>创建时间</th>
              </tr>
              	<c:forEach items="${pageBean.list}" var="role" varStatus="status">
					<tr>
					    <td>${status.count}</td>
					    <td>${role.roleId}</td>
						<td>${role.roleName}</td>
						<td><fmt:formatDate value="${role.createDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
					</tr>
				</c:forEach>
          </table>
        </div>
        <div class="pageArea">
	          <frame:page total="${pageBean.rowCount}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></frame:page>     
	          <div ></div>

       	</div>
      </div>
   </form>
   
  </body>
</html>
