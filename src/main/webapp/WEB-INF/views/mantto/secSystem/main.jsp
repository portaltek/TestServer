<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- <c:set var="css" value="${ctx}/resources/css/default" /> --%>
<c:set var="js" value="${ctx}/resources/js" />
<%-- <c:set var="img" value="${ctx}/resources/img" /> --%>
<c:set var="lib" value="${ctx}/resources/lib" />

<tiles:insertDefinition name="home">
	<tiles:putAttribute name="home.body">
		<head>
<script src="${js}/sec/secSystem/secSystem.js"></script>
<link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" />
<script src="${lib}/tablesaw/tablesaw.js"></script>
<script src="${lib}/tablesaw/tablesaw-init.js"></script>
<script src="${js}/lib/tablePagination.js"></script>




<script>
	
</script>
		</head>
		<body>

			<!-- 			<h3> -->
			<!-- 				New -->
			<%-- 				<spring:message code="object" /> --%>
			<!-- 				<a href="#secSystemForm-dialog" data-rel="popup" -->
			<!-- 					data-position-to="window" data-transition="fade" -->
			<!-- 					class="ui-btn ui-corner-all ui-shadow ui-btn-inline">+</a> -->
			<!-- 			</h3> -->
			<label for="file" class="text-center">CRUD: SEC_SYSTEM </label>
			<div>
				<a href="#secSystemForm-dialog" data-rel="popup"
					data-position-to="window" data-transition="fade"
					class="ui-btn ui-shadow ui-corner-all ui-icon-plus ui-btn-icon-notext insert"
					data-inline="true"> </a> <a href="#searchForm" data-rel="popup"
					data-position-to="window" data-transition="fade"
					class="ui-btn ui-shadow ui-corner-all ui-icon-search ui-btn-icon-notext search"
					data-inline="true"> </a>
			</div>
			<div></div>

			<div id="searchForm" data-role="popup" data-transition="fade">
				<div data-role="header">
					<a href="#"
						class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-left"
						data-rel="back">Close</a>
					<h1 class="ui-title" role="heading" aria-level="1">Dialog</h1>
				</div>
				<div role="main" class="ui-content">
					<label for="file" class="text-left ">SystemId:</label> <input
						type="text" id="secSystemTable-search-systemId"
						class="search-left" />
				</div>
			</div>
			<!-- 			 -->

			<div class="tablesaw-bar mode-toggle table">

				<!-- data-tablesaw-minimap data-tablesaw-mode-switch  data-mode="columntoggle"
		columntoggle
		swipe, stack
		-->
				<div id="secSystemTable-pager" class="pager"></div>
				<table id="secSystemTable" class="tablesaw paginated"
					data-tablesaw-mode="swipe" data-input="#filterTable-input"
					data-tablesaw-sortable="true">
					<thead>
						<tr>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-sortable-default-col
								data-tablesaw-priority="persist">system_Id</th>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-priority="2">name</th>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-priority="3">description</th>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-priority="1"></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
			<div id="secSystemForm-dialog" data-role="popup"
				data-transition="fade">
				<div data-role="header">
					<a href="#"
						class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-left"
						data-rel="back">Close</a>
					<h1 class="ui-title" role="heading" aria-level="1">Dialog</h1>
				</div>
				<div role="main" class="ui-content">
					<form:form id="secSystemForm" modelAttribute="secSystem">

						<table>
							<tr>
								<td><form:label path="systemId">ID:</form:label></td>
								<td><form:input path="systemId" /></td>
							</tr>
							<tr>
								<td><form:label path="name">Name:</form:label></td>
								<td><form:input path="name" /></td>
							</tr>

							<tr>
								<td><form:label path="description">Description:</form:label></td>
								<td><form:input path="description" /></td>
							</tr>
							<tr>
								<td><a href="#"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline"
									data-rel="back">CANCEL</a></td>
								<td><input type="button" value="SAVE" onclick="insert()" /></td>
							</tr>
						</table>

					</form:form>
				</div>
			</div>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>
