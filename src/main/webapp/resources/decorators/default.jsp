<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"
	scope="request" />
<sec:authentication var="menuList" property="principal.urlList"
	htmlEscape="false" />

<c:set var="css" value="${ctx}/resources/css/default" scope="request" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />
<c:set var="today" value="<%=new java.util.Date()%>" />
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBAPP</title>
<link href="${lib}/jqm/default/jquery.mobile.css" rel="stylesheet" />
<link href="${lib}/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="${css}/buttons.css" rel="stylesheet" />
<link href="${css}/div.css" rel="stylesheet" />
<link href="${css}/icons.css" rel="stylesheet" />
<link href="${css}/default.css" rel="stylesheet" />

<script src="${lib}/jq/1.10.2/jquery.js"></script>
<script src="${lib}/jqm/1.4.5/jquery.mobile.js"></script>
<script src="${lib}/angular/angular.js"></script>
<script src="${js}/default.js"></script>


<dec:head />


</head>
<body>

	<div data-role="page" id="defaultPage">

		<div data-role="panel" id="menu" data-display="overlay"
			data-inset="false" data-position="left">
			<ul data-role="listview" data-inset="false" data-shadow="false">
				<li data-role="listview" data-inset="false" data-icon="home"><a
					href="${ctx}/home">Home</a></li>

				<c:forEach items="${menuList}" var="m">
					<li data-role="listview" data-iconpos="right" data-inset="false">
						<a href="${ctx}${m}">${ctx}${m}</a>
				</c:forEach>
			</ul>
		</div>

		<div data-role="panel" id="options" data-display="overlay"
			data-position="right" data-inset="false">
			<ul data-role="listview" data-inset="false" data-shadow="false">
				<li data-role="listview" data-inset="false" data-icon="user"><a
					href="">Usuario</a></li>
			</ul>
			<h2>Options</h2>
			<p>Some text in the panel..</p>

			<c:url value="/j_spring_security_logout" var="logoutUrl" />


			<!-- csrt support -->
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<a href="${ctx}/logout" class="ui-btn ui-btn-inline">Logout</a>


		</div>


		<div data-role="header">
			<a href="#menu" onmouseover="clickOnMouseOver(this);"
				class="ui-btn ui-shadow ui-corner-all ui-icon-bars ui-btn-icon-notext ">Menu</a>

			<h1>Title : WEBAPP: ${ctx}</h1>
			<a href="#options" onmouseover="clickOnMouseOver(this)"
				class="ui-btn ui-shadow ui-corner-all ui-icon-grid ui-btn-icon-notext ">Options</a>
		</div>
		<div role="main" class="ui-content">
			<dec:body />
		</div>

	</div>




</body>
</html>