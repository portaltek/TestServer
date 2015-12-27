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
<%-- <c:set var="js" value="${ctx}/resources/js" /> --%>
<%-- <c:set var="img" value="${ctx}/resources/img" /> --%>
<c:set var="lib" value="${ctx}/resources/lib" />

<tiles:insertDefinition name="home">
	<tiles:putAttribute name="home.body">
		<head>
<link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" />
<script src="${lib}/tablesaw/tablesaw.js"></script>
<script src="${lib}/tablesaw/tablesaw-init.js"></script>
<script>
	function insert() {
		var ctx = $("#ctx").val();
		var form = $("#secSystemForm").serialize();
		var url = ctx + "/mantto/secSystem/insert";
		$.ajax({
			type : "post",
			data : form,
			url : url,
			dataType : "json",
			async : false,
			success : function(response) {
				var d = JSON.parse(JSON.stringify(response));
				var result = d.RESULT;
				var s = "";
				if (result === "OK") {
					s += "RESULT: " + result;
				} else {
					
				}
				if (result === "ERROR") {
					s += "RESULT: " + result;
					s += "\nMSG: " + d.MSG;
				}

				alert(s);
			},
			error : function(response) {
				var data = JSON.parse(JSON.stringify(response));
				var result = data.RESULT;
				alert("error: " + result);
			}
		});
	}

	$(function() {
		$("#systemId").val("asd");
		$("#name").val("asd");
		$("#description").val("asd");
	});
</script>
		</head>
		<body>
			<h1>
				New
				<spring:message code="object" />
			</h1>
			<c:url var="insertUrl" value="/mantto/secSystem/insert" />
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
						<td><input type="button" value="CANCEL" /></td>
						<td><input type="button" value="SAVE" onclick="insert()" /></td>
					</tr>
				</table>

			</form:form>

			<div id="test">${message}</div>
			<div class="ui-filterable">
				<input id="filterTable-input" data-type="search"> <i
					class="fa fa-plus fa-lg" onclick="ctrl.insert()"></i>
			</div>
			<div class="tablesaw-bar mode-toggle">
				<!-- data-tablesaw-minimap data-tablesaw-mode-switch  data-mode="columntoggle"
		columntoggle
		swipe, stack
		-->
				<table class="tablesaw" data-tablesaw-mode="swipe"
					data-filter="true" data-input="#filterTable-input"
					data-tablesaw-sortable>
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
								data-tablesaw-priority="persist"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="x">
							<tr>
								<td>${ x.systemId }</td>
								<td>${ x.name }</td>
								<td>${ x.description }-</td>
								<td><i class="fa fa-edit fa-lg"></i> <i
									class="fa fa-remove fa-lg"></i></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>
