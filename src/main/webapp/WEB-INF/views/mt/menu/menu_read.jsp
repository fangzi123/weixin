<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
</head>
<body>
	<jsp:include page="../../common/header.jsp" />
	<script type="text/javascript" src="<%=contextPath%>/mvcjs/mt/menu/menu_read.js"></script>
	<div class="container" style="width: 90%">
		<fieldset>
			<div id="legend">
				<legend>菜单管理</legend>
			</div>
			<form id="exForm" class="form-search" method="post" action="menu_read.html">
				<input type="hidden" name="opt" value="s3001" /> 
				<input type="hidden" name="subBtn" />
				<input type="button" id="addSubmit" class="btn" value="新增" /> 
				<input type="button" id="editSubmit" class="btn" value="编辑" />
				<input type="button" id="delSubmit" class="btn" value="删除" />
				<table id="example">
					<thead>
						<tr>
							<th>菜单ID</th>
							<th>菜单名称</th>
							<th>菜单层级</th>
							<th>菜单链接</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="setMenu" items="${pageList.list}">
							<tr>
								<td><c:out value="${setMenu.menuId}"/></td>
								<td><c:out value="${setMenu.menuName}"/></td>
								<td><c:out value="${setMenu.lv}"/></td>
								<td><c:out value="${setMenu.url}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 配合分页参数使用 -->
				<div id="exPageData">
					<input type="hidden" value="${pageList.fullListSize}" /> <input
						name="pageSize" type="hidden" value="${pageList.objectsPerPage}" /> <input name="page"
						type="hidden"
						value='<c:choose><c:when test="${pageList.pageNumber > 0}">${pageList.pageNumber}</c:when><c:otherwise>1</c:otherwise></c:choose>' />
				</div>
				<!-- 配合搜索栏使用 -->
				<div id="exSearchData">
					<input name="search_key" type="hidden" value='${_search_key}' /> <input
						name="search_value" type="hidden" value='${_search_value}' />
				</div>
			</form>
		</fieldset>
	</div>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
