<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="lib" value="${ctx}/resources/lib" />
<html>
<head>

<script src="${js}/mantto/secSystem/secSystemService.js"></script>
<script src="${js}/mantto/secSystem/secSystemController.js"></script>
<link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" />
<script src="${lib}/tablesaw/tablesaw.js"></script>
<script src="${lib}/tablesaw/tablesaw-init.js"></script>

<script>
	var ctrl = {};
    var serv = new SecSystemService("${ctx}");
    var ctrl = new SecSystemController(serv);

	$(function() {
		var serv = new SecSystemService("${ctx}");
		var ctrl = new SecSystemController(serv);
		serv.test();
		// 		serv.findAll();
	});
</script>


</head>
<body>
	<div id="test" onclick="ctrl.insert()">${message}</div>

	<i class="fa fa-plus fa-lg"></i>
	<div class="tablesaw-bar mode-toggle">
		<!-- data-tablesaw-minimap data-tablesaw-mode-switch  data-mode="columntoggle"
		columntoggle
		swipe, stack
		-->
		<table class="tablesaw" data-tablesaw-mode="swipe"
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
</html>