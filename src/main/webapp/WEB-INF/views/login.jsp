<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${ctx}/resources/css/default" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />
<html>
<head>
<title></title>
<link href="${lib}/jqm/1.4.5/jquery.mobile.css" rel="stylesheet" />
<link href="${lib}/fa/css/font-awesome.min.css" rel="stylesheet" />
<link href="${lib}/tablesaw/tablesaw.css" rel="stylesheet" />
<link href="${css}/buttons.css" rel="stylesheet" />
<link href="${css}/div.css" rel="stylesheet" />
<link href="${css}/icons.css" rel="stylesheet" />
<link href="${css}/default.css" rel="stylesheet" />


<script src="${lib}/jq/1.10.2/jquery.js"></script>
<script src="${lib}/jqm/1.4.5/jquery.mobile.js"></script>
<script src="${js}/default.js"></script>
</head>
<body>
	<div class="page">

		<div data-role="header" class="app-header">
			<a href="#" style="display: none"></a>
			<h1>APP NAME</h1>
			<a href="#infoPanel" data-position="right"
				onmouseover="clickOnMouseOver(this)"
				class="ui-btn ui-shadow ui-corner-all ui-icon-info ui-btn-icon-notext">Options</a>
		</div>

		<div data-role="panel" id="infoPanel" data-display="overlay"
			data-position="right">
			<ul data-role="listview" data-inset="false" data-shadow="false">

				<li data-role="listview" data-inset="false" data-icon="info"><a
					href="">Info</a></li>
			</ul>

			<p>
			<p>Some text in the panel..</p>
			<a href="#pageone" data-rel="close" class="ui-btn ui-btn-inline">Close
				Panel</a>
		</div>


		<div class="login-form login-form-div">
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" data-ajax="false"
				class="form-horizontal">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>

				<div data-role="fieldcontain">

					<div class="login-user-input">
						<i class="fa fa-user fa-lg"></i>
					</div>
					<input type="text" class="form-control" id="username" value="admin"
						maxlength="50" name="j_username" placeholder="Enter Username"
						required>
				</div>
				<div data-role="fieldcontain">
					<div class="login-user-input">
						<i class="fa fa-lock fa-lg"></i>
					</div>
					<input type="password" class="form-control" id="password"
						maxlength="50" value="admin" name="j_password"
						placeholder="Enter Password" required>



				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="form-actions">
					<input type="submit" class="btn btn-block btn-primary btn-default"
						value="Log in">
				</div>
			</form>
		</div>
		<div data-role="footer" class="app-header" data-position="fixed">
			<h4></h4>
		</div>
	</div>
</body>
</html>