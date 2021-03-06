<%@ page  pageEncoding="UTF-8" language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../common/libs.jsp"%>


<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageBean.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<form method="post" rel="pagerForm" action="<c:url value='/sys/role/roleList.do'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>角色名称：</label>
				<input type="text" name="name" value="${param.name}"/>
			</li>
			
		</ul>
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left">Matching Records Found: <strong>${pageBean.totalCount}</strong></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">Search</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="newsNav" href="<c:url value='/management/news/add'/>" title="Add News"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/management/news/edit/{slt_newsId}'/>" title="Edit News"><span>修改</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/news/delete/{slt_newsId}'/>" title="Are you sure remove?"><span>删除</span></a></li>
			<li class="line">line</li>
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
	

	<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
	<div class="panelBar">
		<div class="pages">
			<span>Per Page</span>
			<select name="pageSize" onchange="navTabPageBreak({numPerPage:this.value})">
				<c:forEach begin="10" end="40" step="10" varStatus="s">
					<option value="${s.index}" ${pageBean.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select>
	
			<span>Total: ${pageBean.totalCount}</span>
		</div>
		
		<div class="pagination" targetType="${targetType}" totalCount="${pageBean.totalCount}" numPerPage="${pageBean.pageSize}" pageNumShown="10" currentPage="${pageBean.pageNum}"></div>
	</div>
</div>