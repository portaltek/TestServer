<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"
	scope="request" />
<sec:authentication var="menuList" property="principal.urlList"
	htmlEscape="false" />
<html>
<body>
	<div class="ui-bar ui-bar-a">
		<h1>HOME</h1>
	</div>
	<div data-role="fieldcontain">
		<input type="password" class="form-control" id="passwords"
			value="admin" name="j_passworsd" placeholder="Enter Password"
			required>
	</div>
	<hr />
	<p />

	<div class="ui-grid-d ui-responsive">
		<c:forEach items="${menuList}" var="m" varStatus="loop">
			<c:set var="column" value="" />
			<c:set var="modal" value="${loop.index%5}" />
			<c:choose>
				<c:when test="${modal==0}">
					<c:set var="column" value="a" />
				</c:when>
				<c:when test="${modal==1}">
					<c:set var="column" value="b" />
				</c:when>
				<c:when test="${modal==2}">
					<c:set var="column" value="c" />
				</c:when>
				<c:when test="${modal==3}">
					<c:set var="column" value="d" />
				</c:when>
				<c:when test="${modal==4}">
					<c:set var="column" value="e" />
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			<div class="ui-block-${column}">
				<div class="ui-bar ui-bar-a" style="height: 60px;">
					<%-- 					${ctx}${m} --%>
					<c:out value="${loop.current}" />
					<c:out value="${column}" />
					<c:out value="${loop.index}" />
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
"
