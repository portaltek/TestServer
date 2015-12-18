<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">

</head>
<tiles:insertDefinition name="login">
	<tiles:putAttribute name="body">
		<div class="login-form login-form-div">
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" class="form-horizontal">
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
	</tiles:putAttribute>
</tiles:insertDefinition>