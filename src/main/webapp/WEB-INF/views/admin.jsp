<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${ctx}/resources/css/default" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />
<c:set var="today" value="<%=new java.util.Date()%>" />
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBAPP</title>
<link href="${lib}/jqm/1.4.5/jquery.mobile.css" rel="stylesheet" />
<link href="${css}/buttons.css" rel="stylesheet" />
<link href="${css}/div.css" rel="stylesheet" />
<link href="${css}/icons.css" rel="stylesheet" />
<link href="${css}/default.css" rel="stylesheet" />

<script src="${lib}/jq/1.10.2/jquery.js"></script>
<script src="${lib}/jqm/1.4.5/jquery.mobile.js"></script>
<meta http-equiv="X-Frame-Options" content="GOFORIT">


</head>
<body>

	<div data-role="page" id="defaultPage">

		<div data-role="panel" id="menu" data-display="overlay"
			data-position="left">
			<h2>Menu</h2>
			<p>Some text in the panel..</p>
			<a href="#pageone" data-rel="close" class="ui-btn ui-btn-inline">Close
				Panel</a>
		</div>

		<div data-role="panel" id="options" data-display="overlay"
			data-position="right">
			<h2>Options</h2>
			<p>Some text in the panel..</p>
			<a href="#pageone" data-rel="close" class="ui-btn ui-btn-inline">Close
				Panel</a>
		</div>


		<div data-role="header">
			<a href="#menu"
				class="ui-btn ui-shadow ui-corner-all ui-icon-bars ui-btn-icon-notext">Menu</a>

			<h1>Title : ${title}</h1>
			<a href="#options"
				class="ui-btn ui-shadow ui-corner-all ui-icon-grid ui-btn-icon-notext">Options</a>
		</div>
		<div role="main" class="ui-content">
			<h1>Message : ${message}</h1>
			<c:url value="/j_spring_security_logout" var="logoutUrl" />


			<!-- csrt support -->
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			Dear <strong>${user}</strong>, Welcome to Admin Page. <a
				href="<c:url value="/logout" />">Logout</a>
			<div>
				<sec:authorize access="hasRole('APP_ADMIN')">
					<label><a href="#">Edit this page</a> | This part is
						visible only to ADMIN</label>
				</sec:authorize>
			</div>

			<br />
			<div>
				<sec:authorize access="hasRole('APP_ADMIN') and hasRole('APP_DBA')">
					<label><a href="#">Start backup</a> | This part is visible
						only to one who is both ADMIN & DBA</label>
				</sec:authorize>
			</div>
		</div>

	</div>




</body>
</html>