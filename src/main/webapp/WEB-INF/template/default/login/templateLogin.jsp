<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ include file="/WEB-INF/views/template/default.jsp"%> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${ctx}/resources/css/default" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />
<c:set var="today" value="<%=new java.util.Date()%>" />
<html>
<head>
<title></title>
<%-- <link href="${lib}/jqm/1.4.5/jquery.mobile.css" rel="stylesheet" /> --%>
<%-- <link href="${lib}/jqm/default/jquery.mobile.css" rel="stylesheet" /> --%>
<link href="${lib}/fa/css/font-awesome.min.css" rel="stylesheet" />
<%-- <link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" /> --%>

<link href="${css}/buttons.css" rel="stylesheet" />
<link href="${css}/div.css" rel="stylesheet" />
<link href="${css}/icons.css" rel="stylesheet" />
<link href="${css}/default.css" rel="stylesheet" />


<script src="${lib}/jq/1.10.2/jquery.js"></script>
<script src="${lib}/jqm/1.4.5/jquery.mobile.js"></script>
<script src="${lib}/angular/angular.js"></script>
<script src="${js}/default.js"></script>

<script>
$(function(){
    $(document).prop('title', 'LOGIN');
});
</script>
</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header" />
		<div role="main" class="ui-content">
			<%--             <tiles:insertAttribute name="menu" /> --%>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>