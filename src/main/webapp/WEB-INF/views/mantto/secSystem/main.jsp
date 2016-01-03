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
<%-- <script src="${lib}/jqBootstrapValidation/jqBootstrapValidation.js"></script> --%>
<link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" />
<script src="${lib}/tablesaw/tablesaw.js"></script>
<script src="${lib}/notify/notify.min.js"></script>
<script src="${js}/sec/secSystem/secSystem.js"></script>
<script src="${js}/sec/secSystem/secSystemController.js"></script>
<script src="${js}/sec/secSystem/secSystemService.js"></script>
<script src="${js}/lib/tablePagination.js"></script>

<script src="${lib}/tablesaw/tablesaw-init.js"></script>

		</head>
		<body>
			<label class="text-center"> <spring:message
					code="SecSystem.tittle" />
			</label>
			<div>
				<div>
					<a href="#secSystemForm-dialog" data-rel="popup"
						data-position-to="window" data-transition="fade"
						class="ui-btn ui-shadow ui-corner-all ui-icon-plus ui-btn-icon-notext insert"
						data-inline="true" onclick="ctrl.showInsertForm()"> </a>
				</div>
				<div>
					<a href="#searchForm-dialog" data-rel="popup"
						data-position-to="window"
						class="ui-btn ui-shadow ui-corner-all ui-icon-search ui-btn-icon-notext search"
						onclick="ctrl.showSearchForm()"> </a>
				</div>
			</div>

			<!-- ---------------------------------------------------  -->
			<!-- SEARCH FORM  -->
			<!-- ---------------------------------------------------  -->
			<div id="searchForm-dialog" data-role="popup" data-transition="fade">
				<div data-role="header">

					<h1 class="ui-title" role="heading" aria-level="1">
						<spring:message code="SecSystem.form.title.search" />
					</h1>
					<a href="#"
						class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-right"
						data-rel="back">Close</a>
				</div>
				<div role="main" class="ui-content">
					<label for="file" class="text-left "><spring:message
							code="SecSystem.form.label.systemId" /></label> <input type="text"
						id="secSystemTable-search-systemId" class="search-left" />
				</div>
			</div>




			<!-- ---------------------------------------------------  -->
			<!-- MAIN FORM  -->
			<!-- ---------------------------------------------------  -->


			<div id="secSystemForm-dialog" data-role="popup"
				data-transition="fade" class="dialog">
				<div data-role="header">

					<h1 id="form-title-insert" class="ui-title" role="heading">
						<spring:message code="SecSystem.form.title.insert" />
					</h1>
					<h1 id="form-title-update" class="ui-title" role="heading">
						<spring:message code="SecSystem.form.title.update" />
					</h1>
					<h1 id="form-title-delete" class="ui-title" role="heading">
						<spring:message code="SecSystem.form.title.delete" />
					</h1>
					<a href="#"
						class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-right"
						data-rel="back"></a>
				</div>
				<div role="main" class="ui-content">

					<input type=hidden id="SecSystemError-SYSTEM_ID_EMPTY"
						value="<spring:message code="SecSystemError.SYSTEM_ID_EMPTY" />" />
					<input type=hidden id="SecSystemError-SYSTEM_ID_MIN_LENGTH"
						value="<spring:message code="SecSystemError.SYSTEM_ID_MIN_LENGTH" />" />
					<input type=hidden id="SecSystemError-NAME_EMPTY"
						value="<spring:message code="SecSystemError.NAME_EMPTY" />" />
					<input type=hidden id="SecSystemError-NAME_MIN_LENGTH"
						value="<spring:message code="SecSystemError.NAME_MIN_LENGTH" />" />
						
					<form:form id="secSystemForm" modelAttribute="secSystem">

						<div class="ui-grid-solo">
							<div class="ui-block-a grid-form-block">
								<form:label path="systemId" class="label-form">
									<spring:message code="SecSystem.form.label.systemId" />
								</form:label>
								<form:input path="systemId" type="text" aria-invalid="true"
									onblur="ctrl.val.systemId()" />
								<p class="help-block"></p>
							</div>
							<div class="ui-block-a grid-form-block">
								<form:label path="systemId" class="label-form">
									<spring:message code="SecSystem.form.label.name" />
								</form:label>
								<form:input path="name" onblur="ctrl.val.name()" />
							</div>
							<div class="ui-block-a grid-form-block">
								<form:label path="description">
									<spring:message code="SecSystem.form.label.description" />
								</form:label>
								<form:input path="description" />
							</div>
							<div>
								<button id="form-button-cancel" type="button"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline float-right"
									onclick="ctrl.formDiv.hide()">
									<spring:message code="SecSystem.form.button.cancel" />
								</button>
								<button id="form-button-insert" type="button"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline float-right"
									onmouseover="ctrl.val.validateForm()" onclick="ctrl.insert()">
									<spring:message code="SecSystem.form.button.insert" />
								</button>
								<button id="form-button-update" type="button"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline float-right"
									onclick="ctrl.update()" onmouseover="ctrl.val.validateForm()">
									<spring:message code="SecSystem.form.button.update" />
								</button>
								<button id="form-button-delete" type="button"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline float-right"
									onclick="ctrl.remove()">
									<spring:message code="SecSystem.form.button.delete" />
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>


			<!-- ---------------------------------------------------  -->
			<!-- MAIN TABLE  -->
			<!-- ---------------------------------------------------  -->
			<div class="tablesaw-bar mode-toggle table">
				<div id="secSystemTable-pager" class="pager"></div>
				<table id="secSystemTable" class="tablesaw paginated"
					data-tablesaw-mode="swipe" data-input="#filterTable-input"
					data-tablesaw-sortable="true">
					<thead>
						<tr>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-sortable-default-col
								data-tablesaw-priority="persist"><spring:message
									code="SecSystem.table.th.systemId" /></th>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-priority="2"><spring:message
									code="SecSystem.table.th.name" /></th>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-priority="3"><spring:message
									code="SecSystem.table.th.description" /></th>
							<th scope="col" data-tablesaw-sortable-col
								data-tablesaw-priority="1"></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>


		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>
