<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${ctx}/resources/css/default" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBAPP</title>
<%-- <tiles:insertAttribute name="home.libs" /> --%>

<link href="${lib}/jqm/1.4.5/jquery.mobile.css" rel="stylesheet" />
<%-- <link href="${lib}/jqm/default/jquery.mobile.css" rel="stylesheet" /> --%>
<link href="${lib}/fa/css/font-awesome.min.css" rel="stylesheet" />


<link href="${css}/buttons.css" rel="stylesheet" />
<link href="${css}/div.css" rel="stylesheet" />
<link href="${css}/icons.css" rel="stylesheet" />
<link href="${css}/default.css" rel="stylesheet" />


<script src="${lib}/jq/1.10.2/jquery.js"></script>

<script src="${lib}/angular/angular.js"></script>
<%-- <script src="${js}/default.js"></script> --%>

<link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" />
<%-- <script src="${lib}/tablesaw/tablesaw.js"></script> --%>
<%-- <script src="${lib}/tablesaw/tablesaw-init.js"></script> --%>
<%-- <script src="${lib}/jqm/1.4.5/jquery.mobile.js"></script> --%>

</head>
<body>
	<div data-role="page" id="defaultPage">
		<tiles:insertAttribute name="mantto.header" />
		asdf
		<div role="main" class="ui-content">
		asfasfasd
			<tiles:insertAttribute name="mantto.body" />
		</div>
		<%-- 		<tiles:insertAttribute name="home.footer" /> --%>
	</div>
	<script>
		$(function() {
			$(document).prop('title', 'HOME');
			$(".tablesaw-sortable-btn").removeClass("ui-btn");
			$(".tablesaw-sortable-btn").removeClass("ui-shadow");
			$(".tablesaw-sortable-btn").removeClass("ui-corner-all");
		});
	</script>
</body>
</html>