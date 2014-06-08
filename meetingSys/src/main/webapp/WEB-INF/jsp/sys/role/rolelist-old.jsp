<%@ page  pageEncoding="UTF-8" language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../common/libs.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageBean.pageSize}" />
	<input type="hidden" name="orderField" value="${pageBean.orderField}" />
	<input type="hidden" name="orderDirection" value="${pageBean.orderDirection}" />
</form>




<form onsubmit="return navTabSearch(this);" action="<c:url value='/sys/role/roleList.do'/>" method="post" rel="pagerForm">
  <div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>我的客户：</label>
				<input type="text" name="name" value="${role.name}"/>
			</li>
			
		</ul>
		
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
 </div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<c:url value='/sys/role/initAddRole'/>" target="navTab" rel="sysRoleAddNav"><span>添加</span></a></li>
			<li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80"></th>
				<th width="120">角色名称</th>
				<th>创建日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${pageBean.list}" varStatus="s">
				<tr target="slt_objId" rel="${item.roleId }">
					<td>${s.index + 1}</td>
					<td>${item.name}</td>
					<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set var="targetType" value="${empty pageBean.targetType ? 'navTab' : pageBean.targetType}"/>
	<div class="panelBar">
		<div class="pages">
			<span>每页显示</span>
			<select name="pageSize" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value}})">
				<c:forEach begin="10" end="40" step="10" varStatus="s">
					<option value="${s.index}" ${pageBean.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select>
	
			<span>总条数: ${pageBean.totalCount}</span>
		</div>
		
		<div class="pagination" targetType="${targetType}" totalCount="${pageBean.totalCount}" numPerPage="${pageBean.pageSize}" pageNumShown="10" currentPage="${pageBean.pageNum}"></div>
	</div>
</div>
